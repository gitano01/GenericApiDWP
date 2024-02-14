package com.api.centrocostos.config;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.api.centrocostos.dto.api.ApiResponse;
import com.api.centrocostos.dto.api.ErrorResponse;
import com.api.centrocostos.dto.api.SuccessResponse;
import com.api.centrocostos.utils.Constantes;
import com.api.centrocostos.utils.Utilerias;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter implements Filter {

	private Logger log = Logger.getLogger(JwtFilter.class);
	
	HttpSession session= null;
	String error = Constantes.ApiResponses.ERROR;
	ResponseEntity<ApiResponse> resp = null;
	Utilerias util = null;
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método de inicialización del filtro
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
    	
    	log.info("Inicia el filtro de jwtFilter");
    	session = ((HttpServletRequest) servletRequest).getSession();
    	HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization"); // Agrega 'Authorization' aquí

        // Realiza operaciones de prehandle aquí, por ejemplo, loguear la solicitud
        if(!("/ApiCentroCostos/".equals(request.getRequestURI()))){
        	log.info("Inicia el filtro de");
        	resp = validateToken(request);
        	if(resp.getBody().getCodigo()==200){
        		filterChain.doFilter(request, response);
        		log.info("se ha realizado la validacion del token exitosamente");
        	}else{
        		util = new Utilerias();
        		log.error("Se interrumpe el proceso en clase " + JwtFilter.class.getName());
        		util.doResponseApi(resp.getBody().getCodigo(), resp.getBody(), response);
        		
        	}
        }else{
        	log.info("contuina el proceso de filter chain");
        	filterChain.doFilter(request, response);
        }

    }
    

    @Override
    public void destroy() {
        // Método de destrucción del filtro
    }
    
    
    
   
	public ResponseEntity<ApiResponse> validateToken(HttpServletRequest request) throws ServletException{
		log.info("Inicia la validacion de token");
		ResponseEntity<ApiResponse> response= null;
		ApiResponse resp = null;
		session=request.getSession();
		
		try{
			String authorizationHeader = request.getHeader("Authorization");	
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				String authToken = authorizationHeader.substring(7); // Para eliminar "Bearer " del encabezado
			  	
			   	response = validate(authToken, request);
			
			} else {

				resp = new ErrorResponse(400, "Operación fallida",
						"No se proporcion� un token Bearer en el encabezado Authorization.");
				// Manejo si el encabezado no contiene un token Bearer
				response = new ResponseEntity<ApiResponse>(resp,HttpStatus.BAD_REQUEST);
				session.setAttribute(error, "No se proporcion� un token Bearer en el encabezado Authorization.");
			
			}
		}catch(Exception e){
			resp = new ErrorResponse(500, "Operación fallida",
					e.getMessage());
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.BAD_REQUEST);
			
			session.setAttribute(error, e.getMessage());
		}
		
		return response;
		
	}
	
	public ResponseEntity<ApiResponse> validate(String token, HttpServletRequest request) {
		log.info("Inicia el proceso de validacion de jwt token");
		// Con la llave secreta del servicio ir por la lave a base 
		String secretKey = "c3ViKjEzNXUqbzMxKm91YkwwMzA=";// obtenerla de base de datos
		session = request.getSession();
		
		//System.out.println(request.getParameter("api"));	
		ResponseEntity<ApiResponse> response= null;
		ApiResponse resp = null;	
		
		try {
			// Desencriptar Jws<B>token
			log.info("Inicia el proceso de desencriptado de jwt token");
			Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

			Claims body = claims.getBody();

			resp = new SuccessResponse(Constantes.Codes.OK, Constantes.ApiResponses.OK, "Token v�lido");
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.OK);

		} catch (ExpiredJwtException e) {

			resp = new ErrorResponse(Constantes.Codes.UNAUTHORIZED, Constantes.ApiResponses.FAILURE,
					e.getMessage());
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.UNAUTHORIZED);
			session.setAttribute(error, e.getMessage());
			log.error(response);
		} catch (SignatureException e) {
			resp= new ErrorResponse(Constantes.Codes.UNAUTHORIZED, Constantes.ApiResponses.FAILURE,
					e.getMessage());
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.UNAUTHORIZED);
			session.setAttribute(error, e.getMessage());
			log.error(response);
		} catch (MalformedJwtException e) {
			resp = new ErrorResponse(Constantes.Codes.UNAUTHORIZED, Constantes.ApiResponses.FAILURE,
					e.getMessage());
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.UNAUTHORIZED);
			session.setAttribute(error, e.getMessage());
			log.error(response);
		} catch (JwtException e) {
			resp = new ErrorResponse(Constantes.Codes.UNAUTHORIZED, Constantes.ApiResponses.FAILURE,
					e.getMessage());
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.UNAUTHORIZED);
			session.setAttribute(error, e.getMessage());
			log.error(response);
		} catch (Exception e) {
			// Manejo gen�rico de excepciones
			resp = new ErrorResponse(Constantes.Codes.INTERNAL_ERROR, Constantes.ApiResponses.FAILURE,
					"Error al validar el token");
			response = new ResponseEntity<ApiResponse>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
			session.setAttribute(error, "Error al validar el token");
			log.error(response);
		}

		return response;
	}
}
