package com.youhungry.endpoint.controller;


import com.youhungry.endpoint.model.Usuario;
import com.youhungry.endpoint.repository.UsuarioRepository;
import com.youhungry.endpoint.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService = UsuarioService.getInstance();

    @GetMapping
    public List<Usuario> listaUsuario(){
        UsuarioRepository ur = new UsuarioRepository();
        return ur.todosUsuarios();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPessoa(Usuario usuario) {
        Usuario savedUsuario = usuarioService.createUsuario(usuario);
        return Response.created(URI.create(String.format("/usuarios/%d", savedUsuario.getIdusuario()))).entity(savedUsuario).build();
    }

    @ApiOperation(
            value = "Retorna uma usuario apartir do seu ID",
            produces = MediaType.APPLICATION_JSON)
    @ApiResponses({
            @ApiResponse(
                    code = 200,
                    message = "Dados do Usuário",
                    response = Usuario.class
            ),
            @ApiResponse(
                    code = 404,
                    message = "Usuário não encontrado!"
            )
    })
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);

        if (usuario.isPresent()) {
            return Response.ok(usuario).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuarios(Usuario usuario) {
        return Response.ok(usuarioService.updateUsuario(usuario)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(@PathParam("id") Long id) {
        usuarioService.deleteUsuarioById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @ApiOperation(
            value = "Retorna a lista de todos os usuários",
            produces = MediaType.APPLICATION_JSON)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response todosUsuarios() {
        return Response.ok(usuarioService.todosUsuarios()).build();
    }

}
