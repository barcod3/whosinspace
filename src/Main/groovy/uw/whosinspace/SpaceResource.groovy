package uw.whosinspace

import groovy.json.JsonSlurper
import jodd.http.HttpRequest
import jodd.http.HttpResponse

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/whosinspace")
@Produces(MediaType.APPLICATION_JSON)
class SpaceResource {

    @GET
    public def whosInSpace()
    {
        def slurper = new JsonSlurper()
        HttpRequest httpRequest = HttpRequest.get('http://api.open-notify.org/astros.json')
        HttpResponse response = httpRequest.send()
        def people = slurper.parseText(response.body())
        httpRequest = HttpRequest.get('http://api.open-notify.org/iss-now.json')
        response = httpRequest.send()
        def position = slurper.parseText(response.body())
        String mapurl = "https://maps.google.com/maps?q=${position.iss_position.latitude},${position.iss_position.longitude}&hl=es;z=14&amp;&output=embed&z=2"
        [roster:people, position:position, mapurl:mapurl]

    }

}
