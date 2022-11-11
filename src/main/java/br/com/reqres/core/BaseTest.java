package br.com.reqres.core;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

/*
 * Criei essa classe como base para os testes para facilitar a replica das configuracoes.
 */
public class BaseTest implements Config {
	@BeforeClass
	public static void setup() {
		enableLoggingOfRequestAndResponseIfValidationFails(); //Mostra um log apenas no caso de erro que facilita o desenvolvimento dos testes.
		baseURI = BASE_URL;
		port = PORT;
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(CONTENT_TYPE);
		requestSpecification = reqBuilder.build();
		
		ResponseSpecBuilder respBuilder = new ResponseSpecBuilder();
		respBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		responseSpecification = respBuilder.build();
	}
}
