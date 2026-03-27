package weg.senai.atv1.dto.funcionario;

public record FuncionarioResponse(

        long id,
        String nome,
        int idade,
        String cpf,
        long departamentoId

) {
}
