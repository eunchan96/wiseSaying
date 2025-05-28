package com.back;

public class Quote {
    private int id;
    private String wiseSaying;
    private String author;

    public int getId() {
        return id;
    }
    public String getWiseSaying() {
        return wiseSaying;
    }
    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setWiseSaying(String wiseSaying) {
        this.wiseSaying = wiseSaying;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    public Quote(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "%d / %s / %s".formatted(id, author, wiseSaying);
    }
}