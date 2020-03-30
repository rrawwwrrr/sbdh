package ru.sbdh.app.controllers.news;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.controllers.print.PrintPDFController;
import ru.sbdh.app.mapper.NewsMapper;
import ru.sbdh.app.models.NewsModel;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintPDFController.class);

    @Inject
    @Qualifier("newsMapper")
    NewsMapper mapper;

    @GetMapping("/{id}")
    public NewsModel getNews(@PathVariable String id) {
        return mapper.getNew(id);
    }
}
