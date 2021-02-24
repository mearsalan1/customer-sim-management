package com.csms.controller;

import com.csms.model.Customer;
import com.csms.model.Sim;
import com.csms.service.CustomerService;
import com.csms.service.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private SimService simService;

    @RequestMapping({"/", "/index", "/home"})
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView("list-customers");
        mav.addObject("customers", customerService.get());
        return mav;
    }

    @RequestMapping("/newcustomer")
    public ModelAndView customer(){
        ModelAndView mav = new ModelAndView("customer");
        mav.addObject("customer", new Customer());
        return mav;
    }

    @RequestMapping("/customer")
    public ModelAndView savecustomer(@ModelAttribute("customer") Customer customer){
        ModelAndView mav = new ModelAndView("list-customers");
        if(customer != null){
            customerService.save(customer);
        }
        mav.addObject("customers", customerService.get());
        return mav;
    }

    @RequestMapping("/viewcustomer/{id}")
    public ModelAndView viewcustomer(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView("viewcustomer");
        Customer customer = customerService.get(id);
        mav.addObject("fullcustomer", customer);
        List<Sim> sims = simService.getSimByCustomerId(customer.getId());
        mav.addObject("sims", sims);
        mav.addObject("sim", new Sim());
        return mav;
    }

    @RequestMapping("/customer/{customerid}/sims")
    public ModelAndView savecomments(@PathVariable("customerid") Integer id, @ModelAttribute("sim") Sim sims){
        ModelAndView mav = new ModelAndView("list-customers");
        Customer customer = customerService.get(id);
        if(sims != null){
            sims.setCustomer(customer);
            simService.save(sims);
        }
        mav.addObject("customers", customerService.get());
        return mav;
    }
}
