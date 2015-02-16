package com.besttravelproject.model;

/**
 * Created by А on 08.01.15.
 */
public class Country {
    int id;
    String nameEn;
    String nameRu;
    String name;

    public Country() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
