package com.training.sample.springboothellorest.domaine;

import javax.persistence.*;

@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Version
    int version;

    String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

