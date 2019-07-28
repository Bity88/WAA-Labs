package mum.edu.controller;

import mum.edu.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AdviceServlet {

	@Autowired
	private AdviceService adviceService;
       
	@GetMapping(value = "/advice")
	public String getForm(Model model) {
 
		Map< Integer, String> roastMap = adviceService.getAllRoast();
		model.addAttribute("roasts",roastMap);
		System.out.println("roasts==========="+roastMap);
		return "advice";
		}

	@PostMapping(value = "/roastList")
	protected String displayList(Model model, Integer roastKey) {
		String roast = adviceService.getRoast(roastKey);
			System.out.println("Rost ="+roast);
			System.out.println("key===="+roastKey);
		List<String> roastList = adviceService.getListByType(roast);
		model.addAttribute("roast",roast);
		model.addAttribute("roastList",roastList);
		return "display";


	}

}
