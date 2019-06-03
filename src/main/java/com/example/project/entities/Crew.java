package com.example.project.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Data
public class Crew {

    @NotBlank(message = "movie casts are required")
    @JsonProperty(value = "movie_casts")
    private String casts;

    @NotBlank(message = "movie director is required")
    @JsonProperty(value = "movie_director")
    private String director;
}
