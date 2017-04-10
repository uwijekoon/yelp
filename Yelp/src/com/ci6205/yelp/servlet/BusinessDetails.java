package com.ci6205.yelp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ci6205.yelp.dao.DetailBusinessDAO;
import com.ci6205.yelp.entity.Business;


@WebServlet("/BusinessDetails")
public class BusinessDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BusinessDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DetailBusinessDAO dao = new DetailBusinessDAO();
		
		String business_id = request.getParameter("id");
		
		Business business = new Business();
		try {
			business = dao.BusinessDetails(business_id);
			//business = dao.BusinessDetails("--I7YYLada0tSLkORTHb5Q");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("business", business);
		response.sendRedirect("details.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
