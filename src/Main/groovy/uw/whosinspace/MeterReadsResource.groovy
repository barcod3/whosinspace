package uw.whosinspace
import groovy.json.JsonSlurper
import jodd.http.HttpRequest
import jodd.http.HttpResponse

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType


@Path("/reads")
@Produces(MediaType.APPLICATION_JSON)
class ReadsResource {
    @GET
    public def getReads(@QueryParam('custaccountno') String custAccountNo){
        HttpRequest httpRequest = HttpRequest.get("http://it-webappint/billapi/2.0/gas/xgGCustAccountNo/$custAccountNo/gusedom/xcguddateinv")
        HttpResponse response = httpRequest.send()
        response.body()
    }

}
