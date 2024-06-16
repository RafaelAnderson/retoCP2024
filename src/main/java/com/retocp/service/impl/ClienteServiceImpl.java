package com.retocp.service.impl;

import com.retocp.repository.ClienteRepository;
import com.retocp.entity.Cliente;
import com.retocp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteDao;

    public Cliente insert(Cliente cliente) {
        clienteDao.save(cliente);
        return cliente;
    }
}
