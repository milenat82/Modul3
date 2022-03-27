package com.application.modul3.appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.modul3.appointment.dto.AppointmentCreateDTO;
import com.application.modul3.appointment.dto.AppointmentDTO;
import com.application.modul3.appointment.dto.AppointmentInfoDTO;
import com.application.modul3.appointment.mapper.AppointmentMapper;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.dto.CompanyDTO;
import com.application.modul3.exemplary.mapper.ExemplaryMapper;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;
	@Autowired
	private ExemplaryMapper exemplaryMapper;

	@GetMapping("/find/{startDate}/{endDate}/{bookId}")
	public List<CompanyDTO> findFreeExemplaries(@PathVariable String startDate, @PathVariable String endDate,

			@PathVariable Integer bookId) {
		List<Exemplary> freeExemplaries = appointmentService.findFreeExemplaries(LocalDate.parse(startDate),
				LocalDate.parse(endDate), bookId);
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(freeExemplaries);
	}

	@GetMapping("/list/{userId}")
	public List<AppointmentDTO> getAppointmentsForUser(@PathVariable Integer userId) {
		List<Appointment> appointmentDBs = new ArrayList<>(appointmentService.getAllAppointmentsForUser(userId));
		return appointmentMapper.appointmentDBList2AppointmentList(appointmentDBs);
	}

	@PostMapping("/find")//////////NOT WORKING
	public List<CompanyDTO> getExemplariesForPeriod(@RequestBody AppointmentInfoDTO appointmentInfoDTO) {
		List<Exemplary> exemplaries = appointmentService.getExemplariesForPeriod(appointmentInfoDTO.getDateFrom(),
				appointmentInfoDTO.getDateUntil(), appointmentInfoDTO.getBookId());
		return exemplaryMapper.exemplaryList2ExemplaryDTOList(exemplaries);
	}

	@PostMapping("/book/{exemplaryId}/{userId}") /// perioada e scrisa in body
	public void book(@RequestBody AppointmentCreateDTO appointmentCreateDTO, @PathVariable Integer exemplaryId,
			@PathVariable Integer userId) {
		appointmentService.book(appointmentMapper.appointmnetCreateDTO2Appointment(appointmentCreateDTO), exemplaryId,
				userId);
	}
}