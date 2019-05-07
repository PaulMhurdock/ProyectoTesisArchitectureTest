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
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping(value = {"/requestData/{name}"}, method = RequestMethod.GET)
	public String attendDataRequest(@PathVariable("name") String name) {
		LOGGER.info("======= PROCESO DE ATENCION DE SOLICITUD DE DATA ACCESADO ========");
		String rpta = demoService.extractData(name);
		LOGGER.info("======= RESPUESTA A PROCESO : {}", rpta);
		return rpta;
	}
	
	@RequestMapping(value = {"/sendData/{name}"}, method = RequestMethod.POST)
	public String sendData(@PathVariable("name") String name) {
		LOGGER.info("======= PROCESO DE ENVIO DE DATA ACCESADO ========");
		demoService.sendData(name);
		return "Data Enviada";
	}
	
}
