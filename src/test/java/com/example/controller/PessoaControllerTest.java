package com.example.controller;

import com.example.model.Pessoa;
import com.example.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PessoaControllerTest {

    @InjectMocks
    private PessoaController pessoaController;

    @Mock
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        List<Pessoa> pessoas = Arrays.asList(pessoa1, pessoa2);

        when(pessoaRepository.findAll()).thenReturn(pessoas);

        List<Pessoa> result = pessoaController.getAll();

        assertEquals(2, result.size());
        verify(pessoaRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));

        ResponseEntity result = pessoaController.getById(1);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(pessoaRepository, times(1)).findById(1);
    }

    @Test
    public void testFindByNomeIgnoreCaseContainingOrderByNomeAsc() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.findByNomeIgnoreCaseContainingOrderByNomeAsc("João")).thenReturn(Arrays.asList(pessoa));

        ResponseEntity<?> result = pessoaController.findByNomeIgnoreCaseContainingOrderByNomeAsc("João");

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(pessoaRepository, times(1)).findByNomeIgnoreCaseContainingOrderByNomeAsc("João");
    }

    @Test
    public void testCreate() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        Pessoa result = pessoaController.create(pessoa);

        assertEquals(pessoa, result);
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    public void testUpdate() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        ResponseEntity result = pessoaController.update(1, pessoa);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(pessoaRepository, times(1)).findById(1);
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    public void testDelete() {
        doNothing().when(pessoaRepository).deleteById(1);

        ResponseEntity<?> result = pessoaController.delete(1);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(pessoaRepository, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteAll() {
        doNothing().when(pessoaRepository).deleteAll();

        ResponseEntity<?> result = pessoaController.deleteAll();

        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(pessoaRepository, times(1)).deleteAll();
    }
}