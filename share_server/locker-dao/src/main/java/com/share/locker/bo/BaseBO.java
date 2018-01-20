package com.share.locker.bo;

import java.util.Date;

/**
 * 每个表都有的字段
 * 
 * @author Jordan
 *
 */
public class BaseBO {

	private Date createTime;
	private Date editTime;
	private String editor;
	private String status;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
