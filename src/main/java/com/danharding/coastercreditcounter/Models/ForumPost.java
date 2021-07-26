package com.danharding.coastercreditcounter.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forumPosts")
public class ForumPost {
    public @Id @GeneratedValue long id;
    public String post;


public ForumPost() {

}

public ForumPost(String post) {
    this.post = post;
}


public long getId() {
    return id;
}

public String getPost() {
    return post;
}

    public void setPost(String post) {
        this.post = post;
    }
}
