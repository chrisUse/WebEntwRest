/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import xmlStuff.XMLProduct;

/**
 * REST Web Service
 *
 * @author christianlinde
 */
public class ProductResource {

    private String id;
    private data.Product product;

    /**
     * Creates a new instance of ProductResource
     */
    private ProductResource(String id) {
        this.id = id;
        
        this.product = data.Storage.getInstance().getProductById(Integer.parseInt(id));        
    }

    /**
     * Get instance of the ProductResource
     */
    public static ProductResource getInstance(String id) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of ProductResource class.
        return new ProductResource(id);
    }

    /**
     * Retrieves representation of an instance of resource.ProductResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        XMLProduct xml = new XMLProduct();
        return xml.getProduct();        
        /*
        return "<html><body><h1>Single Product: "+
                this.product.getName()
                +"</h1></body></html>";*/
    }

    /**
     * PUT method for updating or creating an instance of ProductResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }

    /**
     * DELETE method for resource ProductResource
     */
    @DELETE
    public void delete() {
    }
}
