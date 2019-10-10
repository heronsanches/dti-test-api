package br.com.dti.heronsanches.api.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/** @author Heron Sanches */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Size(min = 6)
    @Column(name = "id_email")
    private String usuario;

    @Basic(optional = false)
    @Size(min = 6)
    @Column(name = "password")
    private String senha;

    public User() { }

    public User(String usuario, String senha) {
       this.usuario = usuario;
       this.senha = senha;
    }

    public String getSenha() { return senha; }

    public String getUsuario() { return usuario; }
}