import java.util.Scanner;

/**
 * Created by 46066294p on 10/03/16.
 */
public class MenuMainBaseX {


    public static void main(String[] args) throws Exception {
        ejecucion1();
    }//main

    /**
     * Logica y gestion del programa
     */
    private static void ejecucion1(){
        System.out.println("EjerciciosM03 ::Marc Cano:: db4o");
        Scanner input = new Scanner(System.in);

        try {

            String menu = "";
            boolean on = true;//condicio de sortida del programa


            while (on) {
                System.out.println("\n");
                System.out.println("MENU:");
                System.out.println(" 1--> Quins països hi ha en el fitxer «factbook.xml»?");
                System.out.println(" 2--> Quants països hi ha?");
                System.out.println(" 3--> Quina és la informació sobre Alemanya ?");
                System.out.println(" 4--> Quanta gent viu a Uganda segons aquest fitxer?");
                System.out.println(" 5--> Quines són les ciutats de Perú que recull aquest fitxer?");
                System.out.println(" 6--> Quanta gent viu a Shanghai?");
                System.out.println(" 7--> Quin és el codi de matricula de cotxe de Xipre?");
                System.out.println(" 0--> Salir del programa");
                System.out.println(" ");
                menu = input.nextLine();

                switch (menu) {
                    case "0": {
                        System.out.println("\n...salir");
                        on = false;
                        break;
                    }

                    case "1": {
                        break;
                    }

                    case "2": {
                        break;
                    }

                    case "3": {
                        break;
                    }

                    case "4": {
                        break;
                    }

                    case "5": {
                        break;
                    }

                    case "6": {
                        break;
                    }

                    case "7": {
                        break;

                    }case "8": {
                        break;
                    }

                    case "9": {
                        break;
                    }

                    case "10": {
                        break;
                    }

                    case "11": {
                        break;
                    }

                    default: {
                        System.out.println("\n...entrada de menu incorrecta\n");
                        break;
                    }

                }//switch

            }
        } catch(Exception e){
            e.getStackTrace();
        }
        finally {
            input.close();
        }
    }
}
