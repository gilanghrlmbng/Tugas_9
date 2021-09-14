package com.e.cobanavbar;

public class TrendModel {
    private String url;
    private String title;
    private String urlwebview;

    public TrendModel(String url, String title, String urlwebview) {
        this.url = url;
        this.title = title;
        this.urlwebview = urlwebview;
    }


    public String getUrlwebview() {
        return urlwebview;
    }

    public void setUrlwebview(String urlwebview) {
        this.urlwebview = urlwebview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
