package org.kg.gv.controllr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class chatController {
	
	@RequestMapping("/join")
	public String joincon() {
		return "t_chat";
	}
}
