package ru.sbdh.app.controllers.print;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.factory.PrintFactory;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/printpdf/")
public class PrintPDFController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintPDFController.class);

    @Inject
    @Qualifier("printFactory")
    PrintFactory printFactory;

    @RequestMapping("clerk")
    public ResponseEntity getclerk() throws UnsupportedEncodingException {
        return printFactory.printPdfClerk();
    }
}