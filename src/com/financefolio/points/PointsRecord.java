package com.financefolio.points;

import java.util.List;

public class PointsRecord {
	private List<Points> record;

	public PointsRecord(List<Points> record) {
		super();
		this.record = record;
	}
	public void addToRecord(Points points) {
		record.add(points);
	}
	public List<Points> getRecord() {
		return record;
	}

	public void setRecord(List<Points> record) {
		this.record = record;
	}
}
