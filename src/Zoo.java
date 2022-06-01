import java.util.Scanner;

public class Zoo{
    public static void main(String[] args) {
        int num,i,p,a,pos;
        String nombreA,op;
        boolean f=true,f2;

        datosAnimal datos = new datosAnimal();

        Animal [] animalArray = new Animal [4]; //array de objetos
        animalArray[0] = new Coyote();
        animalArray[1] = new Leon();
        animalArray[2] = new Caballo();
        animalArray[3] = new Venado();


        for(i=0;i<4;i++){//inicializar
            animalArray[i].inicializarAtributos();
        }

        Scanner sc= new Scanner(System.in);

        do{
            //menu
            System.out.print("""

                    ----------------------------------
                    Elige una opcion para administrar el zoologico:
                    1.Mostrar animales en el zoologico
                    2.Agregar un animal
                    3.Eliminar un animal
                    4.Atender un animal
                    5.Salir

                    Ingresa numero:\s""");
            num = sc.nextInt();

            switch (num) {
                case 1 -> {
                    f2 = true;
                    do {
                        System.out.print("\nDe que tipo de animal deseas ver la lista.");
                        num = datos.tipo();//Lista de tipos de animales
                        p = animalArray[num].getPosicion();//Obtine la posicion del ultimo animal en la lista
                        if (p == 0) System.out.print("\nNo hay animal de ese tipo registrado\n");
                        else {
                            nombreA = datos.nomTipo(num);//Obtiene la cadena de tipo de animal
                            System.out.print("\n\n--" + nombreA + "--\n");
                            for (i = 0; i < p; i++) {//Lista de animales con nombre y edad
                                pos = i + 1;
                                System.out.println("" + pos + ". " + animalArray[num].getNombre(i) + " | " + animalArray[num].getEdad(i) + " a\u00f1os");
                            }
                        }

                        System.out.print("\nDesea ver otro tipo de animal(S/N):");
                        Scanner scan = new Scanner(System.in);
                        op = scan.nextLine();
                        if (op.equals("n") || op.equals("N")) f2 = false;
                    } while (f2);
                }
                case 2 -> {
                    f2 = true;
                    do {//case para agregar animales
                        System.out.print("\nDe que tipo de animal deseas agregar.");
                        num = datos.tipo();//saca la lista de tipos de animales
                        p = animalArray[num].getPosicion();//obtine la posicion del ultimo animaa en la lista
                        animalArray[num].setNombre(datos.nombre(), p);//agrega el nombre del animal
                        animalArray[num].setEdad(datos.edad(), p);//agrega la edad del animal
                        animalArray[num].cambiarPosicion(true);//aumenta la ultima posicion

                        System.out.print("\nDesea agregar otro animal(S/N):");
                        Scanner scan = new Scanner(System.in);//no funciona el scan si no lo coloco aqui
                        op = scan.nextLine();
                        if (op.equals("n") || op.equals("N")) f2 = false;
                    } while (f2);
                }
                case 3 -> {
                    f2 = true;
                    do {//case para eliminar un animal
                        System.out.print("\nDe que tipo de animal desea eliminar.");
                        num = datos.tipo();//saca la lista de tipos de animales
                        p = animalArray[num].getPosicion();//obtine la posicion del ultimo animal en la lista
                        if (p == 0) System.out.print("\nNo se encuentrar animales registrados\n");
                        else {
                            nombreA = datos.nomTipo(num);//obtiene el String de tipo de animal
                            System.out.print("\n\n--" + nombreA + "--\n");
                            for (i = 0; i < p; i++) {//saca la lista de los animales, con nombre y edad
                                pos = i + 1;
                                System.out.println("" + pos + ". " + animalArray[num].getNombre(i) + " | " + animalArray[num].getEdad(i) + " a\u00f1os");
                            }

                            System.out.print("\nCual desea eliminar,ingrese el numero de la posicion:");
                            a = sc.nextInt() - 1;
                            if (a < 0 || a > p + 1) System.out.println("\nPosicion no existente");
                            else {
                                animalArray[num].setNombre("", a);//borra los datos de la posicion ingresada
                                animalArray[num].setEdad(0, a);
                                for (i = a; i < p; i++) {
                                    animalArray[num].setNombre(animalArray[num].getNombre(i + 1), i);//mueve los datos del animal de la posicion siguiente, a la anterior
                                    animalArray[num].setEdad(animalArray[num].getEdad(i + 1), i);
                                    animalArray[num].setVacuna(animalArray[num].getVacunado(i + 1), i);
                                    animalArray[num].setComer(animalArray[num].getComer(i + 1), i);
                                    animalArray[num].setBanar(animalArray[num].getBanar(i + 1), i);
                                }
                                animalArray[num].setNombre("", p);//borra lo datos de ultimo animal
                                animalArray[num].setEdad(0, p);
                                animalArray[num].setVacuna(false, p);
                                animalArray[num].setComer(false, p);
                                animalArray[num].setBanar(false, p);
                                animalArray[num].cambiarPosicion(false);
                            }
                        }
                        System.out.print("\nDesea eliminar otro de animal(S/N):");
                        Scanner scan = new Scanner(System.in);//no funciona el scan si no lo coloco aqui
                        op = scan.nextLine();
                        if (op.equals("n") || op.equals("N")) f2 = false;
                    } while (f2);
                }
                case 4 -> {
                    f2 = true;
                    do {//case para atender animall
                        System.out.print("\nDe que tipo de animal desea atender.");
                        num = datos.tipo();//saca la lista de tipos de animales
                        p = animalArray[num].getPosicion();//obtine la posicion del ultimo animaa en la lista
                        if (p == 0) System.out.print("\nNo se encuentrar animales registrados\n");
                        else {
                            nombreA = datos.nomTipo(num);//obtiene el String de tipo de animal
                            System.out.print("\n\n--" + nombreA + "--\n");
                            for (i = 0; i < p; i++) {//saca la lista de los animales, con nombre y edad
                                pos = i + 1;
                                System.out.println("" + pos + ". " + animalArray[num].getNombre(i) + " | " + animalArray[num].getEdad(i) + " a\u00f1os");
                            }

                            System.out.print("\nCual desea atender,ingrese el numero de la posicion:");
                            a = sc.nextInt() - 1;
                            if (a < 0 || a > p + 1) System.out.println("\nPosicion no existente");
                            else {
                                System.out.print("""

                                        Que desea hacer
                                        1.Dar alimento
                                        2.Asear
                                        3.Vacunar

                                        Ingresa numero:\s""");
                                i = sc.nextInt();

                                switch (i) {
                                    case 1 -> animalArray[num].comer(a); //metodos para mostrar la accion de atender
                                    case 2 -> animalArray[num].banar(a);
                                    case 3 -> animalArray[num].vacunar(a);
                                    default -> System.out.println("\n--Ingresa una de las opciones--\n");
                                }
                            }
                        }
                        System.out.print("\nDesea realizar otra accion(S/N):");
                        Scanner scan = new Scanner(System.in);//no funciona el scan si no lo coloco aqui
                        op = scan.nextLine();
                        if (op.equals("n") || op.equals("N")) f2 = false;

                    } while (f2);
                }
                case 5 -> f = false;//convierte la bandera de salida a falsa
                default -> System.out.println("\n--Ingresa una de las opciones--\n");
            }
        }while(f); //bandera de salida



    }
}

