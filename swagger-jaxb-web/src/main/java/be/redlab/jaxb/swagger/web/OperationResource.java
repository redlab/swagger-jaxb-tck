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

import be.redlab.jaxb.swagger.generated.model.CalculationResponseType;
import be.redlab.jaxb.swagger.generated.model.OperationType;
import be.redlab.jaxb.swagger.operate.OperatorFactory;
import be.redlab.jaxb.swagger.operate.impl.BasicOperatorFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author redlab
 *
 */
@Path("/simple")
@Api(value = "A simple resource, no request payloads.")
public class OperationResource {

	private final OperatorFactory operatorFactory = new BasicOperatorFactory();

	@GET
	@Path("/calculate")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "GET", response = be.redlab.jaxb.swagger.generated.model.CalculationResponseType.class,
			value = "calculate something with two double values")
	public Response calculate(
			@ApiParam(name = "x1", required = true) @QueryParam("x1") final Double x1,
			@ApiParam(name = "x2", required = true) @QueryParam("x2") final Double x2,
			@ApiParam(required = true, allowableValues = "ADD,SUBSTRACT,MULTIPLY,DIVIDE,MOD", name = "operation") @QueryParam("operation") final OperationType operation) {
		CalculationResponseType r = new CalculationResponseType();
		r.setOperation(operation);
		r.setX1(x1);
		r.setX2(x2);
		r.setResult(operatorFactory.getOperator(operation).operate(x1, x2));
		return Response.ok(r).build();
	}

	@POST
	@Path("/try")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "POST",  response = be.redlab.jaxb.swagger.generated.model.CalculationResponseType.class,
			value = "multiply two double values")
	public Response tryPost(@ApiParam(name = "object", required = true) final CalculationResponseType object) {
		CalculationResponseType r = new CalculationResponseType();
		r.setOperation(object.getOperation());
		r.setX1(object.getX1());
		r.setX2(object.getX2());
		r.setResult(operatorFactory.getOperator(object.getOperation()).operate(object.getX1(), object.getX2()));
		return Response.ok(r).build();
	}
}
