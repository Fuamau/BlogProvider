/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sov.model;

/**
 *
 * @author admin
 */
public class BlogItem {

    private String id;
    private String Title;
    private String Content;
    private String CreatedAt;
    private boolean Ready;

    public BlogItem(String id, String Title, String Content, String CreatedAt, boolean Ready) {
        this.id = id;
        this.Title = Title;
        this.Content = Content;
        this.CreatedAt = CreatedAt;
        this.Ready = Ready;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public boolean isReady() {
        return Ready;
    }

    public void setReady(boolean Ready) {
        this.Ready = Ready;
    }
       
    @Override
    public String toString() {
        return "BlogItem{" + "id=" + id + ", Title=" + Title + ", Content=" + Content + ", CreatedAt=" + CreatedAt + ", Ready=" + Ready + '}';
    }
}
