package com.learn.batch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learn.batch.repositories.CarRepository;
import com.learn.batch.service.LoadBatchService;

@Controller
@RequestMapping("/pags/")
public class ThymeleafController {
	
	private static final String GREETING_PAGE = "greeting";


	@Autowired
	private CarRepository carRepository;
	
	
	@Autowired
	private LoadBatchService loadBatchService;
	
    @GetMapping(GREETING_PAGE)
    public String greeting(Model model) {
        model.addAttribute("cars", carRepository.findAll());
        return GREETING_PAGE;
    }
    
    @GetMapping("loadDataBase")
    public String loadDataBase(Model model) {
    	try {
			model.addAttribute("status", loadBatchService.loadDataBase());
			model.addAttribute("cars", carRepository.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return GREETING_PAGE;
    }
    

	
}
