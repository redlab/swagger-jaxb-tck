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

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import be.redlab.jaxb.swagger.generated.model.CalculationResponseType;
import be.redlab.jaxb.swagger.generated.model.OperationType;
import be.redlab.jaxb.swagger.operate.OperatorFactory;
import be.redlab.jaxb.swagger.operate.impl.BasicOperatorFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * @author redlab
 *
 */
@Path("/simple")
@Api(value = "/simple", description = "A simple resource, no request payloads.")
public class DemoResource {

	private final OperatorFactory operatorFactory = new BasicOperatorFactory();

	@GET
	@Path("/calculate")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "GET", responseClass = "be.redlab.jaxb.swagger.generated.model.CalculationResponseType",
			value = "calculate something with two double values")
	public Response calculate(
			@ApiParam(name = "x1", required = true) @QueryParam("x1") final Double x1,
			@ApiParam(name = "x2", required = true) @QueryParam("x2") final Double x2,
			@ApiParam(required = true, allowableValues = "ADD,SUBSTRACT,MULTIPLY,DIVIDE,MOD", name = "operation") @QueryParam("operation") final OperationType operation) {
		CalculationResponseType r = new CalculationResponseType().withOperation(operation).withX1(x1).withX2(x2)
				.withResult(operatorFactory.getOperator(operation).operate(x1, x2));
		return Response.ok(r).build();
	}

	@POST
	@Path("/try")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "POST", responseClass = "be.redlab.jaxb.swagger.generated.model.CalculationResponseType",
			value = "multiply two double values")
	public Response tryPost(@ApiParam(name = "object", required = true) final CalculationResponseType object) {
		CalculationResponseType r = new CalculationResponseType().withOperation(OperationType.MULTIPLY).withX1(object.getX1())
				.withX2(object.getX2())
				.withResult(object.getResult());
		return Response.ok(r).build();
	}
}
