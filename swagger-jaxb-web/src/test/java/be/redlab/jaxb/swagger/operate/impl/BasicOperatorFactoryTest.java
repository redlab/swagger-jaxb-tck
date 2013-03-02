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
package be.redlab.jaxb.swagger.operate.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.redlab.jaxb.swagger.generated.model.OperationType;

/**
 * @author redlab
 *
 */
public class BasicOperatorFactoryTest {

	private BasicOperatorFactory factory;

	@Before
	public void setup() {
		factory = new BasicOperatorFactory();
	}

	@Test
	public void getAddOperator() {
		Assert.assertNotNull(factory.getOperator(OperationType.ADD));
	}

	@Test
	public void getDivideOperator() {
		Assert.assertNotNull(factory.getOperator(OperationType.DIVIDE));
	}

	@Test
	public void getModOperator() {
		Assert.assertNotNull(factory.getOperator(OperationType.MOD));
	}

	@Test
	public void getMultiplyOperator() {
		Assert.assertNotNull(factory.getOperator(OperationType.MULTIPLY));
	}

	@Test
	public void getSubstractOperator() {
		Assert.assertNotNull(factory.getOperator(OperationType.SUBSTRACT));
	}

}
