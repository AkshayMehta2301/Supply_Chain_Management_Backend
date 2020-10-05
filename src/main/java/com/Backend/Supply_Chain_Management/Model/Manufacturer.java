package com.Backend.Supply_Chain_Management.Model;

import com.Backend.Supply_Chain_Management.Model.CompositeKey.ManufacturerIdentity;
import com.Backend.Supply_Chain_Management.Util.UserInter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="manufacturer")
@Entity
public class Manufacturer implements UserInter {

    @EmbeddedId
    private ManufacturerIdentity manufacturerIdentity;

    @NotNull
    @Size(max = 10)
    private String id;

    @NotNull
    @Size( max = 20)
    private String email;
}
