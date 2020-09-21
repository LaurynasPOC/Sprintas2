package Sprintas2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String name = sc.nextLine();
        System.out.println("Enter employee last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter employee salary: ");
        int salary = sc.nextInt();

        EmployeeInfo personInfo = new EmployeeInfo();
        personInfo.setName(name);
        personInfo.setLastName(lastName);
        personInfo.setSalary(salary);

        File employeesFile = new File("./data/writtingToFiles.csv");
        try {

            FileWriter write = new FileWriter(employeesFile, true);
            BufferedWriter ewr = new BufferedWriter(write);

            ewr.write("Darbuotojo vardas: " + personInfo.getName()+ "\n");
            ewr.write("Darbuotojo pavardė: " + personInfo.getLastName()+ "\n");
            ewr.write("Darbuotojo atlyginimas: " + personInfo.getSalary()+ " eur" + "\n");
            ewr.close();

            FileReader reader = new FileReader(employeesFile);
            BufferedReader erd = new BufferedReader(reader);
            String fileLines = erd.readLine();
            while (fileLines != null){

                String[] splitString = fileLines.split(" ");
                fileLines = erd.readLine();
                System.out.println(Arrays.toString(splitString));

            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
