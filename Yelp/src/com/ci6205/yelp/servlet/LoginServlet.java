package com.ci6205.yelp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ci6205.yelp.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		double locationX = 0;
		double locationY = 0;
		try{
			locationX = Double.parseDouble(request.getParameter("locationX"));
			locationY = Double.parseDouble(request.getParameter("locationY"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		User user = new User(userId, locationX, locationY);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("latitude", locationX);
		request.getSession().setAttribute("longitude", locationY);
	//	response.sendRedirect("RecommendServlet");
		response.sendRedirect("mainSearch.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
