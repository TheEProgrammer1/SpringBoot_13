package com.example.demo;

import javax.persistence.*;

@Entity
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private long year;
    private String description;

    @ManyToMany
    @JoinTable(
            name="movie_actor",
            joinColumns=@JoinColumn(name="MOVIE_ID",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name="ACTOR_ID",
            referencedColumnName="ID"))
    private Set<Actor> cast;

    public void AddActor(Actor actor)
    {
        cast.add(actor);
    }


}
