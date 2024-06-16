package com.retocp.service;

import com.retocp.dto.RegistroClienteDto;
import com.retocp.entity.Cliente;

public interface ClienteService {

    Cliente insert(RegistroClienteDto registro);
}
