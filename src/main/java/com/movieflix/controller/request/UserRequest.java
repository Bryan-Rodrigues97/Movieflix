package com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record UserRequest(@Schema(type = "string", description = "Email do usuário.")
                          String name, String email,
                          @Schema(type = "string", description = "Senha do usuário.")
                          String password) {
}
