package org.kg.gv.controllr;

import java.util.List;
import java.util.Map;

import org.kg.gv.DAO.auctionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/market")
public class MarketController {
	
	@Autowired
	auctionDao ad;
	
	
	
	@GetMapping("/add")
	public String addGetHandle() {
		return "market/add";
	}
	@PostMapping("/add")
	public ModelAndView addPstHandle(@RequestParam Map map) {
		ModelAndView mav = new ModelAndView();
		boolean a=ad.add(map);
		List<Map> li=ad.list();
		if(a) {
		mav.setViewName("t_auction");
		mav.addObject("list" , li);
		mav.addObject("cnt" , li.size());
		mav.addObject("section" , "list");
		return mav;
		}else {
		return mav;
		}
	}
	
	@RequestMapping("/search")
	public ModelAndView asdasdgfs(@RequestParam Map map) {
		System.out.println(map);
		ModelAndView mav = new ModelAndView();
		List<Map> b=ad.uper(map);
		mav.setViewName("market/list");
		mav.addObject("list" ,b);
		 
				
		return mav;
	}
	@RequestMapping("list")
	public ModelAndView sgadfa(){
		List<Map> map=ad.list();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("market/list");
		mv.addObject("list" , map);
		mv.addObject("cnt" ,map.size());
		return mv;
	}
	@RequestMapping("/view/{no}")
	public ModelAndView num(@PathVariable String no) {
		Map map=ad.read(no);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("t_view");
		mv.addObject("map" , map);
		return mv;
	}
}
