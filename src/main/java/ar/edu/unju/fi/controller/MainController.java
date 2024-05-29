package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/index")
	public String getIndex() {
	      return "index";
	  }
	
	@GetMapping("/registros")
	public String getRegistros() {
		return"registros";
	}
	
	@GetMapping("/listados")
	public String getListados() {
		return"listados";
	}
}
