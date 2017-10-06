package ar.com.onready.tuto.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class Provincia {

    @Id
    private int id;
    private String nombre;
    private int paisId;
}

