package com.example.librarymanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id",length = 11)
    private int publisherId;

    @Column(name = "name", length = 45)
    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;


    public Publisher(int authorId, String name) {
        this.publisherId = authorId;
        this.name = name;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                '}';
    }
}
