package ar.com.onready.tuto.domain;

public class Provincia {

    private int id;
    private String nombre;
    private int paisId;

    public Provincia() {
    }

    public Provincia(int id, String nombre, int paisId) {
        this.id = id;
        this.nombre = nombre;
        this.paisId = paisId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPaisId() {
        return paisId;
    }

    public void setPaisId(int paisId) {
        this.paisId = paisId;
    }
}

