package com.ci6205.yelp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ci6205.yelp.entity.Business;
import com.ci6205.yelp.util.ConnectionUtil;

public class QuerySearchDAO {

	public List<String> getBusinessList(String queryStr) throws Exception{
		List<String> businessList = new ArrayList<String>();
		String selectStatement = "select name from business where name like ? order by name limit 5";  
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			ps.setString(1, queryStr+"%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String businessInfo = "<p><span id='code' style='display:none'></span>"
						+ "<img src='resources/images/place.png' width='20' height='20' /> " 
						+ rs.getString("name");
				businessList.add(businessInfo);
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return businessList;
	}
	
	public List<String> getCategoryList(String queryStr) throws Exception{
		List<String> categoryList = new ArrayList<String>();
		String selectStatement = "select category_name, category_code from category where category_name like ? order by category_name limit 5";  
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			ps.setString(1, queryStr+"%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String categoryInfo = "<p><span id='code' style='display:none'>"+rs.getString("category_code")+"</span>"
						+ "<img src='resources/images/cat.png' width='20' height='20' /> " 
						+ rs.getString("category_name");
				categoryList.add(categoryInfo);
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return categoryList;
	}
	
	public List<Business> searchNearestBusinessByName(String businessName) throws Exception {
		List<Business> businessList = new ArrayList<Business>();		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement nearestPs = null;
		ResultSet rs = null;
		ResultSet nearestRs = null;
		
		Business business = null;
		Business nearestBs = null;
		
		try{
			String selectStatement = "select id, name, stars, address, latitude, longitude from business where name=?";
			String searchNearest = "SELECT id, name, stars, address, latitude, longitude, ( 3959 * acos( cos( radians(?) ) "
					+ "* cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?) ) "
					+ " + sin( radians(?) ) * sin( radians( latitude ) ) ) ) "
					+ "AS distance FROM business HAVING distance < 10 ORDER BY distance LIMIT 0 , 10";
			
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			ps.setString(1, businessName);
			rs = ps.executeQuery();

			while (rs.next()) {
				business = new Business();
				business.setId(rs.getString("id"));
				business.setName(rs.getString("name"));
				business.setStars(rs.getDouble("stars"));
				business.setAddress(rs.getString("address"));
				business.setLatitude(rs.getDouble("latitude"));
				business.setLongitude(rs.getDouble("longitude"));
				businessList.add(business);
				
				nearestPs = con.prepareStatement(searchNearest);
				nearestPs.setDouble(1, business.getLatitude());
				nearestPs.setDouble(2, business.getLongitude());
				nearestPs.setDouble(3, business.getLatitude());
				
				nearestRs = nearestPs.executeQuery();
				while(nearestRs.next()) {
					nearestBs = new Business();
					String name = nearestRs.getString("name");
					if(name.equalsIgnoreCase(businessName)) {
						continue;
					}
					nearestBs.setId(nearestRs.getString("id"));
					nearestBs.setName(nearestRs.getString("name"));
					nearestBs.setStars(nearestRs.getDouble("stars"));
					nearestBs.setAddress(nearestRs.getString("address"));
					nearestBs.setLatitude(nearestRs.getDouble("latitude"));
					nearestBs.setLongitude(nearestRs.getDouble("longitude"));
					businessList.add(nearestBs);
				}				
			}			
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			
			if(nearestRs != null) nearestRs.close();
			if(nearestPs != null) nearestPs.close();
			if(con != null) con.close();
		}		
		return businessList;
	}
	
	public List<Business> searchNearestBusinessByCategory(String catCode, double latitude, double longitude) throws Exception {
		List<Business> businessList = new ArrayList<Business>();		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Business business = null;
		
		try{
			String searchNearest = "select * from ( "
					+ "SELECT b.id, b.name, b.stars, b.address, b.latitude, b.longitude, ( 3959 * acos( cos( radians(?) ) "
					+ "* cos( radians( b.latitude ) ) * cos( radians( b.longitude ) - radians(?) ) "
					+ "+ sin( radians(?) ) * sin( radians( b.latitude ) ) ) ) "
					+ "AS distance FROM business b "
					+ "HAVING distance < 10 ORDER BY distance) as nearByBusiness, business_category bc, open_hours oh "
					+ "where nearByBusiness.id = bc.business_id and bc.category_code=? limit 10";
			
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(searchNearest);    
			ps.setDouble(1, latitude);
			ps.setDouble(2, longitude);
			ps.setDouble(3, latitude);
			ps.setString(4, catCode);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				business = new Business();
				business.setId(rs.getString("id"));
				business.setName(rs.getString("name"));
				business.setStars(rs.getDouble("stars"));
				business.setAddress(rs.getString("address"));
				business.setLatitude(rs.getDouble("latitude"));
				business.setLongitude(rs.getDouble("longitude"));
				businessList.add(business);				
			}			
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}		
		return businessList;
	}
	
	private String appendToQuery(String query, boolean checkOpenNow) {
		if(checkOpenNow) {
			DateFormat dFormat = new SimpleDateFormat("EEEE"); 
			String today = dFormat.format(new Date());
			
			query.replace("@OPENHRS", " and oh.open_hours_day = ? and from_time ");
			
		}
		
		return query;
	}
	
}
