package com.api.centrocostos.dto.api;

import lombok.Data;

@Data
public class ErrorResponse extends ApiResponse{
	private Object response;

	public ErrorResponse(int codigo, String mensaje, Object response) {
		super(codigo, mensaje);
		this.response = response;
	}
}
