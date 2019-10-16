package com.techelevator;

import com.techelevator.dao.CustomerDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CustomerSearchController {
	

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/customers")
    public String showCustomers() {
        return "customerList";
    }

    @RequestMapping("/customerListResults")
    public String searchAndSortCustomers(@RequestParam String search, String sort, ModelMap modelMap) {
	    modelMap.put("customers", customerDao.searchAndSortCustomers(search, sort));
	    return "customerList";
    }
}