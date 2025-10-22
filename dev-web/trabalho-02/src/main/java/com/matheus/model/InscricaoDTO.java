package com.matheus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class InscricaoDTO {
    private Long alunoId;
    private Long turmaId;
}

//package com.matheus.model;
//
//public record InscricaoDTO(Aluno aluno, Turma turma) {
//}
