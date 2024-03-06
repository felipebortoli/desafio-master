package br.com.biblioteca.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerMembrosProjeto {

	 @Value("${membrosprojeto.host}")
	 String serviceHost;

	 @Value("${membrosprojeto.port}")
	 Integer servicePort;

	public String getServiceHost() {
		return serviceHost;
	}

	public void setServiceHost(String serviceHost) {
		this.serviceHost = serviceHost;
	}

	public Integer getServicePort() {
		return servicePort;
	}

	public void setServicePort(Integer servicePort) {
		this.servicePort = servicePort;
	}
	 
	 
}
