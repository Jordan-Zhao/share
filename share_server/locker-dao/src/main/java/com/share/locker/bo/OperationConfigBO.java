package com.share.locker.bo;

/**
 * 运营配置数据
 * 
 * @author Jordan
 *
 */
public class OperationConfigBO extends BaseBO {
	private Integer id;
	private String configCode;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigCode() {
		return configCode;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
