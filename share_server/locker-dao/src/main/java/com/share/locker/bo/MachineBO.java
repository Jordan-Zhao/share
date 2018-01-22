package com.share.locker.bo;

/**
 * Machine 机柜
 * 
 * @author Jordan
 *
 */
public class MachineBO extends BaseBO {
	private Long machineId;
	private String location;
	public Long getMachineId() {
		return machineId;
	}
	public void setMachineId(Long machineId) {
		this.machineId = machineId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
