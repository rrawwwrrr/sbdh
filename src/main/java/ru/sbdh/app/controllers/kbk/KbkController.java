package ru.sbdh.app.controllers.kbk;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.sbdh.app.mapper.KbkMapper;
import ru.sbdh.app.models.KbkModel;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/kbk/")
public class KbkController {

    @Inject
    @Qualifier("kbkMapper")
    KbkMapper kbkMapper;

    @RequestMapping(value = "getKbkByYear", method = RequestMethod.GET)
    public List<KbkModel> getKbkByYear(@RequestParam(value = "year", defaultValue = "2020") Integer year) {
        List<KbkModel> kbkModels = kbkMapper.getKbkByYear(year);
        return kbkModels;
    }
}
