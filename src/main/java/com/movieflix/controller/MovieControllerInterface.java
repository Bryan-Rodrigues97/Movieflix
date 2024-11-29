package com.movieflix.controller;

import com.movieflix.controller.request.MovieRequest;
import com.movieflix.controller.response.MovieResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Movie", description = "Recurso responsável pelo gerenciamento dos filmes.")
public interface MovieControllerInterface {
    @Operation(summary = "Listar filmes", description = "Método responsável por listar todos os filmes",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de filmes",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    public ResponseEntity<List<MovieResponse>> getAll();

    @Operation(summary = "Listar filmes por categoria", description = "Método responsável por listar filmes por categoria",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de filmes por categoria",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category);

    @Operation(summary = "Buscar filme", description = "Método responsável por buscar um filme pelo seu Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme", content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id);

    @Operation(summary = "Salvar Filme", description = "Método responsável por salvar um novo filme",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso", content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request);

    @Operation(summary = "Atualizar filme", description = "Método responsável por atualizar um filme",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Filme atualiazado com sucesso", content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request);

    @Operation(summary = "Excluir filme", description = "Método responsável por excluir um filme",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Filme excluido com sucesso ", content = @Content(schema = @Schema(implementation = Void.class)))
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
