package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DAO;

import model.Topic;
import model.User;

/**
 * Servlet implementation class SearchTopicServlet
 */
public class SearchTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=null;
		HttpSession session = request.getSession();
		System.out.println("Search Link");
		user=(User)session.getAttribute("user");
		if(user==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("SearchTopic.jsp");
			rd.forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		String key = request.getParameter("pass");
		HttpSession session = request.getSession();
		System.out.println("Search post");
		user=(User)session.getAttribute("user");
		if(user==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else
		{
			
			System.out.println(key);
			try {
				topics=DAO.searchTopic(key);
				request.setAttribute("topics",topics);
				RequestDispatcher rd = request.getRequestDispatcher("SearchResults.jsp");
				rd.forward(request, response);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
