
import java.util.Scanner;

public class ServicioBanca {
    
final private static int CUENTAS_EXISTENTES=11;
private static int numCuenta=0;
private static int opcMenu=0;

    public static void main(String[] args) {
        
        
        double deposito=0, retiro=0, balance=0;
        String pin="0000";
                
        Scanner input= new Scanner(System.in);
        //Array de 10 espacios de memoria, el 0 sera default
        CuentaBanco cuenta []= new CuentaBanco[CUENTAS_EXISTENTES];
      
      
      //Asignar objeto de cuenta a sus espacios
      for (int i=1; i<cuenta.length;i++)
      {
          cuenta[i]= new CuentaBanco();
      }
      
        System.out.println("Gracias por utilizar nuestros servicios de banca digital");
        
        
        solicitudNumCuenta(input);
        
        
        System.out.println("Su pin de seguridad actual es predeterminado, favor asigne"
                + " un pin de seguridad de 4-digitos: ");
        
        asignarPin(pin,input,cuenta); //Asignar nuevo pin
        
        System.out.println("Para continuar favor verifique su pin de 4 digitos; ");
        
        verificarPin(pin, input, cuenta); //Verificar pin 

        seleccionMenu(input);//Devolver el valor del menu seleccionado
        
        procesoMenu(retiro, input,cuenta, deposito, pin);
        
        int sel=0;
        do{
            System.out.println("""
                               Presione 1 para una nueva transaccion,
                               o cualquier boton para salir.
                               """);
        sel= input.nextInt();
            if (sel==1){
            seleccionMenu(input);//Devolver el valor del menu seleccionado
        
            procesoMenu(retiro, input,cuenta, deposito, pin);
            }
            else {
                System.out.println("Muchas gracias por su preferencia, que tenga"
                        + "un lindo dia");
                System.exit(0);
            }
        }while(sel==1);
        
        

    }
    /*
        ---------------------  Fin main  ------------------------------
    
    */
    
    public static void solicitudNumCuenta(Scanner input){
        do{ //Solicitando el numero de cuenta del usuario
        System.out.println("Favor introduzca su numero de cuenta: ");
        numCuenta= input.nextInt(); input.nextLine();
        
        if (numCuenta>0 && 10>=numCuenta){
            System.out.println("El numero de cuenta seleccionado es "+numCuenta);
        }
        else{
            System.out.println("El numero de cuenta seleccionado no existe,"
                    + " intentelo nuevamente.");
        }
               
        }while(numCuenta<1 | 10<numCuenta);
    }
    
    
    public static int seleccionMenu(Scanner input){
        System.out.println("""
                           Favor elija una ocpion del Menu de procesos:
                           1.Retiro
                           2.Deposito
                           3.Consulta de saldo
                           4.Cambio de pin
                           """);
        do{
        opcMenu= input.nextInt(); input.nextLine();
        
            if (opcMenu>0 && 4>=opcMenu){
                System.out.println();
            }
            else{
                System.out.println("Su seleccion no es valida, favor intentelo"
                        + "nuevamente: ");
            }
        
        }while(opcMenu<1 | 4<opcMenu);
        
        return opcMenu;
    }//Fin seleccion menu
    
        public static void procesoMenu(double retiro, Scanner input,
            CuentaBanco cuenta[], double deposito, String pin){
    
    switch (opcMenu)
            {
            case 1:
                caseRetiro(retiro, input, cuenta,pin);
                    
                break;
            case 2: 
                caseDeposito(deposito, input, cuenta);
                break;
            case 3:
                System.out.println("CONSULTA DE SALDO");
                System.out.println("Su saldo actual es "+
                        cuenta[numCuenta].getBalance());
                System.out.println();
                break;
            case 4:
                System.out.println("CAMBIO DE PIN");
                System.out.println("Para solicitar un cambio de pin, favor"
                        + " verifique su pin actual: ");
                verificarPin(pin, input, cuenta); //Verificar pin
                cambioPin(pin,input,cuenta); //Cambio nuevo pin
                break;  
                
            }
    }
    
