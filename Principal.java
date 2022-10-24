import java.util.Scanner;

public class Principal {
    static Scanner sc = new Scanner(System.in);
    public static Vehiculo[] vehiculos = new Vehiculo[10];
    public static int tamano = 10;
    public static int posAnadir = 0;
    public static int posAnadirSens = 0;
    public static Sensor[] sensores = new Sensor[8];
    //public static Sensor[] sensores = {new Sensor("temperatura", 6),new Sensor("temperatura", 4),new Sensor("temperatura", 2),new Sensor("temperatura", 1)};
    public static int tamanosens = 8;

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static String toStringVehiculos() {
        String texto = "";
        for (int i = 0; i < Principal.tamano; i++) {
            texto += Principal.vehiculos[i].toString();
        }
        return texto;
    }

    public static void mostrarMenu() {
        int input;
        do {
            showMenu();
            input = sc.nextInt();

            switch (input) {
                case 1:

                    if (posAnadir < 10) {
                        System.out.println("Ingrese modelo: ");
                        int mo = sc.nextInt();
                        System.out.println("Ingrese marca: ");
                        String ma = sc.next();
                        System.out.println("Ingrese valor: ");
                        Double va = sc.nextDouble();
                        System.out.println("Ingrese color: ");
                        String co = sc.next();
                        vehiculos[posAnadir] = new Vehiculo(mo, ma, va, co);
                    } else {
                        System.out.println("Error base de datos llena");
                    }
                    break;

                case 2:
                    for (int i = 0; i < posAnadir; i++) {
                        Vehiculo x = vehiculos[i];
                        System.out.println("Vehiculo: " + i);
                        System.out.println(x.toString());
                    }
                    break;
                case 3:
                    System.out.println("Vehiculos: " + (posAnadir));
                    break;
                case 4:
                    for (int i = 0; i < posAnadir; i++) {
                        Vehiculo x = vehiculos[i];
                        if ((x.getColor()).compareToIgnoreCase("verde") == 0) {
                            System.out.println(x.toString());
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < posAnadir; i++) {
                        Vehiculo x = vehiculos[i];
                        if (x.getModelo() >= 2000 || x.getModelo() <= 2021) {
                            System.out.println(x.toString());
                        }
                    }
                    break;
                case 6:
                    if (Sensor.cantidadSensores() < 8) {
                        System.out.println("Ingrese tipo: ");
                        String pa = sc.next();
                        System.out.println("Ingrese valor: ");
                        Double ma = sc.nextDouble();
                        sensores[posAnadirSens] = new Sensor(pa, ma);
                    } else {
                        System.out.println("Error base de datos llena");
                    }
                    break;
                case 7:
                    for (int i = 0; i < posAnadirSens; i++) {
                        Sensor x = sensores[i];
                        System.out.println("Sensor: " + i);
                        System.out.println(x.toString());
                    }
                    break;
                case 8:
                    System.out.print("Sensores: ");
                    System.out.println(Sensor.cantidadSensores());
                    break;
                case 9:
                    for (int i = 0; i < posAnadirSens; i++) {
                        Sensor x = sensores[i];
                        if ((x.getTipo()).compareToIgnoreCase("temperatura") == 0) {
                            System.out.println(x.toString());
                        }
                    }
                    break;
                case 666:
                    Sensor[] ordenados = ordenarSensores(sensores);
                    int countTemp = 1;
                    for (int i = 0; i < posAnadirSens; i++) {
                        Sensor x = ordenados[i];
                        if ((x.getTipo()).compareToIgnoreCase("temperatura") == 0) {
                        //Sensor x = ordenados[i];
                        System.out.println("Sensor: " + countTemp);
                        countTemp += 1;
                        System.out.println(x.toString());}
                    }
                    break;
                default:
                    break;
            }
        } while (input != 0);
        System.exit(1);
    }

    public static Sensor[] ordenarSensores(Sensor[] s) {
        Sensor[] newSensArr = new Sensor[posAnadirSens];
        int addNewArr = 0;
        for (int i = 0; i < posAnadirSens; i++) {
                //if (isTemp(i) == true) {
                    newSensArr[i] = sensores[i];
                    //System.out.println("addNewArr: " + addNewArr);
                    //addNewArr += 1;
               // }
            }
            
            do {
            
            for (int i = 0; i < posAnadirSens - 1; i++) {
                Sensor x = newSensArr[i];
                Sensor y = newSensArr[i + 1];
                /*System.out.println("Position: " + i);
                System.out.println("SensArrLength: " + newSensArr.length);
                System.out.println("Valor y: " + x.getValor());*/
                if ((x.getValor() > y.getValor())) {
                    newSensArr[i] = y;
                    newSensArr[i + 1] = x;
                }
            }
        } while (checkOrden(newSensArr) == false);
        return newSensArr;
    }

    public static boolean checkOrden(Sensor[] s) {
        boolean r = true;
        for (int i = 0; i < s.length - 1; i++) {
            Sensor x = s[i];
            Sensor y = s[i + 1];
            if (x.getValor() > y.getValor()) {
                r = false;
                return r;
            }
        }
        return r;
    }

    public static int numTemp() {
        int r = 0;
        for (int i = 0; i < posAnadirSens - 1; i++) {
            Sensor x = sensores[i];
            if ((x.getTipo()).compareToIgnoreCase("temperatura") == 0) {
                r += 1;
            }
        }
        return r;
    }

    public static boolean isTemp(int i) {
        boolean r = false;
        Sensor x = sensores[i];
        if (x.getTipo().compareToIgnoreCase("Temperatura") == 0) {
            r = true;
        }

        return r;
    }

    public static void showMenu(){
        System.out.println("Seleccione una opcion");
        System.out.println("0: Salir");
        System.out.println("1: Agregar Vehiculo");
        System.out.println("2: Mostrar Vehiculos");
        System.out.println("3: Mostrar numero de vehiculos");
        System.out.println("4: Mostrar vehiculos verdes");
        System.out.println("5: Mostrar vehiculos de modelos entre 2000 y 2021");
        System.out.println("6: Agregar sensor");
        System.out.println("7: Mostrar sensores");
        System.out.println("8: Mostrar numero de sensores");
        System.out.println("9: Mostrar sensores de temperatura");
        System.out.println("666: Mostrar sensores de temperatura ordenados por valor");
    }
}