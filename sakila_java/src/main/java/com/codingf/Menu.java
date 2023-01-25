package com.codingf;

import java.util.Scanner;
public class Menu {

    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Que voulez vous ? :\n\n[1] Les pays \n[2] Les villes \n[3] Quitter");
        int places = Integer.parseInt(input.next());



        if (places == 1) {
            System.out.println("\n[1] Afficher \n[2] Changer \n[3] effacer \n[4] Quitter");
            int pays = Integer.parseInt(input.next());

            if (pays == 1) {
                System.out.println("\nQuel élément voulez-vous afficher ?\nEntrez l'id :");
                int villa = Integer.parseInt(input.next());



            }else if (pays == 2) {
                System.out.println("\nQuel élément voulez-vous changer ?\nEntrez l'id :");
                int villc = Integer.parseInt(input.next());



            }else if(pays == 3){


            }else if(pays == 4){

            }




        }else if (places == 2){
            System.out.println("\n[1] Afficher \n[2] Changer \n[3] effacer \n[4] Quitter");
            int villes = Integer.parseInt(input.next());


            if (villes == 1) {
                System.out.println("\nQuel élément voulez-vous afficher ?\nEntrez l'id :");
                int paya = Integer.parseInt(input.next());


            }else if (villes == 2) {
                System.out.println("\nQuel élément voulez-vous changer ?\nEntrez l'id :");
                int payc = Integer.parseInt(input.next());


            }else if(villes == 3){
                System.out.println("\nQuel élément voulez-vous effacer ?\nEntrez l'id :");
                int paye = Integer.parseInt(input.next());


            }else if(villes == 4){

            }




        }else if (places == 3){

        }


    }
}
