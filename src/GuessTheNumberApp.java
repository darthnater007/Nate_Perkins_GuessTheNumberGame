import java.util.Scanner;

public class GuessTheNumberApp 
{
	
	public static void welcome()
	{
		System.out.println("Welcome, fuck stick! \n"
						 + "This App is going to see if you can guess a random\n"
						 + "number between 1 and 100. \n"
						 + "I'll bet you're too shit for brains to do it! \n"
						 + "Let's begin, ya dumb shit.");    
	}

	public static int generateNumber(int LIMIT)
	{
		int number = (int)(Math.random()*LIMIT) + 1;
		return number;
	}
	
	public static int getInt (Scanner sc, String Prompt)
	{
		int i = 0;
		boolean isValid = false;
		
		while(!isValid) 
		{
			System.out.println(Prompt);
			if (sc.hasNextInt())
			{
				i = sc.nextInt();
				isValid = true;
			}else {
				System.out.println("That's not a number, jackass.  Try Again.");
				sc.nextLine();
				continue;
			}
			sc.nextLine();
		}
		return i;
	}
	
	public static int getIntInRange (Scanner sc , String Prompt, int MIN, int LIMIT)
	{
		int i = 0;
		boolean isValid = false;
		while (!isValid)
		{
			i = getInt(sc, Prompt);
			
			if( i >= MIN && i <= 100)
			{
				isValid = true;
			}else {
				System.out.println("No, dipshit.  BETWEEN 1 AND 100!  GOT IT!?");
				continue;
			}
		}
		
		return i;
	}
	
	public static void checkGuess (int guess, int number)
	{
		if(guess > number && (guess-number)>10){
			System.out.println("Way too high, like your mother must have been \n"
							 + "when you were conceived.");
			
		}else if (guess>number) {
			System.out.println("Too high, you shit bird");
		}else if (guess<number && (number-guess)>10) {
			System.out.println("Too low-- which is something I'm sure you've heard \n"
							 + "about your IQ repeatedly.");
		}else if (guess<number) {
			System.out.println("Too low, bastard face.");
		}
		
	}
	
	public static void main(String[] args) 
	{
		final int LIMIT = 100;
		final int MIN = 1;
		
		Scanner sc = new Scanner(System.in);
		String choice = "Y";
		
		welcome();
		int number = generateNumber(LIMIT);
		
		int count = 1;
		
		while(choice.equalsIgnoreCase("Y")) 
		{
			int guess = getIntInRange(sc, "\nGuess a god damn number:  ", MIN, LIMIT);
			checkGuess(guess, number);
			
			if (guess == number && count <= 3) {
				System.out.println("It only took you " + count + " tries.  So what?  You're \n"
								 + "still a douche bag, and you're still ugly and dumb.");
				break;
			}else if (guess == number && (count > 3 && count <= 7)) {
				System.out.println("Wow.  " + count + " tries.  Completely Average.  I'll bet \n"
						         + "you hear that from all of your lovers.");
				break;
			}else if (guess == number && count > 7) {
				System.out.println("Oh my god.  It took your slow ass " + count + " tries.  Computers \n"
						         + "dont' age. Yet still I have grown old, died, been reborn, and died again \n"
						         + "while waiting for you.  Asshole.");
				break;
			}
			
			count++;
			
		}
		System.out.println("\nLater, Boner");
	}

}
