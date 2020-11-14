package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AlgorithmDataModel {

	int from;
	int to;
	int period;

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

}
