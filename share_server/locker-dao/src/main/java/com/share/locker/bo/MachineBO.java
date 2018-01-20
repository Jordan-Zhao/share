package com.share.locker.bo;

/**
 * Machine 机柜
 * 
 * @author Jordan
 *
 */
public class MachineBO extends BaseBO {
	private Integer machineId;
	private String location;

	public Integer getMachineId() {
		return machineId;
	}

	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
