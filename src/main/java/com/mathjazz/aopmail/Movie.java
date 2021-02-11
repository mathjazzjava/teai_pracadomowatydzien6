package com.mathjazz.aopmail;

public class Movie {

    private String title;
    private long year;
    private String production;

    public Movie(String title, long year, String production) {
        this.title = title;
        this.year = year;
        this.production = production;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public long getYear() {
        return year;
    }

    public String getproduction() {
        return production;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setproduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", production='" + production + '\'' +
                '}';
    }
}
