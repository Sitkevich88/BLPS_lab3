package ru.smart_transportation.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "article_theme",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "taste_id")}
    )
    private List<Theme> themes;


    @Column(name = "header", unique = true)
    private String header;

    @Column(name = "subheader")
    private String subheader;

    @Column(name = "text", unique = true)
    private String text;

    @Column(name="priority")
    private Integer priority;

    @Column(name = "photo")
    private String photo;

    @Column(name = "creation_date")
    @CreatedDate
    private String creationDate;


}