package br.com.dti.heronsanches.api.restservice;

import br.com.dti.heronsanches.api.entity.User;
import br.com.dti.heronsanches.api.restservice.jsonbind.patient.DefaultAnswerJB;
import br.com.dti.heronsanches.api.service.UserSI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** @author heronsanches */
@RestController
@RequestMapping("/dti-api/user")
public class UserRS {
    @Autowired
    private UserSI userSI;
    
    @RequestMapping(method = RequestMethod.POST)
    public DefaultAnswerJB post(@RequestBody User user){
       return userSI.insert(user);
    }
}
