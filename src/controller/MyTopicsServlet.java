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
 * Servlet implementation class MyTopicsServlet
 */
public class MyTopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTopicsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		User user=null;
		ArrayList<Topic> topics=new ArrayList<Topic>();
		user=(User)session.getAttribute("user");
		String userid = user.getEmail();
		try {
			topics=DAO.getTopics(userid);
			request.setAttribute("topics", topics);
			RequestDispatcher rd = request.getRequestDispatcher("UserTopics.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		User user=null;
		ArrayList<Topic> topics=new ArrayList<Topic>();
		user=(User)session.getAttribute("user");
		String userid = user.getEmail();
		try {
			topics=DAO.getTopics(userid);
			request.setAttribute("topics", topics);
			RequestDispatcher rd = request.getRequestDispatcher("UserTopics.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
