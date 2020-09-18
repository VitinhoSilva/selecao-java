package com.java.desafioindra.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.java.desafioindra.model.Registro;
import com.java.desafioindra.repository.RegistroRepository;
import com.java.desafioindra.service.RegistroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
@Api(value="API REST Posto")
public class RegistroResource {
	
	@Autowired
	RegistroService registroService;
	
	@Autowired
	RegistroRepository registroRepository;
	
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
	
    @ApiOperation(value="Load do csv")
	@GetMapping("/load")
	public BatchStatus loadData() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    	Map<String, JobParameter> maps = new HashMap<>();
	    maps.put("time", new JobParameter(System.currentTimeMillis()));
	    JobParameters parameters = new JobParameters(maps);
	    JobExecution jobExecution = jobLauncher.run(job, parameters);
	    System.out.println("JobExecution: " + jobExecution.getStatus());
	    System.out.println("Batch is Running...");
	    while (jobExecution.isRunning()) {
	        System.out.println("...");
        }
        return jobExecution.getStatus();
	}
	
    @ApiOperation(value="Retorna todos os registros")
    @GetMapping("/registros")
	public List<Registro> listaRegistro() {
		return registroRepository.findAll();
	}
    
    @ApiOperation(value="Retorna as médias de valor de compra e valor de venda por bandeira *PARÂMETRO DE EXEMPLO:RAIZEN")
	@GetMapping("/registros/bandeira")
	public HashMap<String, Object> listaRegistroBandeira(@RequestParam("bandeira") String bandeira){
		HashMap<String, Object> registros = registroService.findCompraVendaBandeira(bandeira);		
		return registros;
	}
	
    @ApiOperation(value="Retorna as médias de valor de compra e valor de venda por município *PARÂMETRO DE EXEMPLO:BRASILIA")
	@GetMapping("/registros/municipio")
	public HashMap<String, Object> listaRegistroMunicipio(@RequestParam("municipio") String municipio){
		HashMap<String, Object> registros = registroService.findCompraVendaMunicipio(municipio);	
		return registros;
	}
	
    @ApiOperation(value="Retorna todos os registros da data da coleta inserida *PARÂMETRO DE EXEMPLO:16/01/2019")
	@GetMapping("/registros/datacoleta")
	public List<Registro> listaRegistroDataColeta(@RequestParam("datacoleta") String datacoleta){
		return registroService.findByPorDataColeta(datacoleta);
	}
	
    @ApiOperation(value="Retorna todos os registros da sigla inserida *PARÂMETRO DE EXEMPLO:CO")
	@GetMapping("/registros/regiaosigla")
	public List<Registro> listaRegistroRegiaoSigla(@RequestParam("regiaosigla") String regiaosigla){
		return registroService.findByPorRegiaoSigla(regiaosigla);
	}
	
    @ApiOperation(value="Retorna todos os registros do posto da revenda inserida *PARÂMETRO DE EXEMPLO:AUTO POSTO CRIOLO LTDA")
	@GetMapping("/registros/revenda")
	public List<Registro> listaRegistroRevenda(@RequestParam("revenda") String revenda){
		return registroService.findByPorRevenda(revenda);
	}
	
    @ApiOperation(value="Retorna a média de valor de venda por município *PARÂMETRO DE EXEMPLO:BRASILIA")
	@GetMapping("/registros/municipiounico")
	public HashMap<String, Object> listaRegistroPorMunicipioUnico(@RequestParam("municipio") String municipio){
		return registroService.findByPorMunicipioUnico(municipio);
	}
	
}
