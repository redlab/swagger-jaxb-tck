/*
 *  Copyright 2017 Balder Van Camp
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package be.redlab.jaxb.swagger.web;

import be.redlab.jaxb.swagger.generated.model.LocationType;
import be.redlab.jersey.status.HttpStatus7xx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * @author redlab
 *
 */
@Path("/location")
@Api("location related calls")
public class LocationResource {


	@GET()
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "GET", response = be.redlab.jaxb.swagger.generated.model.LocationElement.class,
			value = "find a location")
	public Response getLocation(@ApiParam(value = "The type of location") @QueryParam("t") final LocationType type,
			@ApiParam(value = "a string to search for") @QueryParam("s") final String search) {
		return Response.status(HttpStatus7xx.A_KITTEN_DIES).build();
	}
}
