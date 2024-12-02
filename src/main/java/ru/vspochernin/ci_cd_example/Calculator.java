package ru.vspochernin.ci_cd_example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

    @RequestMapping("/plus")
    public long plus(@RequestParam long a, @RequestParam long b) {
        return a + b;
    }
}
