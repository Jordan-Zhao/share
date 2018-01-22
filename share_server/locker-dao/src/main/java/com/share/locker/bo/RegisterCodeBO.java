package com.share.locker.bo;

/**
 * 注册码
 * 
 * @author Jordan
 *
 */
public class RegisterCodeBO extends BaseBO {
	private Long id;
	private Long userId;
	private String registerCode;
	private Integer expireTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRegisterCode() {
		return registerCode;
	}
	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}
	public Integer getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

	
}
