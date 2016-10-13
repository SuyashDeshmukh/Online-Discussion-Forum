package model;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {
	int topicid;
	String userid;
	String topicname;
	String comment;
	Date date;
	public Topic()
	{
	
	}
	public Topic(int topicid, String userid, String topicname, String comment,
			Date date) {
		super();
		this.topicid = topicid;
		this.userid = userid;
		this.topicname = topicname;
		this.comment = comment;
		this.date = date;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTopicname() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
