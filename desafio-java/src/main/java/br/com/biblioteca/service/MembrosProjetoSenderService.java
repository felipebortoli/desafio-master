package br.com.biblioteca.service;


import java.net.http.HttpResponse;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.biblioteca.dto.MembrosDTO;
import br.com.biblioteca.dto.request.MembrosRequest;
import br.com.biblioteca.util.HttpUtil;

@Component
@Scope("singleton")
public class MembrosProjetoSenderService {

	private final HttpUtil httpUtil;
	 public final ObjectMapper mapper;
	
	private static final String URL_CREATE_MEMBROS_PROJETO = "/membros/create";
	private static final String URL_LIST_MEMBROS_PROJETO = "/membros/listfunc";
	
	public MembrosProjetoSenderService() {
		this.httpUtil = new HttpUtil();
		this.mapper = new ObjectMapper();
	}
	
	public MembrosProjetoSenderService(HttpUtil httpUtil, ObjectMapper mapper) {
		super();
		this.httpUtil = httpUtil;
		this.mapper = mapper;
	}



	@Transactional
	public void createMembrosProjeto(long idPessoa, long idProjeto, String cargo) throws Exception {
		String url = "http://localhost:8090" + URL_CREATE_MEMBROS_PROJETO;
		MembrosRequest request = new MembrosRequest();
		request.setCargo(cargo);
		request.setIdPessoa(idPessoa);;
		request.setIdProjeto(idProjeto);
		this.httpUtil.requestPOST(url, objectToJson(request));
	}
	
	public List<MembrosDTO> listMembrosProjeto(long idProjeto) throws Exception {
		String url = "http://localhost:8090" + URL_LIST_MEMBROS_PROJETO + "?idProjeto=" + idProjeto;
        HttpResponse<String> result;
        try {
            result = this.httpUtil.requestGET(url);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível buscar lista de Membros: " + url, e);
        }

        if (result.statusCode() != HttpStatus.OK.value()) {
            throw new RuntimeException(
                    "Não foi possível buscar lista de Membros: http code: " + result.statusCode() + "url:" + url);
        }

        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(result.body());
            return mapper.readValue(jsonNode.get("body").toString(), new TypeReference<List<MembrosDTO>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao processar resposta JSON", e);
        }
	}
	
	private String objectToJson(Object obj) {
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter objeto para JSON", e);
        }
    }
}
