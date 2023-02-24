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

import br.com.fiap.bo.EntregaBO;
import br.com.fiap.to.EntregaTO;

@Path("/entrega")
public class EntregaResource {

	EntregaBO pb = new EntregaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EntregaTO> buscar() {
		return pb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EntregaTO buscar(@PathParam("id") int id) {
		return pb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EntregaTO entrega, @Context UriInfo uriInfo) {

		// INSERIR NA BASE
		pb.cadastrar(entrega);

		// CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(entrega.getIdEntrega()));

		// RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(EntregaTO entrega, @PathParam("id") int id) {
		entrega.setIdEntrega(id);
		pb.atualiza(entrega);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		pb.remover(id);
	}
}
