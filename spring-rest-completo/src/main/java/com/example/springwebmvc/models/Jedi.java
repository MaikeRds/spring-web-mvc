package com.example.springwebmvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Jedi {

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    @EqualsAndHashCode.Include
    private String name;

    @NotBlank
    @Size(max = 20, message = "Last Name must not have more than 20 letters")
    private String lastName;


}
