package com.share.locker.bo;

/**
 * Locker 柜门
 * 
 * @author Jordan
 *
 */
public class LockerBO extends BaseBO {
	private Long lockerId;
	private Long machineId;
	private Integer width;
	private Integer height;
	private Integer length;
	private String location;
	private Float latitude;
	private Float longitude;

	private MachineBO machineBO;

	public Long getLockerId() {
		return lockerId;
	}

	public void setLockerId(Long lockerId) {
		this.lockerId = lockerId;
	}

	public Long getMachineId() {
		return machineId;
	}

	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public MachineBO getMachineBO() {
		return machineBO;
	}

	public void setMachineBO(MachineBO machineBO) {
		this.machineBO = machineBO;
	}

}
