package com.movieflix.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@NotEmpty(message = "O título do filme é obrigatório")
                           @Schema(type = "string", description = "Título do fime.")
                           String title,
                           @Schema(type = "string", description = "Descrição do filme.")
                           String description,
                           @Schema(type = "date", description = "Data de lançamento do filme.")
                           LocalDate releaseDate,
                           @Schema(type = "double", description = "Rating do filme.")
                           Double rating,
                           @Schema(type = "array", description = "Lista de códigos de categoria.")
                           List<Long> categories,
                           @Schema(type = "array", description = "Lista de códigos de streaming.")
                           List<Long> streamings) {
}
