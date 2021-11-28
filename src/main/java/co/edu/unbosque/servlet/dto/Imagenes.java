package co.edu.unbosque.servlet.dto;

public class Imagenes {

    private String picture;

    public Imagenes(String pictures){
        this.picture = pictures;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
