package weg.senai.atv1.dto.funcionario;

public record FuncionarioRequest(

        String nome,
        int idade,
        String cpf,
        long departamentoId


) {
}
