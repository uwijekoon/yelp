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
	public List<Business> getDefaultRecommendList(User user) throws Exception{
		List<Business> recommendList = new ArrayList<>();
		String selectStatement = "select b.id, b.name, b.stars, b.address from review r, business b where b.id = r.business_id and r.user_id=?";  
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con = ConnectionUtil.createConnection();
			ps = con.prepareStatement(selectStatement);    
			ps.setString(1, user.getId());
			rs = ps.executeQuery();

			while (rs.next()) {
				Business business = new Business();
				business.setId(rs.getString("id"));
				business.setName(rs.getString("name"));
				business.setStars(rs.getDouble("stars"));
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
