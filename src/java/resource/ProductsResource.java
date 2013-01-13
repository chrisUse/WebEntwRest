/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author christianlinde
 */
@Path("/product")
public class ProductsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductsResource
     */
    public ProductsResource() {
    }

    /**
     * Retrieves representation of an instance of resource.ProductsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        String allProducts = "<html><body><table>";
        
        for ( data.Product p : data.Storage.getInstance().getAllProducts() ) {
            allProducts += "<tr><td> "+ p.getName() +" </td></tr>";
        }
        
        allProducts += "</table></body></html>";
        return allProducts;
    }

    /**
     * POST method for creating an instance of ProductResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes("text/html")
    @Produces("text/html")
    public Response postHtml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public ProductResource getProductResource(@PathParam("id") String id) {
        return ProductResource.getInstance(id);
    }
}
