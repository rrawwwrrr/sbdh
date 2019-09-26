package ru.sbdh.app.controllers.print;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/printxls/")
public class PrintExcelController {

    @RequestMapping(value = "getbyid", method = RequestMethod.GET)
    public void getuserbyid(@RequestParam(value = "id", defaultValue = "World") Integer id) {

    }
}