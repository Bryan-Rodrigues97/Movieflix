package com.movieflix.controller;

import com.movieflix.controller.request.LoginRequest;
import com.movieflix.controller.request.UserRequest;
import com.movieflix.controller.response.LoginResponse;
import com.movieflix.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Auth", description = "Recurso responsável pelo gerenciamento de autenticação.")
public interface AuthControllerInterface {
    @Operation(summary = "Cadastrar Usuário", description = "Método responsável por cadastrar um usuário")
    @ApiResponse(responseCode = "201", description = "Usuário cadastrado com sucesso", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "409", description = "Conflito na base de dados. O registro não pode ser cadastrado", content = @Content(schema = @Schema(implementation = String.class)))
    @ApiResponse(responseCode = "400", description = "Payload incorreto", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request);

    @Operation(summary = "Login do Usuário", description = "Método responsável pelo login do usuário")
    @ApiResponse(responseCode = "201", description = "Usuário logado com sucesso", content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    @ApiResponse(responseCode = "400", description = "Usuário ou senha incorreto", content = @Content(schema = @Schema(implementation = String.class)))
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);
}
