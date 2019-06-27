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
import io.swagger.annotations.ApiModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author redlab
 *
 */
public class ClassAnnotationsTest {

	private ApiModel apiClass;

	@Before
	public void getAnnotation() {
		apiClass = Root.class.getAnnotation(ApiModel.class);
	}

	@Test
	public void annotationsAvailable() {
		failOnNullAnnotation();
	}

	@Test
	@Ignore("should give Root, but currently gives root; known issue")
	public void annotationNameOfModel() {
		failOnNullAnnotation();
		Assert.assertEquals("Root", apiClass.value());

	}

	@Test
	public void annotationDescription() {
		failOnNullAnnotation();
		Assert.assertEquals("The Root", apiClass.description());

	}


	protected void failOnNullAnnotation() {
		Assert.assertNotNull("ApiClass not found on method", apiClass);
	}
}
