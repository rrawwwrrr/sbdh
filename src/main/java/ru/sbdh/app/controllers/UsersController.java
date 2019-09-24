package ru.sbdh.app.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.TestDataUtil;
import ru.sbdh.app.dao.BatchUpsertFlatObjectDAO;
import ru.sbdh.app.dao.mapper.FlatObjectMapper;
import ru.sbdh.app.domain.FlatObject;

import javax.inject.Inject;
import java.util.List;

@RestController
public class UsersController {
    /**
     * This one performs batched upsert operations
     */
    @Inject
    BatchUpsertFlatObjectDAO batchFlatObjectDAO;

    /**
     * This one performs upsert operations iteratively
     */
    @Inject
    @Qualifier("flatObjectMapper")
    FlatObjectMapper flatObjectMapper;

    @RequestMapping("/greeting")
    public void greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        long testCount = 100;
        // create test object
        List<FlatObject> inputFlatObjects = TestDataUtil.getTestObjects(testCount);

        StopWatch sw = new StopWatch();
        sw.start("Batched Data Insert");
        // insert data
        batchFlatObjectDAO.insert(inputFlatObjects);
        sw.stop();
        sw.start("Iterative Data Insert");
        inputFlatObjects.forEach(o -> flatObjectMapper.insertData(o));
        sw.stop();
//        LOGGER.info("Batch vs Iterative Insert Stats: "+ sw.prettyPrint())
    }
}