package com.movieflix.controller.response;

import com.movieflix.entity.Category;
import com.movieflix.entity.Streaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "lonb", description = "Id do filme.")
                            Long id,
                            @Schema(type = "string", description = "Título do filme.")
                            String title,
                            @Schema(type = "string", description = "Descrição do filme.")
                            String description,
                            @Schema(type = "date", description = "Data de lançamento do filme.")
                            LocalDate releaseDate,
                            @Schema(type = "double", description = "Rating do filme.")
                            Double rating,
                            @Schema(type = "date", description = "Data de crição do registro no banco.")
                            LocalDateTime createdAt,
                            @Schema(type = "date", description = "Data de atualização do registro no banco.")
                            LocalDateTime updatedAt,
                            @Schema(type = "array", description = "Lista de categorias do filme.")
                            List<Category> categories,
                            @Schema(type = "array", description = "Lista de streamings do filme.")
                            List<Streaming> streamings) {
}
