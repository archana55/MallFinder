package org.launchcode.mallfinder.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    public String searchLocation = new String();
    public String searchDistance = new String();

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title","Mall Finder");
        String desc = "Search for your favorite Shopping Mall!";
        model.addAttribute("description",desc);
        model.addAttribute("searchLocation" ,searchLocation);
        model.addAttribute("searchDistance",searchDistance);

        return "index";
    }

    @RequestMapping(value = "",method =RequestMethod.POST)
    public String processSearchForm(Model model, @RequestParam String location, @RequestParam String distance){
        // model.addAttribute("searchLocation" ,location);
        // model.addAttribute("searchDistance",distance);
        searchLocation = location;
        searchDistance = distance;
       return "redirect:";

    }
}
