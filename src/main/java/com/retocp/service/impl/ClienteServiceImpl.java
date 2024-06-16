package com.retocp.service.impl;

import com.retocp.dto.RegistroClienteDto;
import com.retocp.entity.Usuario;
import com.retocp.repository.ClienteRepository;
import com.retocp.entity.Cliente;
import com.retocp.repository.UsuarioRepository;
import com.retocp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Cliente insert(RegistroClienteDto dto) {
        Cliente cliente = Cliente.builder()
                .nombres(dto.getNombres()).apellidos(dto.getApellidos()).direccion(dto.getDireccion())
                .build();

        Usuario usuario = Usuario.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        clienteRepository.save(cliente);
        usuarioRepository.save(usuario);
        return cliente;
    }
}
