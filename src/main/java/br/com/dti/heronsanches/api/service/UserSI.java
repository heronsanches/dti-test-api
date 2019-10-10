package br.com.dti.heronsanches.api.service;

import br.com.dti.heronsanches.api.entity.User;
import br.com.dti.heronsanches.api.restservice.jsonbind.patient.DefaultAnswerJB;

/** @author Heron Sanches */
public interface UserSI {
    DefaultAnswerJB insert(User user);
    DefaultAnswerJB auth(User user);
}