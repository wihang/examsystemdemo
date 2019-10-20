package com.xiaoyingjie.vo;
/** 
 * @author XiaoYingJie
 * @date 创建时间：2019年10月20日 下午5:39:01 
 * @version 1.0 
 **/
public class Student {
	private String id;
	private String stuName;
	private int score;
 
	public String getId() {
		return id;
	}
 
	public void setId(String id) {
		this.id = id;
	}
 
	public String getStuName() {
		return stuName;
	}
 
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
 
	public int getScore() {
		return score;
	}
 
	public void setScore(int score) {
		this.score = score;
	}
 
	public Student(String id, String stuName, int score) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.score = score;
	}
 
	public Student() {
		super();
	}

}
