package org.kg.gv.controllr;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.kg.gv.DAO.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/my")
public class memberController {
	@Autowired
	ServletContext application;
	@Autowired
	member mem;
	@Autowired
	SimpleDateFormat sdf;
	
	@GetMapping("/info")
	public String infoHandle() {
		return "t_info";
	}

	@PostMapping("/info")
	public String infopoHandle() {
		
		return "t_info";

	}
	@GetMapping("/profile")
	public String proHandle(HttpSession session) {
		String id = (String)session.getAttribute("auth");
		if(id !=null) {
		Map a=mem.proone(id);
		session.setAttribute("data" , a);
		}
		return "t_profile";
	}
	
	
	@PostMapping("/profile")
	public ModelAndView profileHandle(@RequestParam(name="profile") MultipartFile f ,
			HttpSession session) throws InterruptedException {
		String id = (String)session.getAttribute("auth");
		boolean rst = false;
		String fmt = sdf.format(System.currentTimeMillis());
		String fileName = id+"_"+fmt;
		
		try {
			if(f.isEmpty())
				throw new Exception();
			File dst = new File(application.getRealPath("/profiles"), fileName);
			f.transferTo(dst);
			rst = !rst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map b=new HashMap<>();
		b.put("id", id);
		b.put("path", "/profiles/"+fileName);
		int ad=mem.addpro(b);
		System.out.println(application.getRealPath("/profiles"));
		Map a=mem.proone(id);
		System.out.println(a);
		ModelAndView mav = new ModelAndView("t_profile");
		
		mav.addObject("data" , a);
		mav.addObject("section" ,"my/profile");
		
		return mav;
	}
	@RequestMapping("/allpro")
	public ModelAndView proall(@RequestParam(name="page" , defaultValue="1")int page) {
		Map a=new HashMap();
		int size=mem.all();
		System.out.println(size);
		if(page>size)
			page = size;
		if(page <=0) 
			page = 1;
		
		a.put("start", (page*5)-4);
		a.put("end", page*5);
		List<Map> all=mem.allpro(a);
		double c=(size/5.0);
		int cc=size/5;
		if(c-cc>0) {
			cc+=1;
		}
		System.out.println(c);
		System.out.println(cc);
		ModelAndView mav = new ModelAndView("t_allpro");
		mav.addObject("all" ,all);
		mav.addObject("size",cc);
		mav.addObject("list" , size);
		return mav;
		
	}
}
