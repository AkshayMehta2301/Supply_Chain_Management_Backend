package com.Backend.Supply_Chain_Management.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Login {

    @JsonProperty("id")
    @Size(max = 10)
    @Nullable
    private String id;

    @Id
    @NotNull
    private String email;

    @NotNull
    private String passwd;
}
