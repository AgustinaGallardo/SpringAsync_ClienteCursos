package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.curso.model.Curso;

import jakarta.annotation.PostConstruct;

@RestController
public class CursosController {
	
	private List<Curso>cursos;
	@PostConstruct
	public void init () {
		cursos=new ArrayList<>();
	cursos.add(new Curso("spring",100,"Mañana"));	
	cursos.add(new Curso("Boot",20,"Tarde"));	
	cursos.add(new Curso("Java",130,"Noche"));	
	cursos.add(new Curso("Java EE",160,"Mañana"));	
	cursos.add(new Curso("spring",100,"Mañana"));	
	
	}
	
	@GetMapping(value = "cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos(){
		return cursos;
	}
		
	@GetMapping(value = "curso",produces=MediaType.APPLICATION_XML_VALUE)
	public Curso getCruso() {
		return new Curso("java",100,"Mañana");
	}
	
	
	//APPLICATION_XML_VALUE= para tranformar en XML
	//APPLICATION_JSON_VALUE= para transformar en JSON
	//produces=MediaType.APPLICATION_XML_VALUE = que produce un resultado de tipo XML o JSON
	
	@GetMapping(value = "cursos/{name}",produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> buscarCursos(@PathVariable("name") String nombre){
		List<Curso> aux=new ArrayList<>();
		for(Curso c:cursos) {
			if(c.getNombre().contains(nombre)){
				aux.add(c);
			}
		}
			return aux;
		}
	
	//@PathVariable("name") =El parametro lo mapeamos con el parametro de la URL 
	@DeleteMapping(value="curso/{name}")
	public void eliminarCurso(@PathVariable("name") String nombre) {
		cursos.removeIf(c->c.getNombre().equals(nombre));
	}
	
	
	//consume= MediaType.APPLICATION_JSON_VALUE= que tipo de contenido llegara en en el cuerpo
	@PostMapping(value="curso",consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
		public List<Curso> altaCurso(@RequestBody Curso curso){
         cursos.add(curso);
	     return cursos;
	}


@PutMapping(value="curso",consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public List<Curso> actualizaCurso(@RequestBody Curso curso){
 for(int i=0;i<cursos.size();i++) {
	 if(cursos.get(i).getNombre().equals(curso.getNombre())) {
		 cursos.set(i,curso);
	 }
 }
 return cursos;
}

}


