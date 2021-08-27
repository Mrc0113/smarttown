package com.springone.asyncapi.alertgenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemperatureReading {

	public TemperatureReading () {
	}
	public TemperatureReading (
		java.math.BigDecimal mCpuLoad, 
		String mCity, 
		java.math.BigDecimal mLatitude, 
		java.math.BigDecimal mLongitude, 
		java.math.BigDecimal mCpuTemp) {
		this.mCpuLoad = mCpuLoad;
		this.mCity = mCity;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mCpuTemp = mCpuTemp;
	}


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

	public java.math.BigDecimal getMCpuLoad() {
		return mCpuLoad;
	}

	public TemperatureReading setMCpuLoad(java.math.BigDecimal mCpuLoad) {
		this.mCpuLoad = mCpuLoad;
		return this;
	}


	public String getMCity() {
		return mCity;
	}

	public TemperatureReading setMCity(String mCity) {
		this.mCity = mCity;
		return this;
	}


	public java.math.BigDecimal getMLatitude() {
		return mLatitude;
	}

	public TemperatureReading setMLatitude(java.math.BigDecimal mLatitude) {
		this.mLatitude = mLatitude;
		return this;
	}


	public java.math.BigDecimal getMLongitude() {
		return mLongitude;
	}

	public TemperatureReading setMLongitude(java.math.BigDecimal mLongitude) {
		this.mLongitude = mLongitude;
		return this;
	}


	public java.math.BigDecimal getMCpuTemp() {
		return mCpuTemp;
	}

	public TemperatureReading setMCpuTemp(java.math.BigDecimal mCpuTemp) {
		this.mCpuTemp = mCpuTemp;
		return this;
	}


	public String toString() {
		return "TemperatureReading ["
		+ " mCpuLoad: " + mCpuLoad
		+ " mCity: " + mCity
		+ " mLatitude: " + mLatitude
		+ " mLongitude: " + mLongitude
		+ " mCpuTemp: " + mCpuTemp
		+ " ]";
	}
}

