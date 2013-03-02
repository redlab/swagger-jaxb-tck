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
public class OperationTests {

	private BasicOperatorFactory factory;

	@Before
	public void setup() {
		factory = new BasicOperatorFactory();
	}

	@Test
	public void getAddOperator() {
		Assert.assertEquals(6.5, factory.getOperator(OperationType.ADD).operate(2.5, 4.0), 0);
	}

	@Test
	public void getDivideOperator() {
		Assert.assertEquals(0.025, factory.getOperator(OperationType.DIVIDE).operate(2.5, 100.0), 0);
	}

	@Test
	public void getModOperator() {
		Assert.assertEquals(1, factory.getOperator(OperationType.MOD).operate(8.0, 7.0), 0);
	}

	@Test
	public void getMultiplyOperator() {
		Assert.assertEquals(10, factory.getOperator(OperationType.MULTIPLY).operate(2.5, 4.0), 0);
	}

	@Test
	public void getSubstractOperator() {
		Assert.assertEquals(5.0, factory.getOperator(OperationType.SUBSTRACT).operate(7.33, 2.33), 0);
	}

}
