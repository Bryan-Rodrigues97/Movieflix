package com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(@NotEmpty(message = "O nome do streaming é obrigatório")
                               @Schema(type = "string", description = "Nome do serviço de streaming.")
                               String name) {
}
