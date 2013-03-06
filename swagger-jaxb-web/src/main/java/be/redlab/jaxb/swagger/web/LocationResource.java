/*
 * Copyright 2013 Balder Van Camp
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package be.redlab.jaxb.swagger.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.redlab.jaxb.swagger.generated.model.LocationType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * @author redlab
 *
 */
@Path("/location")
@Api(description = "location related calls", value = "/location")
public class LocationResource {


	@GET()
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "GET", responseClass = "be.redlab.jaxb.swagger.generated.model.LocationElement",
			value = "calculate something with two double values")
	public Response getLocation(@QueryParam("t") final LocationType type, @QueryParam("s") final String search) {
		return Response.status(740).header("Warning", "740 - Computer says no").build();
	}
}
