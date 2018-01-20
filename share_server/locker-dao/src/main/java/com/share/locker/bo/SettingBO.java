package com.share.locker.bo;

/**
 * 配置数据
 * 
 * @author Jordan
 *
 */
public class SettingBO extends BaseBO {
	private Integer id;
	private String type;
	private String key;
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
