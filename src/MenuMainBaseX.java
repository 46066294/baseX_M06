import org.basex.api.client.ClientSession;

import java.io.IOException;
import java.util.Scanner;

/**
 * Obrir servidor baseX (port per defecte 1984
 * user: admin, password: admin).
 *
 * Logica y gestio del programa que respon a les
 * preguntes plantejades en el menu, utilitzant
 * consultes Xpath.
 *
 * S'utilitzen 2 col·leccions (factbook.xml per a
 * la primera pregunta, i mondial.xml per a la resta).
 *
 * Created by 46066294p on 10/03/16.
 */
public class MenuMainBaseX {
    //comando para abrir baseX: java -jar 'y arrastrar baseX.jar'
    //ubicacion de archivos mondial, factbook en directorio bin

    public static void main(String[] args) throws Exception {
        ejecucion1();
    }//main


    private static void ejecucion1() throws IOException {
        System.out.println("BaseX - Xpath M06 ::Marc Cano:: ");
        Scanner input = new Scanner(System.in);

        ClientSession sessio = new ClientSession("localhost", 1984, "admin", "admin");
        System.out.println("\n...sessió oberta correctament");


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
                        paisosFactbook(sessio);
                        break;
                    }

                    case "2": {
                        quantsPaisosMondial(sessio);
                        break;
                    }

                    case "3": {
                        infoAlemanya(sessio);
                        break;
                    }

                    case "4": {
                        populationUganda(sessio);
                        break;
                    }

                    case "5": {
                        peruCities(sessio);
                        break;
                    }

                    case "6": {
                        populationShanghai(sessio);
                        break;
                    }

                    case "7": {
                        codiXipre(sessio);
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
            sessio.close();
            input.close();
            System.out.println("...sessió tancada");
        }
    }



    //:::::::::::::METODES:::::::::::::

    private static void paisosFactbook(ClientSession sessio) {
        long t1 = System.currentTimeMillis();
        System.out.println("Països del fixer factbook:\n");

        String query  = "collection('Factbook.xml')/factbook/record/country";

        try {
            System.out.println(sessio.query(query).execute() + " països");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }


    private static void quantsPaisosMondial(ClientSession sessio) {
        long t1 = System.currentTimeMillis();
        System.out.println("Països del fixer mondial:\n");

        String query  = "collection('mondial.xml')/count(/mondial/country)";

        try {
            System.out.println(sessio.query(query).execute() + " països");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        //System.out.println(result);
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }


    private static void infoAlemanya(ClientSession sessio) {
        long t1 = System.currentTimeMillis();
        System.out.println("Informació sobre Alemanya:\n");
        String query  = "collection('mondial.xml')/mondial/country[name=\"Germany\"]";

        try {
            System.out.println(sessio.query(query).execute());
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }


    private static void populationUganda(ClientSession sessio) {
        long t1 = System.currentTimeMillis();

        String query  = "collection('mondial.xml')/mondial/country[name=\"Uganda\"]/population[last()]/text()";

        try {
            System.out.println("Demografia a Uganda al 2014: " + sessio.query(query).execute() + " persones");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }


    private static void peruCities(ClientSession sessio) {
        long t1 = System.currentTimeMillis();

        String query  = "collection('mondial.xml')/mondial/country[name=\"Peru\"]/province/city/name/text()";
        System.out.println("CIUTATS DE PERU:");

        try {
            System.out.println(sessio.query(query).execute());
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }


    private static void populationShanghai(ClientSession sessio) {
        long t1 = System.currentTimeMillis();

        String query  = "collection('mondial.xml')/mondial/country/province[name=\"Shanghai\"]/population[last()]/text()";

        try {
            System.out.println("Gent que viu a Shanghai: " + sessio.query(query).execute() + " persones");
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }

    private static void codiXipre(ClientSession sessio) {
        long t1 = System.currentTimeMillis();
        System.out.println("Matriculació de Xipre:");

        String query  = "collection('mondial.xml')/mondial/country[name=\"Cyprus\"]/@car_code";

        try {
            System.out.println(sessio.query(query).execute());
        } catch (IOException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Executat en " + (t2-t1) + " ms");
    }


}


