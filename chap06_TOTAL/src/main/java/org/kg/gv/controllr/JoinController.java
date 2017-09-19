package org.kg.gv.controllr;

import java.awt.Window;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.kg.gv.DAO.member;
import org.kg.gv.ws.controller.AlertWSHandler;
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
	
	@Autowired
	AlertWSHandler aws;
	@GetMapping(path = "/join")
	public String joinGetHandle() {
		return "t_join";
	}
	@PostMapping("/join")
	public String joinPostHandle(@RequestParam Map map, HttpSession session, Model model) {
		boolean b = mem.addOne(map);
		aws.sendMessage("누군가가입했습니다.");
		if(b) {
			return "t_allpro";
			
		}else {
			return "join";
		}
	}
	@GetMapping("/login")
	public String logingetHandle(Model model) {
		model.addAttribute("temp" , "temp");
		return "t_login";
	}
	@PostMapping("/login")
	public String loginHandle(@RequestParam Map map,HttpSession session ,Model model) {
		try {
			Map log=mem.existOne(map);
			if(log !=null) {
			Map id=mem.getid((String)log.get("ID"));
			session.setAttribute("auth", id.get("ID"));
			return "t_profile";
			}else {
				model.addAttribute("temp","temp");
				model.addAttribute("section","login");
				return "t_login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("temp", map);
			
			return "game";
		}
	}
	
}
