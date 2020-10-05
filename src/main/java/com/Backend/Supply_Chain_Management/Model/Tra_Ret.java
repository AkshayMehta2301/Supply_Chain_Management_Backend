package com.Backend.Supply_Chain_Management.Model;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.TraRetIdentity;
import com.Backend.Supply_Chain_Management.Util.UserInter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tra_ret")
@Entity
public class Tra_Ret implements UserInter {

    @EmbeddedId
    TraRetIdentity traRetIdentity;

    @NotNull
    @Size(max = 10)
    private String id;

    @NotNull
    @Size(max = 20)
    private String email;

}
