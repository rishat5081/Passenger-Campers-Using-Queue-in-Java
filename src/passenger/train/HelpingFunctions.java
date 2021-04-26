package passenger.train;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class HelpingFunctions {

    /**
     * Camper is the class which will have all the information of the camper
     * like firstName, lastName and etc here the Queue is create of the Camper
     * to hold one information of one Camper and two different attributes are
     * create one for male and one for female
     */
    public static Queue<Camper> maleList;
    public static Queue<Camper> femaleList;
    private static BufferedReader bufferedReader;
    private static FileReader fileReader;

    public HelpingFunctions() {
        /**
         * Initializing the Queue
         */
        maleList = new LinkedList<>();
        femaleList = new LinkedList<>();
    }

    /**
     * Reading the file and getting all the information of the Camper and using
     * the gender option of male adding the information of the camper into the
     * maleList
     *
     * @return
     */
    public Queue<Camper> getAllMaleCampers() {
        try {
            fileReader = new FileReader(new File("./DataSet.txt"));
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                /**
                 * Line will be split using the comma and return an array using
                 * the indexes the the 11 th index the camper or passenger is
                 * written using that index than we will look the gender which
                 * is present at the fifth position in the text file but in the
                 * code it is at fourth index
                 */
                String[] text = line.split(",");
                if (text[10].equals("Camper")) {
                    if (text[4].equalsIgnoreCase("m")) {
                        Camper camper = new Camper(text[0], text[1], text[2], text[3], text[4], text[5], text[6], text[7], text[8], text[9], text[10]);
                        maleList.add(camper);
                    }
                }
            }
            return maleList;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    /**
     * Female is same for the male just the gender is different
     *
     * @return
     */
    public Queue<Camper> getAllFemaleCampers() {
        try {
            fileReader = new FileReader(new File("./DataSet.txt"));
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] text = line.split(",");
                if (text[10].equals("Camper")) {
                    if (text[4].equalsIgnoreCase("f")) {
                        Camper camper = new Camper(text[0], text[1], text[2], text[3], text[4], text[5], text[6], text[7], text[8], text[9], text[10]);
                        femaleList.add(camper);
                    }
                }

            }
            return femaleList;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    public void writeCamper(FileWriter fileWriter, Queue<Camper> camper, int[] girlsPerCamp, int[] age) {
        try {
            int index = 0, count = 0;
            fileWriter.write(age[index] + "," + girlsPerCamp[index] + "," + "\n");

            for (Camper camper1 : camper) {
                if (girlsPerCamp[index] == count) {
                    index++;
                    if (index > 6) {
                        break;
                    }
                    fileWriter.write(age[index] + "," + girlsPerCamp[index] + "," + "\n");
                    count = 0;

                } else {
                    if (index > 6) {
                        break;
                    }
                    printToFile(fileWriter, camper1);
                    count++;
                }
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printToFile(FileWriter fileWriter, Camper camper1) throws IOException {

//        System.out.println(camper1.getFirstName() + "," + camper1.getMiddleName() + "," + camper1.getLastName()
//                + "," + camper1.getAge() + "," + camper1.getGender() + "," + camper1.getCountryPrefix()
//                + "," + camper1.getCountryCode() + "," + camper1.getContact() + "," + camper1.getStatus() + "\n");
        fileWriter.write(camper1.getFirstName() + "," + camper1.getMiddleName() + "," + camper1.getLastName()
                + "," + camper1.getAge() + "," + camper1.getGender() + "," + camper1.getCountryPrefix()
                + "," + camper1.getCountryCode() + "," + camper1.getContact() + "," + camper1.getStatus() + "\n");
//        System.out.println("\t\t\t\t Added Successfully... !!!");
    }

}
