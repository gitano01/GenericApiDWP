package com.api.centrocostos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.centrocostos.services.ServicesPedido;

@RestController
@RequestMapping("/pedido")
public class PedidosController {
	
	private ServicesPedido servicePedido = new ServicesPedido();
	
	@RequestMapping(value = "/reporte", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> getProveedores(HttpServletRequest request)
	{
		return new ResponseEntity<Object>(servicePedido.getReportePedidos(), HttpStatus.OK);
	}	
}
