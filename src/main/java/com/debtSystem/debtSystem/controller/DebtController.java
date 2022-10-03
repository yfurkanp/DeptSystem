package com.debtSystem.debtSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.debtSystem.debtSystem.model.Debtor;
import com.debtSystem.debtSystem.repository.DebtRepository;



@Controller
public class DebtController {
	
  private DebtRepository debtRepository; //Repodan çağırdık.
  
  
  	@Autowired
	public DebtController (DebtRepository debtRepository) { //parametreli constructor oluşturduk.
		this.debtRepository=debtRepository;
	}
	
	@GetMapping({"/debtors"})
	public ModelAndView getAllDebtors() {
		
		ModelAndView mav = new ModelAndView("list-debtors","borclular",debtRepository.findAll());
		
		return mav;
		
	}
	
	@GetMapping("/addDebtors")
	public ModelAndView addDebtor() {
		ModelAndView mav = new ModelAndView("add-debtor","borclu",new Debtor());
		
		return mav;
	}
	
	@PostMapping("/saveDebtor")
	public String saveDebtor(@ModelAttribute Debtor debtor) {
		
		debtRepository.save(debtor);
		return "redirect:/debtors";//debtor komutunun gittiği yere yönlendir(en üstte)
	}
	@GetMapping("/showUpdate")
	public ModelAndView showUpdateForm(@RequestParam Integer debtorId) {
		ModelAndView mav = new ModelAndView("add-debtor","borclu",debtRepository.findById(debtorId).get());
		return mav;
	}
	@GetMapping("/deleteDebtor")
	public String deleteDebtor(@RequestParam Integer debtorId) {
		 debtRepository.deleteById(debtorId);
		 
		 return "redirect:/debtors";
	
	}
	
	
	

}
