package com.share.locker.web.dto;

import java.util.Date;

/**
 * server 与app的传输对象。 订单DTO
 * 
 * @author Jordan
 *
 */
public class OrderDTO {
	private Long orderId;
	private Long itemId;
	private Float deposit;
	private String title;
	private Date createTime;
	private String status;
	private String lockerId;
	private String machineName;
	private String takeQrcode;

	private String itemSmallImgUrl;
	private String priceStr;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Float getDeposit() {
		return deposit;
	}
	public void setDeposit(Float deposit) {
		this.deposit = deposit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLockerId() {
		return lockerId;
	}
	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getTakeQrcode() {
		return takeQrcode;
	}
	public void setTakeQrcode(String takeQrcode) {
		this.takeQrcode = takeQrcode;
	}
	public String getItemSmallImgUrl() {
		return itemSmallImgUrl;
	}
	public void setItemSmallImgUrl(String itemSmallImgUrl) {
		this.itemSmallImgUrl = itemSmallImgUrl;
	}
	public String getPriceStr() {
		return priceStr;
	}
	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	
	
}
