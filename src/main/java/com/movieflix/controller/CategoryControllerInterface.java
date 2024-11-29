package com.movieflix.controller;

import com.movieflix.controller.request.CategoryRequest;
import com.movieflix.controller.response.CategoryResponse;
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

@Tag(name="Category", description = "Recurso responsável pelo gerenciamento das categorias.")
public interface CategoryControllerInterface {
    @Operation(summary = "Listar Categorias", description = "Método responsável por listar todas as categorias",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de Categorias",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class))))
    public ResponseEntity<List<CategoryResponse>> getAllCategories();

    @Operation(summary = "Salvar Categoria", description = "Método responsável por salvar uma categoria",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Categoria salva com sucesso", content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest request);

    @Operation(summary = "Buscar Categoria", description = "Método responsável por buscar categoria pelo Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Categoria", content = @Content(schema = @Schema(implementation = CategoryResponse.class)))
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id);

    @Operation(summary = "Excluir Categoria", description = "Método responsável por excluir categoria pelo Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Categoria excluida com sucesso", content = @Content(schema = @Schema(implementation = Void.class)))
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