class datosAnimal{// Obtener los datos de animales
    int num;
    String nom;

    Scanner sc= new Scanner(System.in);

    public int tipo(){
        int num;
        boolean f=true;

        do{
            System.out.print("""

                    Ingrese la opcion del animal deseado:
                    1.Coyote
                    2.Leon
                    3.Caballo
                    4.Venado

                    Ingresa numero:\s""");
            num = sc.nextInt();
            if(num<0 || num>4) System.out.print("--Ingresa una de las opciones--\n");
            else f=false;
        }while(f);

        return(num-1);
    }

    public String nomTipo(int num){
        String nombre = switch (num) {
            case 0 -> "Coyote";
            case 1 -> "Leon";
            case 2 -> "Caballo";
            case 3 -> "Venado";
            default -> "Animal no existente";
        };
        return(nombre);
    }
    public String nombre(){
        System.out.print("\nIngrese el nombre del animal: ");
        Scanner scan= new Scanner(System.in);
        return(scan.nextLine());
    }

    public int edad(){
        System.out.print("\nIngrese la edad del animal-en a\u00f1os: ");
        Scanner scan= new Scanner(System.in);
        return(scan.nextInt());
    }
}

class Coyote extends Animal{

    public void comer(int i){
        if(comer[i]==false){
            System.out.println("\n"+nombre[i] +" se esta alimentando");
            comer[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya se alimento");

    }
}

class Leon extends Animal{

    public void comer(int i){
        if(comer[i]==false){
            System.out.println("\n"+nombre[i] +" se esta alimentando");
            comer[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya se alimento");

    }
}

class Caballo extends Animal{

    public void comer(int i){
        if(comer[i]==false){
            System.out.println("\n"+nombre[i] +" se esta alimentando");
            comer[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya se alimento");

    }
}

class Venado extends Animal{

    public void comer(int i){
        if(comer[i]==false){
            System.out.println("\n"+nombre[i] +" se esta alimentando");
            comer[i]=true;
        }
        else System.out.println("\n"+nombre[i] +" ya se alimento");

    }
}



