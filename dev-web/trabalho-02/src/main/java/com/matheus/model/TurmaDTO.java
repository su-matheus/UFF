package com.matheus.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TurmaDTO {
    private int ano;
    private String periodo;
    private Long professorId;

    private Long disciplinaId;
}
