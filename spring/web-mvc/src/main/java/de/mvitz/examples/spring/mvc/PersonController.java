package de.mvitz.examples.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PersonController {

    private PersonRepository personRepo;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepo = personRepository;
    }

    @RequestMapping
    public String showAll(Model model) {
        model.addAttribute("persons", personRepo.findAll());
        return "persons";
    }

    @RequestMapping(value = "/{id}")
    public String showById(@PathVariable long id, Model model) {
        model.addAttribute("person", personRepo.findById(id));
        return "person";
    }

}
