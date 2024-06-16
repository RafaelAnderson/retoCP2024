package com.retocp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroClienteDto {
    private String nombres;
    private String apellidos;
    private String direccion;
    private String username;
    private String password;
}
