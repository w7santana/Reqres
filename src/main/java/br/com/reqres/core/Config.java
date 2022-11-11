package br.com.reqres.core;

import io.restassured.http.ContentType;
/*
 * Criei essa interface para deixar as constantes facilitar e centralizar a troca de parametros de configuracoes.
 */
public interface Config {
	String BASE_URL = "https://reqres.in";
	int PORT = 443;
	ContentType CONTENT_TYPE = ContentType.JSON;
	Long MAX_TIMEOUT = 2000L;
	
}
