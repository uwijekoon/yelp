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
		long locationX = 0;
		long locationY = 0;
		try{
			locationX = Long.parseLong(request.getParameter("locationX"));
			locationY = Long.parseLong(request.getParameter("locationY"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		User user = new User(userId, locationX, locationY);
		request.getSession().setAttribute("user", user);
		response.sendRedirect("RecommendServlet");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
