package com.api.centrocostos.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.api.centrocostos.dto.api.ApiResponse;
import com.google.gson.Gson;


public class Utilerias {
	private Logger log = Logger.getLogger(Utilerias.class);
	public void doResponseApi(int code, ApiResponse resp, HttpServletResponse response) throws IOException {
		// Devolver el token en formato JSON
		response.setContentType("text/json");
		response.setStatus(code);
		PrintWriter out = response.getWriter();
		out.println(new Gson().toJson(resp));
		log.error("se interrumpe proceso de peticion post validaciones jwt en clase  "+ Utilerias.class.getName());
		
	}
	
}
