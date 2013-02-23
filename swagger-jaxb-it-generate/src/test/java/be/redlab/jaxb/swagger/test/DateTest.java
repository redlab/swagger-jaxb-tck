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
package be.redlab.jaxb.swagger.test;

import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.api.model.Root;
import com.wordnik.swagger.annotations.ApiProperty;

/**
 * XML date mapped to Java XMLGregorianCalendar mapped to Swagger date
 *
 * @author redlab
 *
 */
public class DateTest {

	private Method method;
	private ApiProperty apiProperty;

	@Before
	public void setup() throws NoSuchMethodException, SecurityException {
		method = Root.class.getMethod("getDatetimeElement");
		apiProperty = method.getAnnotation(ApiProperty.class);
	}

	@Test
	public void annotationNotNull() {
		failIfNoAnnotation();
	}

	@Test
	public void typeIsCorrect() {
		failIfNoAnnotation();
		Assert.assertEquals("date", apiProperty.dataType());
	}

	@Test
	public void nameIsCorrect() {
		failIfNoAnnotation();
		Assert.assertEquals("datetimeElement", apiProperty.value());
	}

	@Test
	public void required() {
		failIfNoAnnotation();
		Assert.assertEquals(true, apiProperty.required());
	}

	protected void failIfNoAnnotation() {
		Assert.assertNotNull("ApiProperty not found on method", apiProperty);
	}
}