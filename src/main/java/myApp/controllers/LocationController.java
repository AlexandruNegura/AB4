package myApp.controllers;

import myApp.components.Location;
import myApp.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private ILocationService locationService;



    @RequestMapping("/showLocations")
    public String findLocations(Model model){
        List<Location> locations = locationService.findAll();

        model.addAttribute("location", locations);

        return "showLocations";
    }
}
