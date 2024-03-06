package com.pessoas.membros.projeto.membrosprojeto;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosRequest;
import com.pessoas.membros.projeto.membrosprojeto.dto.MembrosResponse;
import com.pessoas.membros.projeto.membrosprojeto.entity.CargoEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.MembrosProjectEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.PessoaEntity;
import com.pessoas.membros.projeto.membrosprojeto.entity.ProjetoEntity;
import com.pessoas.membros.projeto.membrosprojeto.mapper.MembrosProjetoMapper;
import com.pessoas.membros.projeto.membrosprojeto.repository.MembrosRepository;
import com.pessoas.membros.projeto.membrosprojeto.services.CargoService;
import com.pessoas.membros.projeto.membrosprojeto.services.MembrosService;
import com.pessoas.membros.projeto.membrosprojeto.services.PessoaService;
import com.pessoas.membros.projeto.membrosprojeto.services.ProjetoService;


@SpringBootTest
public class MembrosServiceTest {

	@InjectMocks
    private MembrosService membrosService;

    @Mock
    private MembrosRepository membrosRepository;

    @Mock
    private MembrosProjetoMapper membrosProjetoMapper;

    @Mock
    private ProjetoService projetoService;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private CargoService cargoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCadastrarMembro() {
        
        MembrosRequest membrosRequest = new MembrosRequest();
        membrosRequest.setIdPessoa(1L);
        membrosRequest.setIdProjeto(2L);
        membrosRequest.setCargo("Developer");

        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome("Felipe");

        ProjetoEntity projetoEntity = new ProjetoEntity();

        CargoEntity cargoEntity = new CargoEntity();
        cargoEntity.setNome("Developer");
        cargoEntity.setPessoa(pessoaEntity);
        cargoEntity.setProjeto(projetoEntity);

        MembrosProjectEntity membrosProjectEntity = new MembrosProjectEntity();

        
        when(pessoaService.getPessoaEntityById(1L)).thenReturn(pessoaEntity);
        when(projetoService.getProjetoEntityById(2L)).thenReturn(projetoEntity);
        //when(cargoService.getCargoEntityByIdPessoaAndIdPRojeto(1L, 2L)).thenReturn(Optional.of(cargoEntity));
        when(cargoService.save(any(PessoaEntity.class), any(ProjetoEntity.class), eq("Developer"))).thenReturn(cargoEntity);
        when(membrosRepository.save(any(MembrosProjectEntity.class))).thenReturn(membrosProjectEntity);

       
        MembrosResponse response = membrosService.cadastrarMembro(membrosRequest);

        
        verify(pessoaService, times(1)).getPessoaEntityById(1L);
        verify(projetoService, times(1)).getProjetoEntityById(2L);
        verify(cargoService, times(1)).getCargoEntityByIdPessoaAndIdPRojeto(1L, 2L);
        verify(cargoService, times(1)).save(any(PessoaEntity.class), any(ProjetoEntity.class), eq("Developer"));
        verify(membrosRepository, times(0)).save(any(MembrosProjectEntity.class));

       
    }

    @Test
    public void testGetListMembros() {
       
    	 PessoaEntity pessoaEntity = new PessoaEntity();
         pessoaEntity.setNome("Felipe");

        MembrosProjectEntity membrosProjectEntity = new MembrosProjectEntity();
        membrosProjectEntity.setIdPessoa(pessoaEntity);
        List<MembrosProjectEntity> listMembros = new ArrayList<>();
        listMembros.add(membrosProjectEntity);

        MembrosResponse membrosResponse = new MembrosResponse();

       
        when(membrosRepository.findAll()).thenReturn(listMembros);
        when(membrosProjetoMapper.entityToResponse(membrosProjectEntity)).thenReturn(membrosResponse);

        MembrosRequest membrosRequest = new MembrosRequest();
        membrosRequest.setIdPessoa(1L);
        membrosRequest.setIdProjeto(2L);
        membrosRequest.setCargo("Developer");
        
       

        List<MembrosResponse> listResponse = membrosService.getListMembros(membrosRequest);

       
        verify(membrosRepository, times(0)).findAll();
        verify(membrosProjetoMapper, times(0)).entityToResponse(membrosProjectEntity);

        
    }

    @Test
    public void testGetListMembrosFuncioanrios() {
       
        long idProjeto = 1L;
        List<MembrosResponse> listResponse = new ArrayList<>();

        
        when(pessoaService.getPessoasToAddProjeto(idProjeto)).thenReturn(listResponse);

        
        List<MembrosResponse> result = membrosService.getListMembrosFuncioanrios(idProjeto);

        
        verify(pessoaService, times(1)).getPessoasToAddProjeto(idProjeto);

     
    }
}
