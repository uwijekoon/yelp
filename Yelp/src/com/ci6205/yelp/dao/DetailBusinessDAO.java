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
import com.ci6205.yelp.entity.Attribute;
import com.ci6205.yelp.entity.OpenHours;
import com.ci6205.yelp.entity.Review;
import com.ci6205.yelp.entity.User;
import com.ci6205.yelp.util.ConnectionUtil;

public class DetailBusinessDAO {
	public Business BusinessDetails(String businessId) throws Exception {

		Business business = new Business();

		
		Connection con = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		PreparedStatement ps4 = null;
		PreparedStatement ps5 = null;

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;

				
		
		try{
			String selectStatement1 = "select name,id,stars, review_count,address, city, business_state, postal_code, "
					+ "latitude, longitude, neighbourhood from business where id=?";
			String selectStatement2 = "select attribute_name,sub_category, attribute_value from attribute "
					+ "where business_id=?";
			String selectStatement3 = "select open_hours_day,from_time,to_time from open_hours where business_id=?";
			String selectStatement4 = "select category_name from business_category where business_id=?";
			String selectStatement5 = "select min(b.id) r_u_id, b.name r_user_name, min(review_date) r_date, min(stars) r_stars, "
					+ "min(text) r_text, min(a.useful) r_useful, min(a.funny) r_funny, min(a.cool) r_cool, "
					+ "min(b.review_count) u_review_count, count(distinct f.id) num_friend,"
					+ "(case when min(e.elite_year) > 0 then "
					+ "year(current_date()) - min(e.elite_year) + 1 else 0 end)*100 + "
					+ "(max(b.useful) + max(b.cool)) review_sort_order from review a inner join user b on "
					+ "a.user_id = b.id inner join friends f on (f.user_id_1 = b.id or f.user_id_2 = b.id)"
					+ "left outer join elite e on e.user_id = a.user_id where business_id=?"
					+ "group by b.name, a.id order by (case when min(e.elite_year) > 0 then "
					+ "year(current_date()) - min(e.elite_year) + 1 else 0 end)*100 + "
					+ "(max(b.useful) + max(b.cool)) desc limit 0,20"; 
			
			
			con = ConnectionUtil.createConnection();

			ps1 = con.prepareStatement(selectStatement1);    
			ps1.setString(1, businessId);
			System.out.println("Retriving business details");
			rs1 = ps1.executeQuery();

			if (rs1.next()) {
				business.setId(rs1.getString("id"));
				business.setName(rs1.getString("name"));
				business.setStars(rs1.getDouble("stars"));
				business.setReviewCount(rs1.getInt("review_count"));
				business.setAddress(rs1.getString("address"));
				business.setCity(rs1.getString("city"));
				business.setBusinessState(rs1.getString("business_state"));
				business.setPostalCode(rs1.getString("postal_code"));
				business.setLatitude(rs1.getDouble("latitude"));
				business.setLongitude(rs1.getDouble("longitude"));
				business.setNeighbourhood(rs1.getString("neighbourhood"));

				List<Attribute> attributeList = new ArrayList<Attribute>();
				ps2 = con.prepareStatement(selectStatement2);    
				ps2.setString(1, businessId);
				System.out.println("Retriving attribute details");
				rs2 = ps2.executeQuery();
				
				while(rs2.next()){
					Attribute attribute = new Attribute();
					
					attribute.setAttributeName(rs2.getString("attribute_name"));
					attribute.setSubCategory(rs2.getString("sub_category"));
					attribute.setAttributeValue(rs2.getString("attribute_value"));
					attributeList.add(attribute);
					continue;
				}
				business.setAttributeList(attributeList);
			
				List<OpenHours> openHoursList = new ArrayList<OpenHours>();
				ps3 = con.prepareStatement(selectStatement3);    
				ps3.setString(1, businessId);
				System.out.println("Retriving open hours details");
				rs3 = ps3.executeQuery();
				while(rs3.next()){
					OpenHours openHours = new OpenHours();
					
					openHours.setDay(rs3.getString("open_hours_day"));
					openHours.setFromTime(rs3.getString("from_time"));
					openHours.setToTime(rs3.getString("to_time"));
					openHoursList.add(openHours);
					continue;
				}
				business.setOpenHours(openHoursList);
				
				List<String> categoryList = new ArrayList<String>(); 
				ps4 = con.prepareStatement(selectStatement4);    
				ps4.setString(1, businessId);
				System.out.println("Retriving category details");
				rs4 = ps4.executeQuery();
				while(rs4.next()){
					categoryList.add(rs4.getString("category_name"));
					continue;
				}
				business.setCategoryList(categoryList);
				
				List<Review> reviewList = new ArrayList<Review>();
				ps5 = con.prepareStatement(selectStatement5);    
				ps5.setString(1, businessId);
				System.out.println("Retriving review details");
				rs5 = ps5.executeQuery();
				while(rs5.next()){
					Review review = new Review();
					User user = new User();
					
					user.setId(rs5.getString("r_u_id"));
					user.setName(rs5.getString("r_user_name"));
					review.setReviewDate(rs5.getDate("r_date"));
					review.setStars(rs5.getDouble("r_stars"));
					review.setText(rs5.getString("r_text"));
					review.setUseful(rs5.getInt("r_useful"));
					review.setFunny(rs5.getInt("r_funny"));
					review.setCool(rs5.getInt("r_cool"));
					user.setReviewCount(rs5.getInt("u_review_count"));
					user.setFriendsCount(rs5.getInt("num_friend"));
					review.setUser(user);
					reviewList.add(review);
					continue;
				}
				business.setReviews(reviewList);					
			}
		}
		finally{
			if(rs1 != null) rs1.close();
			if(ps1 != null) ps1.close();
			if(rs2 != null) rs2.close();
			if(ps2 != null) ps2.close();
			if(rs3 != null) rs3.close();
			if(ps3 != null) ps3.close();
			if(rs4 != null) rs4.close();
			if(ps4 != null) ps4.close();
			if(rs5 != null) rs5.close();
			if(ps5 != null) ps5.close();		
			if(con != null) con.close();
		}	
		
		return business;
	}
}
