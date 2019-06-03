package com.example.project.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Data

public class Info {

    @NotBlank(message = "movie title is required")
    @JsonProperty(value = "movie_title")
    private String title;

    @NotBlank(message = "movie year is required")
    @JsonProperty(value = "movie_year" )
    private String movieYear;

    @NotBlank(message = "movie description is required")
    @JsonProperty(value = "movie_description")
    private String movieDescription;

}
