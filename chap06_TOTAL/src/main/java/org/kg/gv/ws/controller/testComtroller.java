package org.kg.gv.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class testComtroller {
	
	@RequestMapping("basic")
	public String basichandle(){
		return "test/basic";
	}
	
}
