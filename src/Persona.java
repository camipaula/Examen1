public class Persona implements Comparable<Persona>{
    int id;
    String nombreCompleto;
    int edad;
    int prioridad;
    int amigos;

    public Persona(int id, String nombreCompleto, int edad,int prioridad,int amigos){
        this.id=id;
        this.nombreCompleto=nombreCompleto;
        this.edad=edad;
        this.prioridad=prioridad;
        this.amigos=amigos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
    }
    @Override
    public java.lang.String toString() {
        return "id: "+id+"nombre:" +nombreCompleto+"edad: "+edad;
    }

    @Override
    public int compareTo (Persona p){
        if(this.prioridad<getPrioridad()){
            return -1;
        }else if (this.prioridad>getPrioridad()){
            return 1;
        }else {
            return 0;
        }
    }



}
