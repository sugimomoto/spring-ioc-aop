package sugimomoto.springiocaop.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sugimomoto.springiocaop.repository.*;

import lombok.RequiredArgsConstructor;


@Scope("request")
@RequiredArgsConstructor
@Controller
public class ScopeController {
    
    private final CoffeeRepository repository;

    @GetMapping("/scope")
    public String showList(Model model){
        model.addAttribute("toString",this.toString());
        model.addAttribute("allCoffee",repository.findAll());

        return "index";
    }
}
