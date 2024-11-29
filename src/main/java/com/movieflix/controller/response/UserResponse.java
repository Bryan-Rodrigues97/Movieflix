package com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(@Schema(type = "string", description = "Id do usuário")
                           Long id,
                           @Schema(type = "string", description = "Nome do usuário.")
                           String name,
                           @Schema(type = "string", description = "Email do usuário.")
                           String email) {
}
