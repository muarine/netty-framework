package com.netty.muarine.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * User.
 * 
 * @author Muarine maoyun@rtmap.com
 * @since 0.1
 */
public class User implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7055618891413145479L;

	/**
	 * 主键ID
	 */
	private Long id;
	/**
	 * 真是姓名
	 */
	private String nickname;
	/**
	 * 登录名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("id=").append(id);
		sb.append(", nickname='").append(nickname).append('\'');
		sb.append(", username='").append(username).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", createTime=").append(createTime);
		sb.append('}');
		return sb.toString();
	}
}