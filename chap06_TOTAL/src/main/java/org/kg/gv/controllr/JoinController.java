package org.kg.gv.controllr;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.kg.gv.DAO.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	@Autowired
	member mem;
	@GetMapping(path = "/join")
	public String joinGetHandle() {
		return "t_join";
	}
	@PostMapping("/join")
	public String joinPostHandle(@RequestParam Map map, HttpSession session, Model model) {
		try {
			boolean b = mem.addOne(map);
			session.setAttribute("auth", "on");
			return "game";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("temp", map);
			return "join";
		}
	}
}
