package com.java.desafioindra.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.java.desafioindra.repository.RegistroRepository;
import com.java.desafioindra.model.Registro;

@Service
public class RegistroService {
	@Autowired
	RegistroRepository registroRepository;
	
	  public HashMap<String, Object> findCompraVendaBandeira(String bandeira) {
	    HashMap<String, Object> retorno = new HashMap<String,Object>();
	    List<Registro> registros = registroRepository.findByBandeira(bandeira);

	    double compra = 0.0;
	    double venda = 0.0;
	    
	    for(Registro registro : registros){
	      if (registro.getBandeira().equalsIgnoreCase(bandeira)){
	        compra += (double) registro.getValorcompra();
	        venda += (double) registro.getValorvenda();
	      }
	    }

	    double media_compra = compra / registros.size(); 
	    double media_venda =  venda / registros.size();

	    retorno.put("VALOR_MEDIA_VENDA", media_venda);
	    retorno.put("VALOR_MEDIA_COMPRA", media_compra);
	    retorno.put("BANDEIRA", bandeira);

	    return retorno;
	  }

	  public HashMap<String, Object> findCompraVendaMunicipio(String municipio) {
	  	HashMap<String, Object> retorno = new HashMap<String,Object>();
	    List<Registro> registros = registroRepository.findByMunicipio(municipio);

	    double compra = 0.0;
	    double venda = 0.0;
	    
	    for(Registro registro : registros){
	      if (registro.getMunicipio().equalsIgnoreCase(municipio)){
	        compra += (double) registro.getValorcompra();
	        venda += (double) registro.getValorvenda();
	      }
	    }
	    
	    double media_compra = compra / registros.size(); 
	    double media_venda =  venda / registros.size();

	    retorno.put("VALOR_MEDIA_VENDA", media_venda);
	    retorno.put("VALOR_MEDIA_COMPRA", media_compra);
	    retorno.put("MUNICIPIO", municipio);

	    return retorno;
	  }
	  
	  public List<Registro> findByPorDataColeta(String datacoleta) {
		  List<Registro> registros = registroRepository.findByDatacoleta(datacoleta);
		   return registros;
	  }
	  
	  public List<Registro> findByPorRegiaoSigla(String regiaosigla) {
		  List<Registro> registros = registroRepository.findByRegiaosigla(regiaosigla);
		  return registros;
	  }
	  
	  public List<Registro> findByPorRevenda(String revenda) {
		  List<Registro> registros = registroRepository.findByRevenda(revenda);
		  return registros;
	  }
	  
	  public HashMap<String, Object> findByPorMunicipioUnico(String municipio) {		  
	  	  HashMap<String, Object> retorno = new HashMap<String,Object>();
	      List<Registro> registros = registroRepository.findByMunicipio(municipio);

	      double venda = 0.0;
	    
	      for(Registro registro : registros){
	        if (registro.getMunicipio().equalsIgnoreCase(municipio) ){
	          venda += (double) registro.getValorvenda();
	        }
	      }
	    
	      double media_venda =  venda / registros.size();

	      retorno.put("VALOR_MEDIA_VENDA", media_venda);
	      retorno.put("MUNICIPIO", municipio);

          return retorno;
	  }
	 
	
}
