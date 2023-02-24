package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.EnderecoBO;
import br.com.fiap.to.EnderecoTO;

@Path("/endereco")
public class EnderecoResource {

	EnderecoBO eb = new EnderecoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EnderecoTO> buscar() {
		return eb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EnderecoTO buscar(@PathParam("id") int id) {
		return eb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EnderecoTO endereco, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		eb.cadastrar(endereco);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(endereco.getIdEndereco()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(EnderecoTO endereco, @PathParam("id") int id) {
		endereco.setIdEndereco(id);
		eb.atualiza(endereco);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		eb.remover(id);
	}
}
