package Service;


import java.util.List;
import java.util.concurrent.CompletableFuture;



import model.Persona;

public interface AccesoService {

	CompletableFuture<List<Persona>> llamadaServicio(Persona persona);

}