/**
 * @title Birthday
 * @description This program to order birthday gifts and calculate the total cost
 * @author Sungmin Kim
 * @class CMSC 203
 * @professor Prof.Monshi
 * @assignment 2
 * @date 2020/02/25
 */
import javax.swing.JOptionPane;
import java.util.Random;;

public class Birthday {

	public static void main(String[] args) {
		//variables to store name and total price
		String name = "no name";
		double sum=0;
		//variables for valid input from user
		String answer = "no";
		boolean validAnswer = true;
		boolean validToy = true;
		
		//create objects
		Random r = new Random(); // random object
		Toy t = new Toy(); // toy object
		
		//welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company \nto choose gifts for young children");
		
		do { //do-while loop for another toy
			//get name from user
			name = JOptionPane.showInputDialog("Enter the name of the child");
			//get age from user
			t.setAge(Integer.parseInt(JOptionPane.showInputDialog("How old is the child?")));
			
			do { //do-while loop for age-appropriate
				
				do {//do-while loop for valid toy
					//get which toy user want to buy
					t.setToy(JOptionPane.showInputDialog("Choose a toy: plushie, blocks, or book"));
					//check validation of the toy
					validToy = t.getToy()=="plushie" || t.getToy()=="blocks" || t.getToy()=="book";
					//if invalidation toy, choose toy again
					if (!validToy) {
						JOptionPane.showMessageDialog(null, "Invalid choice\nPlease choose again \n(We have only plushie, blocks, or book)");
					}
				}while(!validToy);
				
				//check age-appropriate
				if (t.ageOK()) { //age-appropriate
					JOptionPane.showMessageDialog(null, "Good Choice!");
					answer = "no";
				}else { // not age-appropriate
					do { //do-while loop for valid answer
						//ask if user want to buy the other toy
						answer = JOptionPane.showInputDialog("Toy is not age-appropriate \nDo you want to buy a different toy? yes of no");
						validAnswer = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no");
						if (!validAnswer) {
							JOptionPane.showMessageDialog(null, "Invalid answer \nPlease answer again");
						}
					}while(!validAnswer);
				}
			}while(answer.equals("yes"));
			
			//set toy's cost
			t.setCost(t.getToy());
			
			//ask if user want to buy card as well
			do{
				//card
				t.addCard(JOptionPane.showInputDialog("Do you want a card with the gift? yes or no"));
				validAnswer = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no");
				if (!validAnswer) {
					JOptionPane.showMessageDialog(null, "Invalid answer \nPlease answer again");
				}
			}while(!validAnswer);
			//ask if user want to buy balloon as well
			do{
				t.addBalloon(JOptionPane.showInputDialog("Do you want a balloon with the gift? yes or no"));
				validAnswer = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no");
				if (!validAnswer) {
					JOptionPane.showMessageDialog(null, "Invalid answer \nPlease answer again");
				}
			}while(!validAnswer);
			
			//add the coat to sum
			sum += t.getCost();
			
			//display the cost of this toy
			JOptionPane.showMessageDialog(null, "The gift for " + name + t);
			do {//do-while loop for validAnswer
				answer = JOptionPane.showInputDialog("Do you want another toy? yes or no");
				validAnswer = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no");
				if (!validAnswer) {
					JOptionPane.showMessageDialog(null, "Invalid answer \nPlease answer again");
				}
			}while(!validAnswer);
			
		}while(answer.equals("yes")); //if user wants to buy another toy, go back to the stage of the input name
		
		
		//display the order number (random number) and total cost, and programmer's name
		JOptionPane.showMessageDialog(null, "Order number is " + r.nextInt(100000) +  "\nTotal price: $" + sum + "\nProgrammer: Sungmin Kim");
		
	}

}
