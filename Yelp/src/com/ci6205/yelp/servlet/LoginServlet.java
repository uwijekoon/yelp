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
		double longitude = 0;
		double latitude = 0;
		try{
			longitude = Double.parseDouble(request.getParameter("longitude"));
			latitude = Double.parseDouble(request.getParameter("latitude"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		User user = new User(userId, longitude, latitude);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("latitude", latitude);
		request.getSession().setAttribute("longitude", longitude);
		response.sendRedirect("RecommendServlet");
		//response.sendRedirect("mainSearch.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
