package JavaDevs;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
 
public class Process {
  private int counter = 0;
  private int choice = 1;
  private int maxCharacters = 25;

  /**
  * setNames method sets the names of the fields.
  * First of all it sets the name of the primary key field and then the names of the rest fields.
  * All names are entered by the user.
  * @author Pantelis Kirpoglou
  * @param list database
  * @return list
  * @throws InputMismatchException 
  */

  public LinkedList<LinkedList<String>> setNames(LinkedList<LinkedList<String>> 
      list) throws InputMismatchException {
    counter = 0;

    System.out.println("\nGive the name of the primary key field");
    Scanner input = new Scanner(System.in);
    String keyName = input.nextLine();
    if (keyName.equals("")) {
      System.out.println("!! Primary key cannot be null !!");
      setNames(list);
    } else {
      counter++;
      list.add(new LinkedList<String>());
      list.getFirst().add(keyName);
      System.out.println(list.getFirst().get(0));
      do {
        try { 

          System.out.println("Do you want to continue? If yes, press 1. If not, press any number.");
          Scanner inp = new Scanner(System.in);
          choice = inp.nextInt();
          if (choice == 1) {

            System.out.println("\nGive the name of the rest fields");
            Scanner input1 = new Scanner(System.in);
            String name = input1.nextLine();
            if (!name.equals(keyName)) {
              list.add(new LinkedList<String>());
              list.get(counter).add(name);
              System.out.println("\n" + list.get(counter).get(0));
              counter++;


            } else {
              System.out.println("!! Field name cannot be the same with the primary key field !!"
                   + "\nPlease try again\n");
            }

          }
        } catch (InputMismatchException e) {
          System.out.println("\n!! Please give an Integer !!\n");
        }
      } while  (choice == 1);
    }

    return list;

  }

  public LinkedList<LinkedList<String>> input(LinkedList<LinkedList<String>> list) {
    return addRecord(list);
  }


  /** 
  * method addRecord adds to the list the records entered by the user.
  * @authors Pantelis Kirpoglou, Aristi Syriou
  * @param list database
  * @return list
  */ 
  public LinkedList<LinkedList<String>> addRecord(LinkedList<LinkedList<String>> 
      list) throws InputMismatchException {
    int choice = 1;
    Scanner input = new Scanner(System.in);
    do {
      for (int i = 0; i < list.size(); i++) {
        boolean found = false;

        System.out.println("Give the field: " + list.get(i).get(0));
        Scanner input1 = new Scanner(System.in);
        String record = input1. nextLine();
        if (record.equals("")) {
          found = true;
        }
        if (i == 0) {
          for (int j = 0; j < list.get(0).size(); j++) {
            if (record.equals(list.get(0).get(j))) {
              found = true;
            }
          }

        }
        if (!found) {
          list.get(i).add(record);
        } else {
          System.out.println("\n!! Primary key cannot be null or same with previous primkey !!\n");
          break;
        }
      }
      do {
        try {
          System.out.println("Do you want to add new information?");
          System.out.println("1.yes");
          System.out.println("2.no");
          Scanner input4 = new Scanner(System.in);
          choice = input4.nextInt();
          if (choice != 1 && choice != 2) {
            System.out.println("\n!! Please answer only with 1 or 2 !!\n");
          }
        } catch (InputMismatchException e) {
          System.out.println("\n!! Please give an Integer !!\n");
          choice = 3;
        }
      } while (choice != 1 && choice != 2);
    } while (choice == 1);
    return list;
  }
  /**
  * method edit lets the user change the name or the value of an existing field.
  * @authors Anna Kotsa, Giannis Methenitis, Pantelis Kirpoglou
  * @param list database
  * @return list
  */

