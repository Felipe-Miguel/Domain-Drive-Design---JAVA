package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.TelefoneBO;
import br.com.fiap.to.TelefoneTO;

@Path("/telefone")
public class TelefoneResource {

	TelefoneBO tb = new TelefoneBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TelefoneTO> buscar() {
		return tb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TelefoneTO buscar(@PathParam("id") int id) {
		return tb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(TelefoneTO telefone, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		tb.cadastrar(telefone);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(telefone.getIdTelefone()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		tb.remover(id);
	}
}
