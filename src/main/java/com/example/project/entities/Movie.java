package com.example.project.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movie")
@JsonPropertyOrder(value = {"id", "info", "crew"})
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @Valid
    private Info info;

    @Embedded
    @Valid
    private Crew crew;



}
