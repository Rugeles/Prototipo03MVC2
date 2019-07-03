public class Circunscripcion {
	private String nombre;
    private long potencialSufragantes;
    private long totalSufragantes;
    
    public Circunscripcion(){
        nombre="";
        potencialSufragantes=0;
        totalSufragantes=0;
    }
    
    public void setNombre(String pNombre) {
    	if (pNombre.length()>0) {
    		nombre=pNombre;
    	}
    }
    
    public void setPotencialSufragantes(long pPotencialSufragantes) {
    	if (pPotencialSufragantes>totalSufragantes) {
    		potencialSufragantes=pPotencialSufragantes;
    	}
    }
    
    public void setTotalSufragantes(long pTotalSufragantes) {
    	if ((pTotalSufragantes>=0) && (pTotalSufragantes<=potencialSufragantes)) {
    		totalSufragantes=pTotalSufragantes;
    	}
    }
    
    public String getNombre() {
    	return nombre;
    }
    
    public long getPotencialSufragantes() {
    	return potencialSufragantes;
    }
    
    public long getTotalSufragantes() {
    	return totalSufragantes;
    }
    
    public double getParticipacion(){
        double rParticipacion;
        rParticipacion=((double)totalSufragantes/potencialSufragantes)*100;
        return rParticipacion;
    }
    
    public boolean getValidez() {
    	boolean rValidez;
    	rValidez=((nombre.length()>0) && 
    			  (potencialSufragantes>=totalSufragantes) &&
    			  (totalSufragantes>0));
    	return rValidez;
    }

}
