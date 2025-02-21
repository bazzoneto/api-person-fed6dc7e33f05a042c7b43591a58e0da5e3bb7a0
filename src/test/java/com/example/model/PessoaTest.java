package com.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    private Pessoa pessoa;

    @BeforeEach
    public void setUp() {
        pessoa = new Pessoa();
    }

    @Test
    public void testGetSetId() {
        pessoa.setId(1);
        assertEquals(1, pessoa.getId());
    }

    @Test
    public void testGetSetNome() {
        String nome = "João";
        pessoa.setNome(nome);
        assertEquals(nome, pessoa.getNome());
    }

    @Test
    public void testGetSetSexo() {
        String sexo = "M";
        pessoa.setSexo(sexo);
        assertEquals(sexo, pessoa.getSexo());
    }

    @Test
    public void testGetSetEmail() {
        String email = "joao@example.com";
        pessoa.setEmail(email);
        assertEquals(email, pessoa.getEmail());
    }

    @Test
    public void testGetSetDataNascimento() {
        String dataNascimento = "01/01/2000";
        pessoa.setDataNascimento(dataNascimento);
        assertEquals(dataNascimento, pessoa.getDataNascimento());
    }

    @Test
    public void testGetSetNaturalidade() {
        String naturalidade = "São Paulo";
        pessoa.setNaturalidade(naturalidade);
        assertEquals(naturalidade, pessoa.getNaturalidade());
    }

    @Test
    public void testGetSetNacionalidade() {
        String nacionalidade = "Brasileira";
        pessoa.setNacionalidade(nacionalidade);
        assertEquals(nacionalidade, pessoa.getNacionalidade());
    }

    @Test
    public void testGetSetCpf() {
        String cpf = "123.456.789-00";
        pessoa.setCpf(cpf);
        assertEquals(cpf, pessoa.getCpf());
    }

    @Test
    public void testGetSetAtualizado() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        pessoa.setAtualizado(timestamp);
        assertEquals(timestamp, pessoa.getAtualizado());
    }
}