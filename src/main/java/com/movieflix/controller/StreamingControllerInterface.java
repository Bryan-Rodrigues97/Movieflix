package com.movieflix.controller;

import com.movieflix.controller.request.StreamingRequest;
import com.movieflix.controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name="Streaming", description = "Recurso responsável pelo gerenciamento dos streamings.")
public interface StreamingControllerInterface {
    @Operation(summary = "Listar streamings", description = "Método responsável por listar todos os streamings",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Lista de Streamings",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    public ResponseEntity<List<StreamingResponse>> getAll();

    @Operation(summary = "Salvar streaming", description = "Método responsável por salvar um streaming",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Streaming salvo com sucesso", content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request);

    @Operation(summary = "Buscar streaming", description = "Método responsável por buscar um streaming pelo Id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Streaming", content = @Content(schema = @Schema(implementation = StreamingResponse.class)))
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id);

    @Operation(summary = "Excluir streaming", description = "Método responsável por excluir um streaming",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Streaming excluido com sucesso", content = @Content(schema = @Schema(implementation = Void.class)))
    public ResponseEntity<Void> deleteById(@PathVariable Long id);
}
