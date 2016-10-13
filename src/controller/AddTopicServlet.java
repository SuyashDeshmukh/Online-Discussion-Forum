package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
 * Servlet implementation class AddTopicServlet
 */
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=null;
		String message=null;
		HttpSession session = request.getSession();
		user=(User)session.getAttribute("user");
		if(user!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("AddTopic.jsp");
			rd.forward(request, response);		
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = null;
		Topic topic=null;
		String message=null;
		HttpSession session=request.getSession();
		user=(User)session.getAttribute("user");
		
		if(user==null)
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else
		{
			
			String userid = user.getEmail();
			String topicname=request.getParameter("topic");
			String comment=request.getParameter("Comment");
			if(topicname==null || topicname.trim().equals(""))
			{
				message="Topic Name cannot be Blank";
				
			}
			else if(comment==null || comment.trim().equals(""))
			{
				message="Please Enter comment";
				System.out.println(message);
			}
			else
			{
				ArrayList<Topic> topics = new ArrayList<Topic>();
				topic=new Topic();
				topic.setUserid(userid);
				topic.setTopicname(topicname);
				topic.setComment(comment);
				topic.setDate(new Date());
				
				try {
					DAO.saveTopic(topic);
					System.out.println("Topic Saved");
					
				} catch (SQLException | TopicException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					topics = DAO.getTopics(userid);
					request.setAttribute("topics", topics);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd=request.getRequestDispatcher("UserTopics.jsp");
				rd.forward(request, response);
				
			}
			
			
			
		}
	}

}
