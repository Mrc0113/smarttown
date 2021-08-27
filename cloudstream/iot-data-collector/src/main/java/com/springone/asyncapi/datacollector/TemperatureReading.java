package com.springone.asyncapi.datacollector;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemperatureReading {
	@JsonProperty("m_cpu_load")
	private java.math.BigDecimal mCpuLoad;
	@JsonProperty("m_city")
	private String mCity;
	@JsonProperty("m_latitude")
	private java.math.BigDecimal mLatitude;
	@JsonProperty("m_longitude")
	private java.math.BigDecimal mLongitude;
	@JsonProperty("m_cpu_temp")
	private java.math.BigDecimal mCpuTemp;
	
	public TemperatureReading() {
		super();
	}

	public TemperatureReading(BigDecimal mCpuLoad, String mCity, BigDecimal mLatitude, BigDecimal mLongitude,
			BigDecimal mCpuTemp) {
		super();
		this.mCpuLoad = mCpuLoad;
		this.mCity = mCity;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mCpuTemp = mCpuTemp;
	}

	public java.math.BigDecimal getmCpuLoad() {
		return mCpuLoad;
	}

	public void setmCpuLoad(java.math.BigDecimal mCpuLoad) {
		this.mCpuLoad = mCpuLoad;
	}

	public String getmCity() {
		return mCity;
	}

	public void setmCity(String mCity) {
		this.mCity = mCity;
	}

	public java.math.BigDecimal getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(java.math.BigDecimal mLatitude) {
		this.mLatitude = mLatitude;
	}

	public java.math.BigDecimal getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(java.math.BigDecimal mLongitude) {
		this.mLongitude = mLongitude;
	}

	public java.math.BigDecimal getmCpuTemp() {
		return mCpuTemp;
	}

	public void setmCpuTemp(java.math.BigDecimal mCpuTemp) {
		this.mCpuTemp = mCpuTemp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TemperatureReading [mCpuLoad=");
		builder.append(mCpuLoad);
		builder.append(", mCity=");
		builder.append(mCity);
		builder.append(", mLatitude=");
		builder.append(mLatitude);
		builder.append(", mLongitude=");
		builder.append(mLongitude);
		builder.append(", mCpuTemp=");
		builder.append(mCpuTemp);
		builder.append("]");
		return builder.toString();
	}
}
