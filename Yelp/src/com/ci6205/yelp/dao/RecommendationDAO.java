package com.ci6205.yelp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ci6205.yelp.entity.Business;
import com.ci6205.yelp.entity.User;
import com.ci6205.yelp.util.ConnectionUtil;

public class RecommendationDAO {
	public List<Business> getRecommendationList(User user, String category) throws Exception{
		List<Business> recommendList = new ArrayList<>();
		String selectStatement = "select distinct id,business_stars,name,address from (select b.id,b.stars as business_stars,r.stars, b.name,"
				+ "b.address, count(*) as count from friends f, review r, business b, business_category bc, category c "
				+ " where f.user_id_2=r.user_id and "
				+ "b.id=r.business_id and f.user_id_1=? "
				+ "and bc.business_id = b.id and bc.category_code = c.category_code and c.category_code=? "
				+ "group by b.id,r.stars,b.stars,b.name order by count desc) as t1 limit 50";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			ps.setString(1, user.getId());
			ps.setString(2, category);
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
