import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Datos {
	public Datos() {
		
	}
	
	public void grabarCircunscripcion(Circunscripcion pCircunscripcion) {
		if (pCircunscripcion.getValidez()) {
			UserService userService;
			User user;
			DatastoreService datastore;
			Entity entity;
			userService=UserServiceFactory.getUserService();
			user=userService.getCurrentUser();
			datastore=DatastoreServiceFactory.getDatastoreService();
			entity=new Entity("Circunscripcion");
			entity.setProperty("nombre", pCircunscripcion.getNombre());
			entity.setProperty("potencialSufragantes", pCircunscripcion.getPotencialSufragantes());
			entity.setProperty("totalSufragantes", pCircunscripcion.getTotalSufragantes());
			datastore.put(entity);
		}
	}
	
	public Circunscripcion recuperarCircunscripcion(String pNombreBusqueda) {
		DatastoreService datastore;
		Query query;
		PreparedQuery preparedQuery;
		Circunscripcion rCircunscripcion;
		rCircunscripcion=new Circunscripcion();
		query=new Query("Circunscripcion");
		query.setFilter(
			new Query.FilterPredicate(
				"nombre",Query.FilterOperator.EQUAL,pNombreBusqueda));
		datastore=DatastoreServiceFactory.getDatastoreService();
		preparedQuery=datastore.prepare(query);
		if (preparedQuery.countEntities(FetchOptions.Builder.withLimit(1))>0) {
			for (Entity entity : preparedQuery.asIterable()) {
				rCircunscripcion.setNombre((String) entity.getProperty("nombre"));
				rCircunscripcion.setPotencialSufragantes((long)entity.getProperty("potencialSufragantes"));
				rCircunscripcion.setTotalSufragantes((long)entity.getProperty("totalSufragantes"));
			}
		}
		return rCircunscripcion;
	}
	
	public Pais recuperarPais() {
		DatastoreService datastore;
		Query query;
		PreparedQuery preparedQuery;
		Pais rPais;
		Circunscripcion tCircunscripcion;
		query=new Query("Circunscripcion");
		datastore=DatastoreServiceFactory.getDatastoreService();
		preparedQuery=datastore.prepare(query);
		rPais=new Pais(preparedQuery.countEntities(FetchOptions.Builder.withLimit(100)));
		if (preparedQuery.countEntities(FetchOptions.Builder.withLimit(100))>0) {
			for (Entity entity : preparedQuery.asIterable()) {
				tCircunscripcion=new Circunscripcion();
				tCircunscripcion.setNombre((String) entity.getProperty("nombre"));
				tCircunscripcion.setPotencialSufragantes((long)entity.getProperty("potencialSufragantes"));
				tCircunscripcion.setTotalSufragantes((long)entity.getProperty("totalSufragantes"));
				rPais.incluir(tCircunscripcion);
			}
		}
		return rPais;
	}
	
}
