package com.share.locker.bo;

/**
 * 二维码
 * 
 * @author Jordan
 *
 */
public class QrcodeBO extends BaseBO {
	private Long qrcodeId;
	private Long itemId;
	private Long orderId;
	private String type;
	private Integer expireTime;
	public Long getQrcodeId() {
		return qrcodeId;
	}
	public void setQrcodeId(Long qrcodeId) {
		this.qrcodeId = qrcodeId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

}