    public static void asignarPin(String pin, Scanner input, CuentaBanco cuenta []){
        do{
        pin = input.nextLine();
            if (pin.length()==4){
                System.out.println("Su pin de 4 digitos es valido.");
            }
            else {
                System.out.println("""
                   Su pin debe ser de 4 digitos, favor intentelo nuevamente.
                   Ingrese su nuevo pin de seguridad: 
                   """);
            }
        }while(pin.length()!=4);
        cuenta[numCuenta].setPin(pin);
        System.out.println("Su nuevo pin de seguridad a sido asignado "
                + "exitosamente.");
        System.out.println("El pin es "+cuenta[numCuenta].getPin()+"\n");
    }
    public static void cambioPin(String pin, Scanner input, CuentaBanco cuenta []){
            System.out.println("Favor ingrese su nuevo pin: ");
        do{
        pin = input.nextLine();
            if (pin.length()==4){
                System.out.println("Su pin de 4 digitos es valido.");
            }
            else {
                System.out.println("""
                   Su pin debe ser de 4 digitos, favor intentelo nuevamente.
                   Ingrese su nuevo pin de seguridad: 
                   """);
            }
        }while(pin.length()!=4);
        cuenta[numCuenta].setPin(pin);
        System.out.println("Su nuevo pin de seguridad a sido asignado "
                + "exitosamente.");
        System.out.println("El pin es "+cuenta[numCuenta].getPin()+"\n");
    }
    
        public static void verificarPin(String pin, Scanner input,
                CuentaBanco cuenta[]){
    int intentos=3;
        do{
        pin = input.nextLine();
        intentos--;
        
            if (pin.equals(cuenta[numCuenta].getPin())){
                System.out.println("Gracias por verificar su cuenta, "
                        + "por favor prosiga.\n");
                break;
                
            }
            else  {
                System.out.printf("Su pin es invalido. %d intentos disponibles "
                        + "antes de bloquear la cuenta.\n", intentos);
            
            }
            if (intentos<1){
                System.out.println("Su cuenta a sido bloqueada, favor "
                        + "contactenos al +1-880-845-5474 para verificar su "
                        + "identidad.\n");
            System.exit(0);
            }
            
        }while(!pin.equals(cuenta[numCuenta].getPin()));
    }
    
    public static void caseRetiro(double retiro, Scanner input, CuentaBanco cuenta[],String pin) {
        System.out.println("RETIRO");
        System.out.println("Antes de hacer un retiro favor verifique su pin"
                + " nuevamente.");
        verificarPin(pin, input, cuenta); //Verificar pin 
        do {
            System.out.println("Favor ingrese la cantidad que desea retirar:");
            retiro = input.nextDouble();
            input.nextLine();
            if (retiro > cuenta[numCuenta].getBalance()) {
                System.out.println("Fondos insuficientes,"
                        + " intentelo nuevamente.");
            } else if (retiro < 1) {
                System.out.println("Su retiro no puede ser menor o "
                        + "igual que cero, intentelo nuevamente.");
            } else {
                System.out.print("Su solicitud se esta procesando...");
                System.out.println();
            }

        } while (retiro > cuenta[numCuenta].getBalance() | retiro < 1);
        
        cuenta[numCuenta].setUltimoRetiro(retiro);
        System.out.println("Ha retirado un total de "+cuenta[numCuenta].getUltimoRetiro()
                + ", su nuevo balance disponible es de "+ cuenta[numCuenta].getBalance());
        System.out.println();
        System.out.println("Gracias por utilizar nuestros servicos");
        System.exit(0);
    }
                
    public static void caseDeposito(double deposito,Scanner input,CuentaBanco cuenta[]){
                System.out.println("DEPOSITO");
                do{
                System.out.println("Favor ingrese la cantidad que desea depositar:");
                deposito = input.nextDouble(); input.nextLine();
                    if (deposito>4000){
                        System.out.println("Ha excedido el limite, favor intentelo"
                                + " nuevamente.");
                    }
                    else if (deposito<1){
                        System.out.println("Su deposito no puede ser menor"
                                + " o igual que cero, intentelo nuevamente.");
                    }
                    else {
                        System.out.print("Su solicitud se esta procesando...");
                        System.out.println();
                        }                    
                
                }while(deposito<1 | 4000<deposito);
                
                    cuenta[numCuenta].setUltimoDeposito(deposito);
                System.out.println("Ha depositado un total de "+cuenta[numCuenta].getUltimoDeposito()
                        + ", su nuevo balance disponible es de "+
                        cuenta[numCuenta].getBalance());
                System.out.println("Muchas gracias por usar nuestros servicos");
                System.exit(0);
    }
    

    

    
}//Fin class
