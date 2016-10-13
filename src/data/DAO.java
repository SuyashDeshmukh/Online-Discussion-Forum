package data;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.Topic;
import model.TopicException;
import model.User;

public class DAO {

	public static void saveUserData(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DBConnection.getConnection();
		System.out.println("Database connection ready");
		
		PreparedStatement ps = con.prepareStatement("Insert into user values(?,?,?,?,?,?,?)");
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getCpassword());
		ps.setString(4, user.getName());
		ps.setString(5, user.getGender());
		ps.setInt(6, user.getAge());
		ps.setString(7, user.getCity());
		
		ps.executeUpdate();
		System.out.println("Data inserted into table");
	}

	public static User getUser(String email) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DBConnection.getConnection();
		User user=null;
		ResultSet rs=null;
		PreparedStatement ps =con.prepareStatement("Select * from user where email=?");
		ps.setString(1, email);
		rs=ps.executeQuery();
		while(rs.next())
		{
			user=new User();
			user.setEmail(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setCpassword(rs.getString(3));
			user.setName(rs.getString(4));
			user.setGender(rs.getString(5));
			user.setAge(rs.getInt(6));
			user.setCity(rs.getString(7));
		}
		
		return user;
	}

	public static void saveTopic(Topic topic) throws SQLException, TopicException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps =null;
		int rows=0;
		con = DBConnection.getConnection();
		ps=con.prepareStatement("Insert into topic(userid,topicname,comment,date)values(?,?,?,?)");
		ps.setString(1,topic.getUserid());
		ps.setString(2, topic.getTopicname());
		ps.setString(3, topic.getComment());
		ps.setTimestamp(4, new java.sql.Timestamp(topic.getDate().getTime()));
		rows=ps.executeUpdate();
		
		if(rows==-1)
		{
			throw new TopicException();
		}
		
	}

	public static ArrayList<Topic> getTopics(String userid) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Topic topic=null;
		con=DBConnection.getConnection();
		User user=null;
		ResultSet rs=null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		PreparedStatement ps =con.prepareStatement("Select * from topic where userid=?");
		ps.setString(1, userid);
		rs=ps.executeQuery();
		while(rs.next())
		{
			topic=new Topic();
			topic.setTopicid(rs.getInt(1));
			topic.setUserid(rs.getString(2));
			topic.setTopicname(rs.getString(3));
			topic.setComment(rs.getString(4));
			topic.setDate(rs.getTimestamp(5));
			topics.add(topic);
		}
		
		return topics;
	}

	public static Topic getTopic(int userid) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Topic topic=null;
		con=DBConnection.getConnection();
		User user=null;
		ResultSet rs=null;
		PreparedStatement ps =con.prepareStatement("Select * from topic where topicid=?");
		ps.setInt(1, userid);
		rs=ps.executeQuery();
		while(rs.next())
		{
			topic = new Topic();
			topic.setTopicid(rs.getInt(1));
			topic.setUserid(rs.getString(2));
			topic.setTopicname(rs.getString(3));
			topic.setComment(rs.getString(4));
			topic.setDate(rs.getTimestamp(5));
		
			
		}
		
		
		return topic;
	}

	public static void updateTopic(int id, String comment) throws SQLException, TopicException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps =null;
		int rows=0;
		con = DBConnection.getConnection();
		ps=con.prepareStatement("Update topic set comment=? where topicid=?");
		ps.setString(1,comment);
		ps.setInt(2, id);
		
		
		rows=ps.executeUpdate();
		
		if(rows==-1)
		{
			throw new TopicException();
		}
		
		
		
	}

	public static ArrayList<Topic> listTopics() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Topic topic=null;
		con=DBConnection.getConnection();
		User user=null;
		ResultSet rs=null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		PreparedStatement ps =con.prepareStatement("Select * from topic");
		
		rs=ps.executeQuery();
		while(rs.next())
		{
			topic=new Topic();
			topic.setTopicid(rs.getInt(1));
			topic.setUserid(rs.getString(2));
			topic.setTopicname(rs.getString(3));
			topic.setComment(rs.getString(4));
			topic.setDate(rs.getTimestamp(5));
			topics.add(topic);
		}
		
		return topics;
		
	}

	public static ArrayList<Topic> searchTopic(String key) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Topic topic=null;
		con=DBConnection.getConnection();
		User user=null;
		ResultSet rs=null;
		ArrayList<Topic> topics = new ArrayList<Topic>();
		String query ="select * from topic where topicname like '%" + key + "%'";
		
		java.sql.Statement ps = con.createStatement();
		
		rs=ps.executeQuery(query);
		
		while(rs.next())
		{
			topic=new Topic();
			topic.setTopicid(rs.getInt(1));
			topic.setUserid(rs.getString(2));
			topic.setTopicname(rs.getString(3));
			topic.setComment(rs.getString(4));
			topic.setDate(rs.getTimestamp(5));
			topics.add(topic);
		}
		
		for(Topic topic1:topics)
		{
			System.out.println(topic.getTopicname());
		}
		return topics;
		
		
		
	}

}
