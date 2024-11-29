package com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(@Schema(type = "string", description = "Email do usuário")
                           String email,
                           @Schema(type = "string", description = "Senha do usuário")
                           String password) {
}
