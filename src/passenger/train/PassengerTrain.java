/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passenger.train;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Engr. S. Saad
 */
public class PassengerTrain {

    public static int INDEX, totalCount;
    public static Scanner scanner;
    private static FileWriter fileWriter;

    public static void main(String args[]) throws IOException {
        scanner = new Scanner(System.in);
        /**
         * Getting the stored data here
         */
        INDEX = 0;
        totalCount = 0;

        Queue<Camper> femalelist = new LinkedList<>();
        Queue<Camper> malelist = new LinkedList<>();
        HelpingFunctions helpingFunctions = new HelpingFunctions();
        femalelist = helpingFunctions.getAllFemaleCampers();
        malelist = helpingFunctions.getAllMaleCampers();

        int maleAge = 12, femaleAge = 12;
        int[] girlsCamper = new int[7];
        int[] girlsCamperAge = new int[7];
        fileWriter = new FileWriter(new File("./girlsCamper.txt"), true);
        System.out.println("\t\t\t\t------------------ Passenger Train ------------------------------");
        for (int i = 0; i < 7; i++) {
            System.out.println("\t\t\t\tPlease enter the tent group size for the '" + femaleAge + "' year old girl ------------");
            int count = 0;
            while (true) {
                count = scanner.nextInt();
                if (count == 1 || count > 4) {
                    System.out.println("Total Count is less or Camper can not be single");
                    System.out.println("Enter Again");
                } else {
                    girlsCamper[i] = count;
                    girlsCamperAge[i] = femaleAge;
                    femaleAge++;
                    break;
                }
            }
        }

        /**
         * Writing text to girls file
         */
        helpingFunctions.writeCamper(fileWriter, femalelist, girlsCamper, girlsCamperAge);

        /**
         * Doing the same for boys
         */
        int[] boysCamper = new int[7];
        int[] boysCamperAge = new int[7];
        fileWriter = new FileWriter(new File("./boysCamper.txt"), true);
        System.out.println("\t\t\t\t------------------ Passenger Train ------------------------------");
        for (int i = 0; i < 7; i++) {
            System.out.println("\t\t\t\tPlease enter the tent group size for the '" + maleAge + "' year old boy ------------");
            int count = 0;
            while (true) {
                count = scanner.nextInt();
                if (count == 1 || count > 4) {
                    System.out.println("Total Count is less or Camper can not be single");
                    System.out.println("Enter Again");
                } else {
                    boysCamper[i] = count;
                    boysCamperAge[i] = maleAge;
                    maleAge++;
                    break;
                }
            }
        }

        /**
         * using the same function to write text in the boy text file
         */
        helpingFunctions.writeCamper(fileWriter, malelist, boysCamper, boysCamperAge);
    }

}
