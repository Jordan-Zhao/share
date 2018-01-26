package com.share.locker.bo;

/**
 * 注册码
 * 
 * @author Jordan
 *
 */
public class RegisterCodeBO extends BaseBO {
	private Long id;
	private String registerId;
	private String registerCode;
	private Long expireTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	

}
