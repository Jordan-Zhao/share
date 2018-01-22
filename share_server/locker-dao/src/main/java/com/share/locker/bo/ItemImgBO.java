package com.share.locker.bo;

/**
 * 商品图片URL
 * 
 * @author Jordan
 *
 */
public class ItemImgBO extends BaseBO {
	private Long id;
	private Long itemId;
	private String imgSizeCode;
	private String url;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getImgSizeCode() {
		return imgSizeCode;
	}
	public void setImgSizeCode(String imgSizeCode) {
		this.imgSizeCode = imgSizeCode;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
