package br.com.dti.heronsanches.api.service;

import br.com.dti.heronsanches.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.dti.heronsanches.api.jparepositiry.UserR;
import br.com.dti.heronsanches.api.restservice.jsonbind.patient.DefaultAnswerJB;

/** @author Heron Sanches */
@Service("userS")
public class UserS implements UserSI {
    @Autowired
    private UserR userR;

    private static final String DEFAULT_ERROR_MESSAGE = "Serviço indisponível no momento. Tente " +
                                                        "novamente mais tarde.";

    @Override
    public DefaultAnswerJB auth(User user) {
       User userFound = userR.findByUsuario(user.getUsuario());
       DefaultAnswerJB defaultAnswerJB = new DefaultAnswerJB();

       if(userFound != null && userFound.getSenha().equals(user.getSenha())){
            defaultAnswerJB.setSucesso(true);
            return defaultAnswerJB;
       }
       defaultAnswerJB.setSucesso(false);
       defaultAnswerJB.setMensagemErro(DEFAULT_ERROR_MESSAGE);
       return defaultAnswerJB;
    }

    @Override
    @Transactional(rollbackForClassName={"Exception"})
    public DefaultAnswerJB insert(User user) {
        User userInserted = userR.findByUsuario(user.getUsuario());
        DefaultAnswerJB defaultAnswerJB = new DefaultAnswerJB();

        if(userInserted == null){
            userR.save(user);
            defaultAnswerJB.setSucesso(true);
            return defaultAnswerJB;
        }
        defaultAnswerJB.setMensagemErro(DEFAULT_ERROR_MESSAGE);
        defaultAnswerJB.setSucesso(false);
        return defaultAnswerJB;
    }
}