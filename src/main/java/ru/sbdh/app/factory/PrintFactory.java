package ru.sbdh.app.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.sbdh.app.common.GeneratePdf;
import ru.sbdh.app.mapper.OtdelMapper;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import ru.sbdh.app.dao.mapper.UserMapper;
import java.util.List;

@Component
public class PrintFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintFactory.class);
    @Inject
    @Qualifier("userMapper")
    UserMapper userMapper;

    @Inject
    @Qualifier("otdelMapper")
    OtdelMapper otdelMapper;


    public ResponseEntity<InputStreamResource> printPdfClerk() throws UnsupportedEncodingException {
        ByteArrayInputStream result = GeneratePdf.getClerk(otdelMapper.getAllOtdelsWithUsers());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; name=hz; filename=" + URLEncoder.encode("Сотрудники СбиБХ.pdf", "UTF-8"));
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf; charset=UTF-8;");

        return ResponseEntity.ok().headers(headers)
                .body(new InputStreamResource(result));
    }
}
