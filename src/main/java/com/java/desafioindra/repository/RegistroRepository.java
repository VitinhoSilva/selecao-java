package com.java.desafioindra.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.java.desafioindra.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
	List<Registro> findByBandeira(String bandeira);
	List<Registro> findByMunicipio(String municipio);
	List<Registro> findByDatacoleta(String datacoleta);
	List<Registro> findByRegiaosigla(String regiaosigla);
	List<Registro> findByRevenda(String revenda);
}
