package com.ci6205.yelp.servlet;

import java. io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ci6205.yelp.dao.QuerySearchDAO;
import com.ci6205.yelp.entity.Business;
import com.google.gson.Gson;

@WebServlet("/QuerySearchServlet")
public class QuerySearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			String queryStr = request.getParameter("query");
			String method = request.getParameter("method");
			String catCode = request.getParameter("catCode");
			
			double latitude = Double.parseDouble(request.getSession().getAttribute("latitude").toString());
			double longitude = Double.parseDouble(request.getSession().getAttribute("longitude").toString());
			String heading = "";
			
			if(method.equalsIgnoreCase("loadList")) {
				response.setContentType("text/plain");
			    response.setCharacterEncoding("UTF-8");			    
				response.getWriter().write(loadSuggestionsList(queryStr));
			} else if(method.equalsIgnoreCase("loadResult")) {
				String openNow = request.getParameter("openNow");
				boolean openN = false;
				if(null != openNow) {
					openN = Boolean.parseBoolean(openNow);
				}
				if(null == queryStr) {
					queryStr = request.getSession().getAttribute("queryStr").toString();
				}
				if(null == catCode) {
					catCode = request.getSession().getAttribute("catCode").toString();
				}
				
				List<Business> nearByBusinessList = null;
				if(catCode.length() < 1) {
					nearByBusinessList = searchNearestBusinessByName(queryStr);
					heading = "Near by places for " + queryStr;
				} else {
					nearByBusinessList = searchNearestBusinessByCat(catCode, latitude, longitude);
					heading = "The 10 nearest " + queryStr;
				}
				request.getSession().removeAttribute("queryStr");
				request.getSession().removeAttribute("catCode");
				request.getSession().removeAttribute("searchedBusinessList");
				request.getSession().removeAttribute("headingStr");
				request.getSession().setAttribute("queryStr", queryStr);
				request.getSession().setAttribute("catCode", catCode);
				request.getSession().setAttribute("searchedBusinessList", nearByBusinessList);
				request.getSession().setAttribute("headingStr", heading);
				response.setContentType("text/plain");
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write("searchResult.jsp");			
			}		
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}		
	}
	
	private String loadSuggestionsList(String queryStr) throws Exception {
		QuerySearchDAO searchDAO = new QuerySearchDAO();
		List<String> businessNameList = searchDAO.getBusinessList(queryStr);
		List<String> categoryList = searchDAO.getCategoryList(queryStr);
		businessNameList.addAll(categoryList);
		
		return new Gson().toJson(businessNameList);
	}
	
	private List<Business> searchNearestBusinessByName(String businessName) throws Exception {
		QuerySearchDAO searchDAO = new QuerySearchDAO();
		List<Business> businessList = searchDAO.searchNearestBusinessByName(businessName);
		
		return businessList;
	}
	
	private List<Business> searchNearestBusinessByCat(String catCode, double latitude, double longitude) throws Exception {
		QuerySearchDAO searchDAO = new QuerySearchDAO();
		List<Business> businessList = searchDAO.searchNearestBusinessByCategory(catCode, latitude, longitude);
		
		return businessList;
	}
}
