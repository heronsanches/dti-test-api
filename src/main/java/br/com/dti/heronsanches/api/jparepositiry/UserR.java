package br.com.dti.heronsanches.api.jparepositiry;

import br.com.dti.heronsanches.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/** @author Heron Sanches */
public interface UserR extends JpaRepository<User, String>{
   User findByUsuario(String usuario);
}