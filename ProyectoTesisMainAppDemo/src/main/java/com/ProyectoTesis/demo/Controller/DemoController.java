package com.ProyectoTesis.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoTesis.demo.Service.DemoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/demoMainApp")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping(value = {"/receiveData/{data}"}, method = RequestMethod.POST)
	public String receiveData(@PathVariable("data") String data) {
		LOGGER.info("======= PROCESO DE RECIBIR DATA ACCESADO ========");
		String rpta = "Data Recibida del servidor de recoleccion de datos, el dato es " + data;
		LOGGER.info("======= RESPUESTA AL PROCESO : {}", rpta);
		return rpta;
	}

	@RequestMapping(value = {"/requestData/{name}"}, method = RequestMethod.POST)
	public String requestData(@PathVariable("name") String name) {
		LOGGER.info("======= PROCESO DE ENVIO DE DATA ACCESADO ========");
		String rpta = "Data solicitada al servidor de recoleccion de datos para " + name + ", es " + demoService.requestData(name);
		LOGGER.info("======= RESPUESTA AL PROCESO : {}", rpta);
		return rpta;  
	}
	
}
