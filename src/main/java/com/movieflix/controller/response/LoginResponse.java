package com.movieflix.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record LoginResponse(@Schema(type = "string", description = "Toke de acesso")
                            String token) {
}
