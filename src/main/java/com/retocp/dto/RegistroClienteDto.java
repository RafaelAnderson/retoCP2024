package com.retocp.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class RegistroClienteDto {
    private String nombres;
    private String apellidos;
    private String direccion;
    private String username;
    private String password;
}