  public LinkedList<LinkedList<String>> edit(LinkedList<LinkedList<String>> list) 
        throws InputMismatchException  {

    Scanner input = new Scanner(System.in);
    try {
      if (list.isEmpty() == true) {
        System.out.println("The base is empty.");
      } else {
        int ak = searchByPrimKey(list, 2);
        if (ak == -1) {
          System.out.println(" !! There is no such record."
              + "Do you want to try again? If yes,press 1. !!");
          int ans = input.nextInt();
          if (ans == 1) {
            list = edit(list);
          } 
        } else {
          System.out.println("Provide the name of the field you want to edit:");
          for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get(0));
          }

          String pedio = input.nextLine();
          int p = -1;
          int i = 0;
          boolean found = false;
          while (p == - 1 && !found) {
            while (i < list.size() && !found) {
              if (pedio.equals(list.get(i).get(0))) {
                p = i;
                found = true;
              }
              i++;
            }
            if (!found) {
              System.out.println(" !! No such field name, please try again !!");
              list = edit(list);
            }
          }
          System.out.println("Please enter the new value");
          String newValue = input.nextLine();

          if (newValue.equals("") && p == 0) {
            System.out.println("\n !! Primary key cannot be null"
                + " or same with previous primary key !!\n");
          } else {
            list.get(p).set(ak, newValue);
          }
        }
      }
      return list;
    }catch (InputMismatchException e) {
	  System.out.println("\n!! Please give an Integer !!\n");
	}
       return list;
  }

  public LinkedList<LinkedList<String>> delete(LinkedList<LinkedList<String>> list) {
    return deletionChoice(list);
  }


  /**
  * method deletionChoice prints the delete options.
  * User chooses from the menu and depends on his choice,
  * method deletionChoice calls two other methods :
  * deleteTheBase and deleteTheRecord.
  * @authors Danai Tzoumpa, Ioanna Kalogeropoulou
  * @param list database
  * @return list
  */
  public LinkedList<LinkedList<String>> deletionChoice(LinkedList<LinkedList<String>> 
      list) throws InputMismatchException {
    boolean flag = true;
    LinkedList<LinkedList<String>> sublist = new  LinkedList<LinkedList<String>>();
    sublist = list;
    do {
      try {
        System.out.println("Choose an option from below: ");
    
        System.out.println("1.Delete the whole base.\n2.Delete a spesific record.\n"
            + "3.Return to basic menu.\n");
        Scanner input = new Scanner(System.in);
        int ch = input.nextInt();
        switch (ch) {
          case 1:
            sublist = deleteTheBase(sublist);
            flag = false;
            break;
          case 2:
            sublist = deleteRecord(sublist);
            break;
          case 3:
            flag = false;
            break;
          default:
            System.out.println("Not a valid option; give another option\n");
        }
      } catch (InputMismatchException e) {
        System.out.println("\n!! Please give an Integer !!\n");
      }
    } while (flag == true);
    return sublist;
  } //end of deletionChoice


  /**
  * method deleteTheBase deletes the whole base, including both records and fields
  * only if it's not already empty.
  * @authors Danai Tzoumpa, Ioanna Kalogeropoulou
  * @param list database
  * @return list
  */
  public LinkedList<LinkedList<String>> deleteTheBase(LinkedList<LinkedList<String>> 
      list) throws InputMismatchException {
    if (list.isEmpty()) {
      System.out.print("The DataBase is already empty");
    } else {
      System.out.println("Are you sure you want to delete the whole base?\nIf yes press 1.");
      Scanner ans = new Scanner(System.in);
      int c = ans.nextInt();
      if (c == 1) {
        list.clear();
        list = setNames(list);
      }
    }
    return list;

  } //end of deleteTheBase


  /**
  * method deleteRecord deletes one specific record that is defined by the user.
  * @authors Ioanna Kalogeropoulou, Danai Tzoumpa, Pantelis Kirpoglou
  * @param list database
  * @return list
  */
  public LinkedList<LinkedList<String>> deleteRecord(LinkedList<LinkedList<String>> 
      list) throws InputMismatchException {
    System.out.println("\n!! Please give an Integer !!\n");
 
    if (list.isEmpty() == true) {
      System.out.println("The base is empty.");
    } else {
      int pos = searchByPrimKey(list, 1);
      if (pos == -1) {
        System.out.println("!! There is no such record.Do you want to try again? "
            + "If yes,press 1. !!");
        Scanner input = new Scanner(System.in);
        int ans = input.nextInt();
        if (ans == 1) {
          list = deleteRecord(list);
        }
      } else {
        for (int i = 0; i < list.size(); i++) {
          list.get(i).remove(pos);
        }
        System.out.println("The record has been deleted.\n");

      } // end inner if
    } //end outer if
    return list;

  } //end of method



  public void view(LinkedList<LinkedList<String>> list) {
    viewList(list);
  } //end progress method

  /**
  * method viewList prints a menu with the data viewing options.
  * User chooses from the menu and depends on his choice,
  * method viewList calls three other methods :
  * viewEverything, viewByPrimKey and viewByItem.
  * @param list database
  */
  public void viewList(LinkedList<LinkedList<String>> list) throws InputMismatchException {

    boolean cont = true;
    while (cont == true) {
      try {
        System.out.println("\n1.To view the whole list\n"
            + "2.To view an item by its primary key\n"
            + "3.To view by item\n"
            + "4.To exit");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
          case 1:
            viewEverything(list);
            break;
          case 2:
            viewByPrimKey(list);
            break;
          case 3:
            viewByItem(list);
            break;
          case 4:
            cont = false;
            break;
          default:
            System.out.println("!! Not a valid option; give another option. !!");
        } //end switch
      } catch (InputMismatchException e) {
        System.out.println("\n!! Please give an Integer !!\n");
      }
    } 

  } //end method viewList


  /**
  * method viewEverything prints the whole data base.
  * @author Pantelis Kirpoglou
  * @param list database
  */

  public void viewEverything(LinkedList<LinkedList<String>> list) {
    for (int j = 0; j < list.get(0).size(); j++) {
      for (int i = 0; i < list.size(); i++) {
        System.out.printf("|%15s|", list.get(i).get(j));
      }
      System.out.println();
    }
  }  //end viewEverything method


  /**
  * method viewByPrimKey prints a specific record which is searched by its primary key.
  * @authors Pantelis Kirpoglou, Aliki Ntouzgou
  * @param list database
  */

  public void viewByPrimKey(LinkedList<LinkedList<String>> list) {
    if (list.isEmpty() == true) {
      System.out.println("The base is empty.");
    } else {
      int position = searchByPrimKey(list, 3);
      if (position == -1) {
        System.out.println("There is no such record.Do you want to try again? If yes, press 1.");
        Scanner input = new Scanner(System.in);
        int ans = input.nextInt();
        if (ans == 1) {
          viewByPrimKey(list);
        }
      } else {
        for (int i = 0; i < list.size(); i++) {
          System.out.printf(list.get(i).get(position) + " ");
        }
      }
    } 
  }


  /**
  * method viewByItem prints the records the user wants to view.
  * In this case the records are searched by other clues than the primary key.
  * @author Pantelis Kirpoglou
  * @param list database
  */

  public void viewByItem(LinkedList<LinkedList<String>> list) {
    LinkedList<LinkedList<String>> sublist = new LinkedList<LinkedList<String>>();
    for (int i = 0; i < list.size(); i++) {
      sublist.add(new LinkedList<String>());
      sublist.get(i).add(list.get(i).get(0));
    }
    if (list.isEmpty() == true) {
      System.out.println("The base is empty.");
    } else {
      System.out.println("Please enter the item of the record you want to view.");
      Scanner input = new Scanner(System.in);
      String item = input.nextLine(); 
      boolean found = false;
      for (int j = 0; j < list.size(); j++) {
        for (int k = 0; k < list.get(0).size(); k++) {
          if (list.get(j).get(k).equals(item)) {
            for (int z = 0; z < list.size(); z++) {
              sublist.get(z).add(list.get(z).get(k));
              found = true;
            } //end of for(z)
          } //end of if
        } //end of for(k)
      } //end of for(j)
      if (!found) {
        System.out.println("!! The item you entered is not in the list;" 
            + " do you want to try again? If YES press 1. !!");
        Scanner choice = new Scanner(System.in);
        int ch = choice.nextInt();
        if (ch == 1) {
          viewByItem(list);
        }
      } else {
        for (int s = 0; s < sublist.get(0).size(); s++) {
          for (int l = 0; l < sublist.size(); l++) {
            System.out.printf("|%15s|", sublist.get(l).get(s));
          }
          System.out.println();
        }
      }
    }
  }

  /**
  * method searchByFirstKey accesses the list of the primary key
  * to find the record the user wants to delete.
  * @authors Pantelis Kirpoglou, Ioanna Kalogeropoulou, Danai Tzoumpa
  * @param list database
  * @param whereFrom (if the method is called from delete(1), edit(2) or view(3))
  * @return list
  */

  public int searchByPrimKey(LinkedList<LinkedList<String>> list, int whereFrom) {
    if (whereFrom == 1) {
      System.out.println("Type the primary key of the record you want to delete");
    } else if (whereFrom == 2) {
      System.out.println("Type the primary key (" + list.get(0).get(0)
          + ") of the record you want to edit");
    } else if (whereFrom == 3) {
      System.out.println("Type the primary key of the record you want to view");
    }

    Scanner input = new Scanner(System.in);
    String ans = input.nextLine(); 
    int pos = -1;
    boolean found = false;
    int i = 1;
    while (i < list.get(0).size() & !found) {
      if (ans.equals(list.get(0).get(i))) {
        found = true;
        pos = i;
      }
      i++;
    }

    if (!found) {
      return -1;
    } else {
      return pos;
    }
  } 

  /**
   * method saveDatabase saves the database to a selected
   * file with the name of the database.
   * @authors Aliki Ntouzgou, Giannis Methenitis
   * @param list database
   * @param databaseName filename
   */
  
  public void saveDatabase(LinkedList<LinkedList<String>> list, String databaseName) {

    String filename = databaseName + ".txt";

    try  (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filename))) {
      for (int i = 0; i < list.size(); i++) {
        for (int j = 0; j < list.get(0).size(); j++) {
          String msg = list.get(i).get(j);
          out.write(msg.getBytes());
          out.write(" ".getBytes());
        } //end inner for
        out.write("\n".getBytes());
      } //end outer for
      System.out.println("Your Datbase has been saved");
    } catch (FileNotFoundException e) {
      System.err.println("Unable to open file"
          + filename + " : " + e.getMessage());
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Error writing file: " + e.getMessage());
      System.exit(1);
    }
  }
} //end of class
