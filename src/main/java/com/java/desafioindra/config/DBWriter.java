package com.java.desafioindra.config;

import com.java.desafioindra.model.Registro;
import com.java.desafioindra.repository.RegistroRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DBWriter implements ItemWriter<Registro> {

    @Autowired
    private RegistroRepository userRepository;

    @Override
    public void write(List<? extends Registro> registro) throws Exception {

        System.out.println("-> Registro: " + registro);
        userRepository.saveAll(registro);
    }
}
