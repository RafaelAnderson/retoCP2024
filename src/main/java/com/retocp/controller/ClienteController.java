package com.retocp.controller;

import com.retocp.dto.RegistroClienteDto;
import com.retocp.entity.Cliente;
import com.retocp.service.ClienteService;
import com.retocp.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> insert(@RequestBody RegistroClienteDto registro) {
        Cliente c = clienteService.insert(registro);
        return ResponseEntity.ok(ApiResponse.ok("Cliente insertado", c));
    }
}
