package com.application.modul3.appointment.dto;

import java.time.LocalDate;

public class AppointmentDTO {
	private LocalDate dateFrom;
	private LocalDate dateUntil;

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}

	public LocalDate getDateUntil() {
		return dateUntil;
	}

	public void setDateUntil(LocalDate dateUntil) {
		this.dateUntil = dateUntil;
	}

}