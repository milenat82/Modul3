package com.application.modul3.appointment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.application.modul3.appointment.Appointment;
import com.application.modul3.appointment.dto.AppointmentCreateDTO;
import com.application.modul3.appointment.dto.AppointmentDTO;

@Component
public class AppointmentMapper {
	public AppointmentDTO appointmentDB2Appointment(Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setDateFrom(appointment.getDateFrom());
		appointmentDTO.setDateUntil(appointment.getDateUntil());
		return appointmentDTO;
	}

	public List<AppointmentDTO> appointmentDBList2AppointmentList(List<Appointment> appointmentDBList) {
		return appointmentDBList.stream().map(app -> appointmentDB2Appointment(app)).collect(Collectors.toList());
	}

	public Appointment appointmnetCreateDTO2Appointment(AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = new Appointment();
		appointment.setDateFrom(appointmentCreateDTO.getStartDate());
		appointment.setDateUntil(appointmentCreateDTO.getEndDate());
		return appointment;
	}

	/*
	 * public List<AppointmentDTO>
	 * appointmentList2AppointmentListDTO(List<Appointment> appointmentDBs) { //
	 * TODO Auto-generated method stub return null; }
	 */
}