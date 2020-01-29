package ru.sbdh.app.controllers.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sbdh.app.dao.mapper.UserMapper;
import ru.sbdh.app.factory.PrintFactory;
import ru.sbdh.app.factory.UserFactory;
import ru.sbdh.app.models.UserModel;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {


    @Inject
    @Qualifier("userFactory")
    UserFactory userFactory;

    @Inject
    @Qualifier("printFactory")
    PrintFactory printFactory;


    @RequestMapping(value = "getbyid", method = RequestMethod.GET)
    public UserModel getuserbyid(@RequestParam(value = "id", defaultValue = "World") Integer id) {
        UserModel user = userFactory.getUserById(id);
        return user;
    }

    @RequestMapping("getall")
    public List<UserModel> getallusers() {
        List<UserModel> user = userFactory.getAllUsers();
        return user;
    }
    @RequestMapping(value = "getbydid", method = RequestMethod.GET)
    public UserModel getuserbydid(@RequestParam(value = "id", defaultValue = "World") Integer id) {
        UserModel user = userFactory.getUserById(id);
        return user;
    }

    @RequestMapping("clerk")
    public ResponseEntity getclerk() throws UnsupportedEncodingException {
        return printFactory.printPdfClerk();
    }

    @RequestMapping("getbyid")
    public UserModel getUserById(@RequestParam(value = "id", defaultValue = "5") Integer id) {
        return userFactory.getUserById(id);
    }
}