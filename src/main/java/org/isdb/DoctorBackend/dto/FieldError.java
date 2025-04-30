package org.isdb.DoctorBackend.dto;

public record FieldError(
        String field,
        String errorCode,
        String errorMessage
) {
}