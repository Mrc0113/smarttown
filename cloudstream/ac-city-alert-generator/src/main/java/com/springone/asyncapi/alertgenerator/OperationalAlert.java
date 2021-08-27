package com.springone.asyncapi.alertgenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationalAlert {

	public OperationalAlert () {
	}
	public OperationalAlert (
		String severity, 
		String alertType, 
		String city, 
		java.math.BigDecimal temperature, 
		java.math.BigDecimal lat, 
		java.math.BigDecimal _long) {
		this.severity = severity;
		this.alertType = alertType;
		this.city = city;
		this.temperature = temperature;
		this.lat = lat;
		this._long = _long;
	}


	private String severity;
	private String alertType;
	private String city;
	private java.math.BigDecimal temperature;
	private java.math.BigDecimal lat;
	@JsonProperty("long")
	private java.math.BigDecimal _long;

	public String getSeverity() {
		return severity;
	}

	public OperationalAlert setSeverity(String severity) {
		this.severity = severity;
		return this;
	}


	public String getAlertType() {
		return alertType;
	}

	public OperationalAlert setAlertType(String alertType) {
		this.alertType = alertType;
		return this;
	}


	public String getCity() {
		return city;
	}

	public OperationalAlert setCity(String city) {
		this.city = city;
		return this;
	}


	public java.math.BigDecimal getTemperature() {
		return temperature;
	}

	public OperationalAlert setTemperature(java.math.BigDecimal temperature) {
		this.temperature = temperature;
		return this;
	}


	public java.math.BigDecimal getLat() {
		return lat;
	}

	public OperationalAlert setLat(java.math.BigDecimal lat) {
		this.lat = lat;
		return this;
	}


	public java.math.BigDecimal get_long() {
		return _long;
	}

	public OperationalAlert set_long(java.math.BigDecimal _long) {
		this._long = _long;
		return this;
	}


	public String toString() {
		return "OperationalAlert ["
		+ " severity: " + severity
		+ " alertType: " + alertType
		+ " city: " + city
		+ " temperature: " + temperature
		+ " lat: " + lat
		+ " _long: " + _long
		+ " ]";
	}
}

