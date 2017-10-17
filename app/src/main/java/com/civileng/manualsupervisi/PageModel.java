package com.civileng.manualsupervisi;

/**
 * Created by fata on 10/18/2017.
 */

public class PageModel {
    private String id;
    private String tipe;
    private String divisi;
    private String idList;
    private String idHtml;

    public PageModel() {
    }

    public PageModel(String id, String tipe, String divisi, String idList, String idHtml) {
        this.id = id;
        this.tipe = tipe;
        this.divisi = divisi;
        this.idList = idList;
        this.idHtml = idHtml;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getIdHtml() {
        return idHtml;
    }

    public void setIdHtml(String idHtml) {
        this.idHtml = idHtml;
    }
}
