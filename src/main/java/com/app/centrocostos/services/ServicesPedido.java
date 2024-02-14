package com.app.centrocostos.services;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Service
public class ServicesPedido {
	
	public String getReportePedidos() {
		JsonArray list = new JsonArray();
		JsonObject json = new JsonObject();
		
		json.addProperty("cliente", "Cliente 1");
		json.addProperty("consignatario", "Consignatario 1");
		json.addProperty("service", "Service 1");
		json.addProperty("pedidoid", "1");
		json.addProperty("importe", "1000");
		json.addProperty("fechacreacion", "2022-01-01T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 2");
		json.addProperty("consignatario", "Consignatario 2");
		json.addProperty("service", "Service 2");
		json.addProperty("pedidoid", "2");
		json.addProperty("importe", "2000");
		json.addProperty("fechacreacion", "2022-01-02T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 3");
		json.addProperty("consignatario", "Consignatario 3");
		json.addProperty("service", "Service 3");
		json.addProperty("pedidoid", "3");
		json.addProperty("importe", "3000");
		json.addProperty("fechacreacion", "2022-01-03T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 4");
		json.addProperty("consignatario", "Consignatario 4");
		json.addProperty("service", "Service 4");
		json.addProperty("pedidoid", "4");
		json.addProperty("importe", "4000");
		json.addProperty("fechacreacion", "2022-01-04T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 5");
		json.addProperty("consignatario", "Consignatario 5");
		json.addProperty("service", "Service 5");
		json.addProperty("pedidoid", "5");
		json.addProperty("importe", "5000");
		json.addProperty("fechacreacion", "2022-01-05T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 6");
		json.addProperty("consignatario", "Consignatario 6");
		json.addProperty("service", "Service 6");
		json.addProperty("pedidoid", "6");
		json.addProperty("importe", "6000");
		json.addProperty("fechacreacion", "2022-01-06T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 7");
		json.addProperty("consignatario", "Consignatario 7");
		json.addProperty("service", "Service 7");
		json.addProperty("pedidoid", "7");
		json.addProperty("importe", "7000");
		json.addProperty("fechacreacion", "2022-01-07T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 8");
		json.addProperty("consignatario", "Consignatario 8");
		json.addProperty("service", "Service 8");
		json.addProperty("pedidoid", "8");
		json.addProperty("importe", "8000");
		json.addProperty("fechacreacion", "2022-01-08T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 9");
		json.addProperty("consignatario", "Consignatario 9");
		json.addProperty("service", "Service 9");
		json.addProperty("pedidoid", "9");
		json.addProperty("importe", "9000");
		json.addProperty("fechacreacion", "2022-01-09T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 10");
		json.addProperty("consignatario", "Consignatario 10");
		json.addProperty("service", "Service 10");
		json.addProperty("pedidoid", "10");
		json.addProperty("importe", "10000");
		json.addProperty("fechacreacion", "2022-01-10T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 11");
		json.addProperty("consignatario", "`");
		json.addProperty("service", "Service 11");
		json.addProperty("pedidoid", "11");
		json.addProperty("importe", "11000");
		json.addProperty("fechacreacion", "2022-01-11T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 12");
		json.addProperty("consignatario", "Consignatario 12");
		json.addProperty("service", "Service 12");
		json.addProperty("pedidoid", "12");
		json.addProperty("importe", "12000");
		json.addProperty("fechacreacion", "2022-01-12T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 13");
		json.addProperty("consignatario", "Consignatario 13");
		json.addProperty("service", "Service 13");
		json.addProperty("pedidoid", "13");
		json.addProperty("importe", "13000");
		json.addProperty("fechacreacion", "2022-01-13T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 14");
		json.addProperty("consignatario", "Consignatario 14");
		json.addProperty("service", "Service 14");
		json.addProperty("pedidoid", "14");
		json.addProperty("importe", "14000");
		json.addProperty("fechacreacion", "2022-01-14T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 15");
		json.addProperty("consignatario", "Consignatario 15");
		json.addProperty("service", "Service 15");
		json.addProperty("pedidoid", "15");
		json.addProperty("importe", "15000");
		json.addProperty("fechacreacion", "2022-01-15T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 16");
		json.addProperty("consignatario", "Consignatario 16");
		json.addProperty("service", "Service 16");
		json.addProperty("pedidoid", "16");
		json.addProperty("importe", "16000");
		json.addProperty("fechacreacion", "2022-01-16T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 17");
		json.addProperty("consignatario", "Consignatario 17");
		json.addProperty("service", "Service 17");
		json.addProperty("pedidoid", "17");
		json.addProperty("importe", "17000");
		json.addProperty("fechacreacion", "2022-01-17T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 18");
		json.addProperty("consignatario", "Consignatario 18");
		json.addProperty("service", "Service 18");
		json.addProperty("pedidoid", "18");
		json.addProperty("importe", "18000");
		json.addProperty("fechacreacion", "2022-01-18T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 19");
		json.addProperty("consignatario", "Consignatario 19");
		json.addProperty("service", "Service 19");
		json.addProperty("pedidoid", "19");
		json.addProperty("importe", "19000");
		json.addProperty("fechacreacion", "2022-01-19T00:00:00Z");
		list.add(json);
		
		json = new JsonObject();
		json.addProperty("cliente", "Cliente 20");
		json.addProperty("consignatario", "Consignatario 20");
		json.addProperty("service", "Service 20");
		json.addProperty("pedidoid", "20");
		json.addProperty("importe", "20000");
		json.addProperty("fechacreacion", "2022-01-20T00:00:00Z");
		list.add(json);
		new Gson();
		return new Gson().toJson(list);
	}

}
