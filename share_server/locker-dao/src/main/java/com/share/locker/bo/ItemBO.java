package com.share.locker.bo;

/**
 * 商品
 * 
 * @author Jordan
 *
 */
public class ItemBO extends BaseBO {
	private Long itemId;
	private Long userId;
	private String title;
	private String priceTimeUnit;
	private Integer priceTime;
	private Integer price;
	private Integer deposit;
	private String lockerSizeCode;
	private Long lockerId;
	private String publishStatus;
	private String description;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPriceTimeUnit() {
		return priceTimeUnit;
	}
	public void setPriceTimeUnit(String priceTimeUnit) {
		this.priceTimeUnit = priceTimeUnit;
	}
	public Integer getPriceTime() {
		return priceTime;
	}
	public void setPriceTime(Integer priceTime) {
		this.priceTime = priceTime;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public String getLockerSizeCode() {
		return lockerSizeCode;
	}
	public void setLockerSizeCode(String lockerSizeCode) {
		this.lockerSizeCode = lockerSizeCode;
	}
	public Long getLockerId() {
		return lockerId;
	}
	public void setLockerId(Long lockerId) {
		this.lockerId = lockerId;
	}
	public String getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(String publishStatus) {
		this.publishStatus = publishStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}
