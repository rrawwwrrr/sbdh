package ru.sbdh.app.controllers.norris;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.mapper.NorrisMapper;
import ru.sbdh.app.models.NorrisModel;

import javax.inject.Inject;
import java.util.List;

/**
 * @author rrr on 29.03.2020
 * @project sbdh
 */
@RestController
@RequestMapping("/api/norris")
public class NorrisController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NorrisController.class);

    @Inject
    @Qualifier("norrisMapper")
    NorrisMapper mapper;

    @GetMapping("/")
    public List<NorrisModel> getAll() {
        return mapper.getAll();
    }
}

