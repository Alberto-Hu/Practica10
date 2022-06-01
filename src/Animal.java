import java.util.Scanner;

public class Animal{
    int[] edad = new int[20];
    int i,c=0;
    String[] nombre = new String[20];
    boolean[] vacunado = new boolean[20],comer = new boolean[20],banar = new boolean[20];

    public void inicializarAtributos(){
        for(i=0;i<20;i++){
            vacunado[i]=false;
            comer[i]=false;
            banar[i]=false;
            edad[i]=0;
            nombre[i]="";
        }
    }

    public void setEdad(int edad,int i)
    {
        this.edad[i] = edad;
    }

    public int getEdad(int i){
        return edad[i];
    }

    public void setNombre(String nombre,int i){
        this.nombre[i] = nombre;
    }

    public String getNombre(int i){
        return nombre[i];
    }
    public void setVacuna(boolean vacunado,int i){
        this.vacunado[i] = vacunado;
    }

    public boolean getVacunado(int i){
        return vacunado[i];
    }

    public void setBanar(boolean banar,int i){
        this.banar[i] = banar;
    }

    public boolean getBanar(int i){
        return banar[i];
    }

    public void setComer(boolean comer,int i){
        this.comer[i] = comer;
    }

    public boolean getComer(int i){
        return comer[i];
    }

    public void cambiarPosicion(boolean aumentar){
        if(aumentar) c++;
        else c--;
    }

    public int getPosicion(){
        return(c);
    }
    public void comer(int i){
        if(!comer[i]){
            System.out.println("\n"+nombre[i] +" se esta alimentando");
            comer[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya se alimento");
    }

    public void banar(int i){
        if(!banar[i]){
            System.out.println("\n"+nombre[i] +" ha sido aseado");
            banar[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya fue baniado");
    }

    public void vacunar(int i){
        if(!vacunado[i]){
            System.out.println("\n"+nombre[i] +" se ha vacunado");
            vacunado[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya fue vacunado");
    }
}


