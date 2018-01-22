package com.share.locker.bo;

/**
 * 用户
 * 
 * @author Jordan
 *
 */
public class UserBO extends BaseBO {
	private Long userId;
	private Integer phoneCountry;
	private String phoneNumber;
	private String email;
	private String password;
	private String wechatId;
	private String nick;
	private String alipayId;
	private String minIconUrl;
	private String midIconUrl;
	private String maxIconUrl;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getPhoneCountry() {
		return phoneCountry;
	}
	public void setPhoneCountry(Integer phoneCountry) {
		this.phoneCountry = phoneCountry;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAlipayId() {
		return alipayId;
	}
	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}
	public String getMinIconUrl() {
		return minIconUrl;
	}
	public void setMinIconUrl(String minIconUrl) {
		this.minIconUrl = minIconUrl;
	}
	public String getMidIconUrl() {
		return midIconUrl;
	}
	public void setMidIconUrl(String midIconUrl) {
		this.midIconUrl = midIconUrl;
	}
	public String getMaxIconUrl() {
		return maxIconUrl;
	}
	public void setMaxIconUrl(String maxIconUrl) {
		this.maxIconUrl = maxIconUrl;
	}

}
