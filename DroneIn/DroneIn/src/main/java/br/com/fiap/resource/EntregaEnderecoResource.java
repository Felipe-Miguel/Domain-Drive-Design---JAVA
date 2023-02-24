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

import br.com.fiap.bo.EntregaEnderecoBO;
import br.com.fiap.to.EntregaEnderecoTO;

@Path("/entregaendereco")
public class EntregaEnderecoResource {

	EntregaEnderecoBO eb = new EntregaEnderecoBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntregaEnderecoTO> buscar() {
		return eb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EntregaEnderecoTO buscar(@PathParam("id") int id) {
		return eb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EntregaEnderecoTO entend, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		eb.cadastrar(entend);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(entend.getIdEntregaEnd()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(EntregaEnderecoTO entend, @PathParam("id") int id) {
		entend.setIdEntregaEnd(id);
		eb.atualiza(entend);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		eb.remover(id);
	}
}
