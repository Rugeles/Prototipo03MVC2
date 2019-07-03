public class Pais {
    private Circunscripcion[] arreglo;
    private int siguiente;
    
    public Pais(int pCapacidad){
    	if (pCapacidad>0){
            arreglo=new Circunscripcion[Math.max(pCapacidad, 1)];
        }
    	if (pCapacidad==0) {
    		arreglo[0]=new Circunscripcion();
    	}
        siguiente=0;
    }
    
    public int getCapacidad(){
        int rCapacidad;
        rCapacidad=this.arreglo.length;
        return rCapacidad;
    }
    
    public void incluir(Circunscripcion pCircunscripcion){
        int i;
        if (pCircunscripcion.getValidez()){
            i=0;
            while ((i<this.arreglo.length) && (this.arreglo[i]!=null)){
                i=i+1;
            }
            if (i<this.arreglo.length){
                arreglo[i]=pCircunscripcion;
            }
        }
    }
    
    public Circunscripcion getCircunscripcion(int pIndice){
        Circunscripcion rCircunscripcion;
        if ((pIndice>=0) && (pIndice<=this.arreglo.length) && (this.arreglo[pIndice]!=null)){
            rCircunscripcion=this.arreglo[pIndice];
        }
        else{
            rCircunscripcion=new Circunscripcion();
        }
        return rCircunscripcion;
    }
    
    public long getPotencialSufragantes(){
        long rPotencialSufragantes;
        int i;
        rPotencialSufragantes=0;
        for (i=0;i<this.getCapacidad();i++){
            rPotencialSufragantes=rPotencialSufragantes+this.getCircunscripcion(i).getPotencialSufragantes();
        }
        return rPotencialSufragantes;
    }

    public long getTotalSufragantes(){
        long rTotalSufragantes;
        int i;
        rTotalSufragantes=0;
        for (i=0;i<this.getCapacidad();i++){
            rTotalSufragantes=rTotalSufragantes+this.getCircunscripcion(i).getTotalSufragantes();
        }
        return rTotalSufragantes;
    }

    public double getParticipacion(){
        double rParticipacion;
        rParticipacion=((double)this.getTotalSufragantes()/this.getPotencialSufragantes())*100;
        return rParticipacion;
    }
    
    public String getIndiceInicio() {
    	siguiente=0;
    	return "";
    }
    
    public Circunscripcion getSiguiente() {
    	Circunscripcion rCircunscripcion;
    	rCircunscripcion= this.getCircunscripcion(siguiente);
    	return rCircunscripcion;
    }
    
    public String getIndiceSiguiente() {
    	siguiente=siguiente+1;
    	return "";
    }
    
}
