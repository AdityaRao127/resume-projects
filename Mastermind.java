import java.util.*;
public class MasterMind {
    public static void main(String[] args) {

        //inp and rand declarations.
        String[] colors = {"r","y","b","g","w","o"};
        String[] inp = new String[4];
        String[] rand = new String[4];
        //populate the rand array with random colors from colors. 
        for (int i = 0; i < rand.length; i++) {           
            int val = new Random().nextInt(colors.length);
            rand[i] = colors[val];
        }
        
        //new scanner declaration. 
        Scanner console = new Scanner(System.in);

        //welcome messages
        System.out.println("Welcome to the Mastermind game!");
        System.out.println("You have 10 guesses to guess the randomly generated combination of the following six colors: \n red(r) yellow(y) blue(b) green(g) white(w) orange(o)");
       
       //method call that starts the entire game. 
        enterColors(inp, rand, console);

    }

    public static void enterColors(String[] inp, String[] rand, Scanner console) {
        //for loop to enter each guess; 10 guess limit. 
        int guess = 1;
        System.out.print("This is guess " + guess + " out of 10" + "\n");
        while (guess <= 10) {
            for (int i = 0; i < inp.length; i++) {
                System.out.print("Enter value " + (i + 1) + ": ");
                inp[i] = console.next();
                System.out.println("");
            }
            guess++;
            checkPos(rand, inp); //method that checks the guesses
            
            //loser sequence initiates if user does not win in the guess limit; and correct values are printed. 
            if (guess > 10) {
                System.out.println(""); 
                System.out.print("you lose" + " here is the right answer: " + Arrays.toString(rand));
                System.exit(0);
            }
            
            //prints after each guess to remind them of the options and the     amount of guesses taken. 
            System.out.println("This is guess " + (guess) + " out of 10" + "\n" + "red(r) yellow(y) blue(b) green(g) white(w) orange(o)" + "\n");
        }


    }

    public static void checkPos(String[] rand, String[] inp) {
        
        //red pegs, white pegs, and blank variable declarations
        int red = 0;
        int white = 0;
        int blank = 0;
        int count = 0;
        boolean x = false;

        //win statement
        if (Arrays.equals(rand, inp)) {
            System.out.println("YOU WIN!");
            System.exit(0); //exit statement after game is won
        }
        
        
        //red and white pegs calculations
        for (int i = 0; i < inp.length; i++) {
            if (inp[i].equals(rand[i])) {
                red++;
            } 
            else {
                for (int y = 0; y < rand.length; y++) {
                    if (inp[i].equals(rand[y])) {
                        white++;
                        break;
                    }
                }
            }
        }

        blank = 4 - red - white; //blank pegs calculation


        System.out.println("");
        //tells the user information about their guess. After these print, the next try will appear. 
        System.out.println(red + " red pegs, " + white + " white pegs, and " + blank + " blank spaces.");

    }
}