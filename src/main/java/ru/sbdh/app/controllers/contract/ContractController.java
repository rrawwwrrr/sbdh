package ru.sbdh.app.controllers.contract;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.sbdh.app.dao.mapper.ContractMapper;
import ru.sbdh.app.models.ContractModel;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/contract/")
public class ContractController {
    @Inject
    @Qualifier("contractMapper")
    ContractMapper contractMapper;

    @RequestMapping(value = "getAllContracts", method = RequestMethod.GET)
    public List<ContractModel> getAllContracts() {
        List<ContractModel> contractModel = contractMapper.getAllContracts();
        return contractModel;
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(value = "getContractsByYear", method = RequestMethod.GET)
    public List<ContractModel> getContractsByYear(@RequestParam(value = "year", defaultValue = "2020") Integer year) {
        List<ContractModel> contractModel = contractMapper.getContractsByYear(year);
        return contractModel;
    }

}
