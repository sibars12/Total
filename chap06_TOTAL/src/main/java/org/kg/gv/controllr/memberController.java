package org.kg.gv.controllr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class memberController {
	
	
	@GetMapping("info")
	public String infoHandle() {
		return "t_expr";
	}
}
