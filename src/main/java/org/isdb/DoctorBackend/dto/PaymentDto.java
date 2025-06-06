package org.isdb.DoctorBackend.dto;

import java.time.LocalDateTime;

import org.isdb.DoctorBackend.constants.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

	private Long appointmentID;
	private Double amount;
	private String paymentMethod;
	private PaymentStatus status;
	private LocalDateTime paidAt;

}
