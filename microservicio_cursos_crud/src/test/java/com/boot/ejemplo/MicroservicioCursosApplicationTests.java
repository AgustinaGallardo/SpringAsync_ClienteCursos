package com.boot.ejemplo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
@AutoConfigureMockMvc
@SpringBootTest
//Para generar un ordeon en la ejecucion de metodos de test
@TestMethodOrder(OrderAnnotation.class)
class MicroservicioCursosApplicationTests {

	
	@Autowired
	MockMvc mock;
	@Test
	@Order(0)
	void eliminarCurso() throws Exception {
		mock.perform(delete("/curso/Java EE"));		
	}	
	@Test
	@Order(1)
	void testCursos() throws Exception{
		mock.perform(get("/cursos")).andDo(print());
	}
	@Test
	@Order(2)
	void testAlta() throws Exception{
		mock.perform(post("/curso").
		contentType(MediaType.APPLICATION_JSON).
		content("{\"nombre\":\"Angular 10\",\"duracion\":40,\"horario\":\"Mañana\" }"))
		.andDo(print());
	}
	@Test
	@Order(3)
	void testActualizacion() throws Exception{
		mock.perform(put("/curso").
		contentType(MediaType.APPLICATION_JSON).
		content("{\"nombre\":\"Angular 10\",\"duracion\":80,\"horario\":\"Tarde\" }"))
		.andDo(print());
	}

}
