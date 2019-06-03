package com.example.project.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
