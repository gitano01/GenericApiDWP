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

import org.apache.log4j.Logger;

import com.api.centrocostos.utils.Utilerias;

public class CorsFilter implements Filter {

	private Logger log = Logger.getLogger(CorsFilter.class);
	Utilerias util = new Utilerias();

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// No se necesita ninguna inicializaci�n, pero si necesitas algo aqu�,
		// puedes hacerlo.
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		log.info("Inicia el CorsFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		log.info("corsfilter :: peticion : " + request.getMethod());
		// System.out.println("CORSFilter HTTP Request: " +
		// request.getMethod());
		// Authorize (allow) all domains to consume the content
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", "*");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods",
				"GET, OPTIONS, HEAD, PUT, POST");
		((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept, Authorization"); // Agrega
																					// 'Authorization'
																					// aquí

		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per
		// CORS handshake
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}
		log.info("corsfilter :: continua la peticion : " + request.getMethod());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Si necesitas hacer algo al destruir el filtro, puedes hacerlo aqu�.
	}

}
