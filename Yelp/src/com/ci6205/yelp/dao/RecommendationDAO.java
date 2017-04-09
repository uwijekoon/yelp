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
import com.ci6205.yelp.entity.User;
import com.ci6205.yelp.util.ConnectionUtil;

public class RecommendationDAO {
	public List<Business> getRecommendationList(User user, String category, boolean filterNearBy, boolean filterOpenNow, double longitude, double latitude) throws Exception{
		List<Business> recommendList = new ArrayList<>();
		String selectStatement = "select distinct id,business_stars,name,address from (select b.id,b.stars as business_stars,r.stars, b.name,"
				+ "b.address, count(*) as count";
			
		if(filterNearBy){
			selectStatement	+=" ,( 3959 * acos( cos( radians(?) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(?) )  "
					+ "+ sin( radians(?) ) * sin( radians( latitude ) ) ) ) AS distance ";
		}		
				
		selectStatement	+= " from friends f, review r, business b, business_category bc, category c ";
		if(filterOpenNow){
			selectStatement	+= ", open_hours o ";
		}
		
		selectStatement += " where f.user_id_2=r.user_id and  b.id=r.business_id  and bc.business_id = b.id and bc.category_code = c.category_code  ";
		
		if(filterOpenNow){
			selectStatement += " and o.business_id=b.id and o.open_hours_day=? "
					+ "and (? between SUBSTRING_INDEX(from_time, ':', 1) and SUBSTRING_INDEX(to_time, ':', 1)) ";
		}
		
		selectStatement += "and f.user_id_1=?  and c.category_code=?";
		
		selectStatement += " group by b.id,r.stars,b.stars,b.name ";
		
		if(filterNearBy){
			selectStatement	+= "having distance < 20 ";
		}
		
		selectStatement += " order by count desc) as t1 limit 50";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			int i = 1;
			if(filterOpenNow){
				DateFormat formatter = new SimpleDateFormat("EEEE");
				ps.setString(i++, formatter.format(new Date()));
				formatter = new SimpleDateFormat("HH");
				ps.setInt(i++, (Integer.parseInt(formatter.format(new Date()))));
			}
			
			if(filterNearBy){
				ps.setDouble(i++, latitude);
				ps.setDouble(i++, longitude);
				ps.setDouble(i++, latitude);
			}
			ps.setString(i++, user.getId());
			ps.setString(i++, category);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				Business business = new Business();
				business.setId(rs.getString("id"));
				business.setName(rs.getString("name"));
				business.setStars(rs.getDouble("business_stars"));
				business.setAddress(rs.getString("address"));
				recommendList.add(business);
			} 
		}
		finally{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return recommendList;
	}
	
	
}
