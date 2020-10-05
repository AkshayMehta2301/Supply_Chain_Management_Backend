package com.Backend.Supply_Chain_Management.Model;

import com.Backend.Supply_Chain_Management.Util.UserInter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="admin")
@Entity
public class Admin implements UserInter {

    @Id
    @JsonProperty("id")
    @Size(max = 10)
    private String id;

    @NotNull
    private String name;

    @NotNull
    @Size(max=20)
    @Column(unique=true)
    private String email;

    @NotNull
    @Size(max = 20)
    private String location;
}
