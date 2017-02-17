package com.example.model;

public class MeiZhi {
    private String id;

    private String filename;

    public MeiZhi(String id, String filename) {
        this.id = id;
        this.filename = filename;
    }

    public MeiZhi() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }
}