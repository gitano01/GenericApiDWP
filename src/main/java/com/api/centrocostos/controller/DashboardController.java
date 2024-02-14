package com.api.centrocostos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.centrocostos.dto.api.ApiResponse;
import com.api.centrocostos.dto.api.SuccessResponse;
import com.api.centrocostos.dto.api.utils.Menu;
import com.api.centrocostos.dto.api.utils.Modulo;
import com.api.centrocostos.dto.api.utils.Ruta;
import com.api.centrocostos.utils.Utilerias;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



@RestController
@RequestMapping("/dashboard")
@CrossOrigin(value="*")
public class DashboardController {

	private Logger log = Logger.getLogger(DashboardController.class);
	Utilerias util = new Utilerias();
	
	
	@RequestMapping(value="/menu", method = RequestMethod.GET) // Corrected 
	public ResponseEntity<ApiResponse>  getListaMenu(HttpServletRequest request){
		ApiResponse response = null;
		
		Map<String,Object> map = new HashMap<String,Object>();
		  try {
			  log.info("Inicia proceso  de obtencion de menu en clase " +  DashboardController.class.getName());
			  
			 // util.validateToken(request);
	            String json = "[{\"main\":\"dispersion\",\"apartados\":[{\"apartado\":\"abono\", \"ruta\":\"/v1/dispersion/abono\"},{\"apartado\":\"reporte\", \"ruta\":\"/v1/reporte\"},{\"apartado\":\"consulta\", \"ruta\":\"/v1/consulta\"}]},{\"main\":\"alta tarjetas\",\"apartados\":[{\"apartado\":\"cancelacion\", \"ruta\":\"/v1/cancelar\"},{\"apartado\":\"alta\", \"ruta\":\"/v1/alta\"}]}]";

	            // Convertir la cadena JSON a JsonObject
	            
	            map.put("cliente", "amalinalli Hdz");
	            map.put("perfil", "administrador");
	            
	            JsonArray jArray = new Gson().fromJson(json, JsonArray.class);
	            Modulo modulo = null;
	            Ruta apartado = null;
	            List<Modulo> modulos= new ArrayList<Modulo>();
	            List<Ruta> rutas= new ArrayList<Ruta>();
	             
	            for(int i=0;i<jArray.size();i++){
	            	modulo = new Modulo();
	            	JsonObject jsonObject = jArray.get(i).getAsJsonObject();
	            	JsonArray  apartados = jsonObject.getAsJsonArray("apartados");
	            	modulo.setMain(jsonObject.get("main").getAsString());
	            	for(int j= 0; j < apartados.size();j++){
	            		apartado = new Ruta();
	            		JsonObject jObject = apartados.get(j).getAsJsonObject();
	            		apartado.setApartado(jObject.get("apartado").getAsString());
	            		apartado.setRuta(jObject.get("ruta").getAsString());
	            		rutas.add(apartado);	            			            		
	            	}
	            	modulo.setApartados(rutas);
	            	modulos.add(modulo);
	            }	            
	         // La clase Menu debe tener un constructor que reciba el main y una lista de apartados	            
	            map.put("listaMenu",modulos);
	            
	            response = new SuccessResponse(200,"Operacion exitosa", map);	
	            log.info("menu obtenido con exito: " + response );

	            // Devolver el JsonObject como una cadena JSON en la respuesta HTTP
	            return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            log.error("Se interrumpe servicio en clase " + DashboardController.class.getName() + " por error: " + e.getMessage());
	            return new ResponseEntity<ApiResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
}
