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

package be.redlab.jaxb.swagger.test;

import com.example.api.model.Root;
import io.swagger.annotations.ApiModelProperty;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * XSD type long mapped to Swagger long
 *
 * @author redlab
 *
 */
public class LongTest {

	private Method method;
	private ApiModelProperty apiProperty;

	@Before
	public void setup() throws NoSuchMethodException, SecurityException {
		method = Root.class.getMethod("getLongElement");
		apiProperty = method.getAnnotation(ApiModelProperty.class);
	}

	@Test
	public void annotationNotNull() {
		failIfNoAnnotation();
	}

	@Test
	public void typeIsCorrect() {
		failIfNoAnnotation();
		Assert.assertEquals("long", apiProperty.dataType());
	}

	@Test
	public void nameIsCorrect() {
		failIfNoAnnotation();
		Assert.assertEquals("longElement", apiProperty.value());
	}

	@Test
	public void required() {
		failIfNoAnnotation();
		Assert.assertEquals(true, apiProperty.required());
	}

	protected void failIfNoAnnotation() {
		Assert.assertNotNull("ApiModelProperty not found on method", apiProperty);
	}
}
