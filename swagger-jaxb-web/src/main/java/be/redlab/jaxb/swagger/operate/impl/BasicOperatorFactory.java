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

import be.redlab.jaxb.swagger.generated.model.OperationType;
import be.redlab.jaxb.swagger.operate.Operator;
import be.redlab.jaxb.swagger.operate.OperatorFactory;

/**
 * @author redlab
 *
 */
public class BasicOperatorFactory implements OperatorFactory {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * be.redlab.jaxb.swagger.operate.OperatorFactory#getOperator(be.redlab.jaxb.swagger.generated.model.OperationType)
	 */
	@Override
	public Operator getOperator(final OperationType operation) {
		switch (operation) {
		case ADD:
			return new Operator() {

				@Override
				public Double operate(final Double x1, final Double x2) {
					return x1 + x2;
				}

			};
		case DIVIDE:
			return new Operator() {

				@Override
				public Double operate(final Double x1, final Double x2) {
					return x1 / x2;
				}

			};
		case MOD:
			return new Operator() {

				@Override
				public Double operate(final Double x1, final Double x2) {
					return x1 % x2;
				}

			};
		case MULTIPLY:
			return new Operator() {

				@Override
				public Double operate(final Double x1, final Double x2) {
					return x1 * x2;
				}

			};
		case SUBSTRACT:
			return new Operator() {

				@Override
				public Double operate(final Double x1, final Double x2) {
					return x1 - x2;
				}

			};
		default:
			throw new UnsupportedOperationException();
		}

	}

}
