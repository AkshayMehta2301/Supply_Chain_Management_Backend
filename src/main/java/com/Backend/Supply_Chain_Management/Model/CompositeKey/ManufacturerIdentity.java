package com.Backend.Supply_Chain_Management.Model.CompositeKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class ManufacturerIdentity implements Serializable {


    @NotNull
    @Size(max = 20)
    private String component;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Size(max = 20)
    private String location;
}
