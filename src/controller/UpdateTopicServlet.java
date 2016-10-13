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
import model.TopicException;
import model.User;

/**
 * Servlet implementation class UpdateTopicServlet
 */
public class UpdateTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=null;
		Topic topic=null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		HttpSession session = request.getSession();
		user=(User)session.getAttribute("user");
		String email= user.getEmail();
		String comment=(String)request.getParameter("Comment");
		if(user==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			//topic=new Topic();
			
			int id =Integer.parseInt(request.getParameter("id"));
			
			try {
				DAO.updateTopic(id,comment);
				RequestDispatcher rd = request.getRequestDispatcher("MyTopics");
				rd.forward(request, response);
				
			} catch (SQLException | TopicException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				topics=DAO.getTopics(email);
				request.setAttribute("topics",topics);
				RequestDispatcher rd = request.getRequestDispatcher("UserTopics.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			
		}
	}

}
