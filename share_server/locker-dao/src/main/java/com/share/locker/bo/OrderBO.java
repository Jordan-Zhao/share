package com.share.locker.bo;

import java.util.Date;

/**
 * 订单
 * 
 * @author Jordan
 *
 */
public class OrderBO extends BaseBO {
	private Integer orderId;
	private Integer itemId;
	private Integer ownerId;
	private Integer renterId;
	private Integer deposit;
	private String title;
	private Date takeTime;
	private Integer fee;
	private Integer returnLockerId;
	private Date returnTime;
	private Date checkTime;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getRenterId() {
		return renterId;
	}

	public void setRenterId(Integer renterId) {
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

	public Integer getReturnLockerId() {
		return returnLockerId;
	}

	public void setReturnLockerId(Integer returnLockerId) {
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
