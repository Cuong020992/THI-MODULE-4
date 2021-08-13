package com.codegym.controller;
import com.codegym.model.City;
import com.codegym.repository.ICityRepository;
import com.codegym.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {


    @Autowired
    private ICityService cityService;


    @ModelAttribute("cities")
    public Iterable<City> provinces(){
        return cityService.findAll();
    }


    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/city")
    public ModelAndView listCity() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) { // kiểm tra xem dữ liệu có null không
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:cities";
    }

}
