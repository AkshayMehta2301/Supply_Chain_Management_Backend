package com.Backend.Supply_Chain_Management.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Builder
public class User {

    @Nullable
    private String name;

    @Nullable
    private String type;

    @Nullable
    @Size(max = 20)
    private String location;

    @Nullable
    @JsonProperty("component")
    private String component;
}
