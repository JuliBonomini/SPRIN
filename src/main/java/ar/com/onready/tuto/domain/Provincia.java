package ar.com.onready.tuto.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Provincia {

    @Id
    private int id;
    private String nombre;
    private int paisId;
}

