//import java.util.Scanner;
//import java.util.ArrayList;

/* 
class Main {
  //Creating array outside main so that we do not need to keep sending array to every method.
  static  ArrayList<String> list = new ArrayList<String>();
  
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Welcome to To-Do List! Choose one of the option below.");
    //ask the user what they want to do
    boolean check = false;
    while (! check){
      System.out.println("'V' - to view the current list.\n'A' - to add a new item to the list. \n'D' - to delete an existing item. \n'M' - to move an item to a new location. \n'Q' - to quit.");
      //if input match then it will direct to the method user select
      //the program will not stop asking what the user want to do until the user select to quit
      String answer = kb.next();
      if (answer.equals("v") || answer.equals("V")){
        viewlist();
        System.out.println("What do you want to do next?");
      }
      else if (answer.equals("a") || answer.equals("A")){
        addlist();
        System.out.println("What do you want to do next?");
      }
      else if (answer.equals("d") || answer.equals("D")){
        delete();
        System.out.println("What do you want to do next?");
      }
      else if (answer.equals("m") || answer.equals("M")){
        move();
        System.out.println("What do you want to do next?");
      }
      else if (answer.equals("q") || answer.equals("Q")){
        System.out.println("Thank you for using our service. Have a good day!");
        System.exit(0);
      }
      else{
        System.out.println("Input invalid. Please try again");
      } 
    }
  }

  public static void viewlist() { 
    System.out.println("This is your To-Do List: ");
    //view the list
    for (String item : list) {
      System.out.println((list.indexOf(item) + 1) + ". " + item);
    }
  }

  public static void addlist(){
    //ask the user want they want to add into the list
    Scanner kb = new Scanner(System.in);
    System.out.println("Add to your To-Do List: ");
    String todo = kb.nextLine();
    //add the input to the list and print the list
    list.add(todo); 
    viewlist();
  }

  public static void delete(){
    //ask the user the item they want to delete
    Scanner kb = new Scanner(System.in);
    boolean check = false;
    //check if the input is integer
    while (check == false){
      System.out.println("Which number do you wish to delete?");
      if (kb.hasNextInt()){
        //remove the item that the user want to be remove
        int removelist = kb.nextInt();
        list.remove(removelist - 1);
        viewlist();
        check = true;
      }
      else{
        System.out.println("Input invalid. Try again!");
        kb.next();
      }
    }
    
  }
 
  
  public static void move(){
    //save the previoous to do and add them and move the other down or up
    Scanner kb = new Scanner(System.in);
    //check if the input  is integer if it is then go to the next question
    boolean check1 = false;
    while (check1 == false){
      System.out.println("Which line do you want to move?");
      if(kb.hasNextInt()){
        int line = kb.nextInt();
        boolean check2 = false;
        while (check2 == false){
          System.out.println("Which number to you want to move it to?");
          //when both is verified, we will save the line that we want to move 
          if(kb.hasNextInt()){
            int newline = kb.nextInt();
            String temp = list.get(line - 1);
            //remove the line and add it to new location the user want it to be. 
            list.remove(line - 1);
            list.add(newline - 1, temp);
            //once it is add to the list, other to do list will move down or up by themselves
            viewlist();
            check2 = true;
            check1 = true;
          }
          else{
            System.out.println("Input invalid. Try again!");
            kb.next();
          }
        }
        
      }
      else{
        System.out.println("Input invalid. Try again!");
        kb.next();
      } 
    }
    
  }
  
}
*/
