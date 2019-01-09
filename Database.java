package JavaDevs;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
  public static LinkedList<LinkedList<String>> mainList = 
      new LinkedList<LinkedList<String>>();

  /**
   * method main provides the basic info for the database,
   * such as the name of both the user and the database he wants
   * to create and then it helps the user define the fields of his database.
   * After that is accomplished, it prints a full menu of the program
   * abilities, which are: input, delete, edit, view and save database.
   * @authors Pantelis Kirpoglou, Danai Tzoumpa
   * @authors of the SQL part: Ioanna Kalogeropoulou, Anna Kotsa, Aristi Syriou
   * @param args .
   * @throws InputMismatchException for invalid input
   */
  
  public static void main(String[] args) throws InputMismatchException {

    Scanner option = new Scanner(System.in);

    System.out.println("Give your name: ");
    final String name = option.nextLine();
    System.out.println();
    System.out.println("Give your Database name: ");
    String dataName = option.nextLine();
    System.out.println("\n");
    
    System.out.println("Do you want to connect with an existing SQL DataBase?");
    System.out.println("If yes, press 1. If no, press 2.");

    int answer = 0;
    do {
      try {
        Scanner option1 = new Scanner(System.in);
        answer = option1.nextInt();
        if (answer != 1 && answer != 2) {
          System.out.println("Please answer only with 1 or 2.");
        }
      } catch (InputMismatchException e) {
        System.out.println("\n!! Please give an Integer !!\n");
      }
    } while (answer != 1 && answer != 2);
    if (answer == 1) {
      SQL sql1 = new SQL();
      System.out.println("Please give the url address.");
      Scanner option2 = new Scanner(System.in);
      String url = option2.nextLine();
      sql1.Sql(url, dataName);
    } 
    
    System.out.println("Hello " + name + ", give your database (" + dataName
        + ") new fields \n");
    Process process = new Process();
    process.setNames(mainList);
    int choice;
    boolean flag = true;

    while (flag == true) {
      try {
        System.out.println("Choose an option from the following MENU: \n ");
        System.out.println("\t1. Input Data \n\t2. Delete Data \n\t3. Edit Data \n\t4." 
            + " View Data \n\t" + "5. Save Database\n\t6. Exit \n");
        Scanner option2 = new Scanner(System.in);
        choice = option2.nextInt();

        switch (choice) {
          case 1:
            mainList = process.input(mainList);
            break;
          case 2:
            mainList = process.delete(mainList);
            break;
          case 3:
            mainList = process.edit(mainList);
            break;
          case 4:
            process.view(mainList);
            break;
          case 5:
            process.saveDatabase(mainList, dataName);
            break;
          case 6:
            flag = false;
            break;
          default:
            System.out.println("Not a valid option. Please give another option\n ");
        }
      } catch (InputMismatchException e) {
        System.out.println("\n!! Please give an Integer !!\n");
      }
    } 
  }
}
