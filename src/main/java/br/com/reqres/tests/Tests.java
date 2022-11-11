package br.com.reqres.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import br.com.reqres.core.BaseTest;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;

/*
 *Indentei o codigo em linhas diferentes para melhor visualização e quando houver erro, identificar facilmente a linha com o mesmo. 
 */
public class Tests extends BaseTest {
	
	@Test
	public void mustValidateUsersContract() {
		given()
		.when()
			.request(Method.GET, "/api/users/")
		.then()
			.statusCode(200) //Certifica de que o status code retornado seja o 200.
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("list_users.json")) //Aqui esta sendo feita uma validacao de contrato.
		;
	}

}
