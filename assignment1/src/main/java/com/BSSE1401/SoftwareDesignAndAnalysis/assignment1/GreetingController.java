package com.BSSE1401.SoftwareDesignAndAnalysis.assignment1;

import com.MyPackage.mylib.MyFunction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String index() {
        System.out.println("Home route called");
        return "index";
       }

    @PostMapping("/greet")
    public String greet(@RequestParam String name, Model model) {
        System.out.println("Greet route called");
        String result = MyFunction.greet(name);  // Using your custom library
        model.addAttribute("greeting", result);
        return "result";
    }
}

