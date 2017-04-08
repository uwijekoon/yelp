package com.ci6205.yelp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ci6205.yelp.dao.RecommendationDAO;
import com.ci6205.yelp.entity.Business;
import com.ci6205.yelp.entity.User;

@WebServlet("/RecommendServlet")
public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RecommendServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecommendationDAO dao = new RecommendationDAO();
		User user = (User) request.getSession().getAttribute("user");
		List<Business> recommendList = new ArrayList<>();
		try {
			recommendList = dao.getRecommendationList(user, "restaurants");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("recommendList", recommendList);
		response.sendRedirect("recommendations.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
