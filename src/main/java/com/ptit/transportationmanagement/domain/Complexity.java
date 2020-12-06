package com.ptit.transportationmanagement.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "complexity")
@Data
public class Complexity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String code;

    @NotNull
    private String description;
    @NotNull
    private Double coefficientSalary;
    @NotNull
    private Integer status;

//    @OneToMany(mappedBy = "complexity")
//    private List<ComplexityRoute> complexityRoutes;
}
