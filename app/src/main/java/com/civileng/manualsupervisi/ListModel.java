package com.civileng.manualsupervisi;

/**
 * Created by fata on 10/18/2017.
 */

public class ListModel {
    private String id;
    private String tipe;
    private String title;
    private String subtitle;

    public ListModel() {
    }

    public ListModel(String id, String tipe, String title, String subtitle) {
        this.id = id;
        this.tipe = tipe;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
