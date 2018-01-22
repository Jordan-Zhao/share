package com.share.locker.bo;

import java.util.Date;

/**
 * 订单
 * 
 * @author Jordan
 *
 */
public class OrderBO extends BaseBO {
	private Long orderId;
	private Long itemId;
	private Long ownerId;
	private Long renterId;
	private Integer deposit;
	private String title;
	private Date takeTime;
	private Integer fee;
	private Long returnLockerId;
	private Date returnTime;
	private Date checkTime;
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
	public Long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	public Long getRenterId() {
		return renterId;
	}
	public void setRenterId(Long renterId) {
		this.renterId = renterId;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getTakeTime() {
		return takeTime;
	}
	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}
	public Integer getFee() {
		return fee;
	}
	public void setFee(Integer fee) {
		this.fee = fee;
	}
	public Long getReturnLockerId() {
		return returnLockerId;
	}
	public void setReturnLockerId(Long returnLockerId) {
		this.returnLockerId = returnLockerId;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	
}
