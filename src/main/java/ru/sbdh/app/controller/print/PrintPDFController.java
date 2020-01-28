package ru.sbdh.app.controller.print;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.common.GeneratePdf;
import ru.sbdh.app.controller.user.UserController;
import ru.sbdh.app.factory.PrintFactory;
import ru.sbdh.app.mapper.UserMapper;
import ru.sbdh.app.models.User;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

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