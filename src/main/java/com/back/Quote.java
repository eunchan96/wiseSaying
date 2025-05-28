package com.back;

public class Quote {
    int id;
    String wiseSaying;
    String author;

    public Quote(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "%d / %s / %s".formatted(id, author, wiseSaying);
    }
}