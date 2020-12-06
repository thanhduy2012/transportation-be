package com.ptit.transportationmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
    private Long id;

    @NotNull
    private String roleName;

    @NotNull
    private String description;
}
