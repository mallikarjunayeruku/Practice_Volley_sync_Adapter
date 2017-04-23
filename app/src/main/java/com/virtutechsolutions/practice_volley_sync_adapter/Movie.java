package com.virtutechsolutions.practice_volley_sync_adapter;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mallikarjuna on 20-04-2017.
 */

public class Movie {

    @SerializedName("poster_path")
    private  String PosterPth;

    @SerializedName("adult")
    private  boolean Adult;

    @SerializedName("overview")
    private String OverView;

    @SerializedName("release_date")
    private  String releaseDate;

    @SerializedName("genre_ids")
    private List<Integer> genre_ids=new ArrayList<Integer>();

    @SerializedName("id")
    private Integer id;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("original_language")
    private  String original_language;

    @SerializedName("title")
    private String title;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("popularity")
    private  Double popularity;

    @SerializedName("vote_count")
    private Integer vote_count;

    @SerializedName("video")
    private Boolean video;

    @SerializedName("vote_average")
    private Double vote_average;


public  Movie(String PosterPath,boolean adult,String overview,String releasedate,List<Integer> genre_ids,Integer id,String original_title
               ,String original_language,String title,String backdrop_path,Double popularity,Integer vote_count,Boolean video,Double vote_average)
{
    this.PosterPth=PosterPath;
    this.Adult=adult;
    this.OverView=overview;
    this.releaseDate=releasedate;
    this.genre_ids=genre_ids;
    this.id=id;
    this.original_title=original_title;
    this.original_language=original_language;
    this.title=title;
    this.backdrop_path=backdrop_path;
    this.popularity=popularity;
    this.vote_count=vote_count;
    this.video=video;
    this.vote_average=vote_average;
}


    public String getPosterPth() {
        return PosterPth;
    }

    public void setPosterPth(String posterPth) {
        PosterPth = posterPth;
    }

    public boolean isAdult() {
        return Adult;
    }

    public void setAdult(boolean adult) {
        Adult = adult;
    }

    public String getOverView() {
        return OverView;
    }

    public void setOverView(String overView) {
        OverView = overView;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }
}
