package ru.sbdh.app.controllers.kbk;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.sbdh.app.dao.mapper.KbkMapper;
import ru.sbdh.app.dao.mapper.UserMapper;
import ru.sbdh.app.models.ContractModel;
import ru.sbdh.app.models.KbkModel;
import ru.sbdh.app.models.UserModel;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/kbk/")
public class KbkController {

    @Inject
    @Qualifier("kbkMapper")
    KbkMapper kbkMapper;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "getKbkByYear", method = RequestMethod.GET)
    public List<KbkModel> getKbkByYear(@RequestParam(value = "year", defaultValue = "2020") Integer year) {
        List<KbkModel> kbkModels = kbkMapper.getKbkByYear(year);
        return kbkModels;
    }
}
