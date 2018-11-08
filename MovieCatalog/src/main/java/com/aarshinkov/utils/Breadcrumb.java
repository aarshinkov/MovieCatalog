package com.aarshinkov.utils;

import java.io.Serializable;

public class Breadcrumb implements Serializable {
    private String label;
    private String url;

    public Breadcrumb() {
    }

    public Breadcrumb(String label, String url) {
        this.label = label;
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
