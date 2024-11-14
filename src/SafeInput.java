import java.util.Scanner;

public class SafeInput
{

    /**
     * gets a string from the user using the console, cant be empty
     * @param pipe a Scanner used to get the input
     * @param prompt the prompt that tells the user what to enter
     * @return a String of at least 1 character in length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retVal = "";

        do{
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if(retVal.isEmpty())
                System.out.println("You must enter at least one character!");

        }while(retVal.isEmpty());
        return retVal;
    }

    /**
     * gets an int value from the user at the console with no constraint
     * @param pipe a Scanner used to get the input
     * @param prompt the prompt that tells the user what to enter
     * @return an int of any value
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }
        }while(!done);
        return retVal;
    }

    /**
     * gets a double value from the user at the console with no constraint
     * @param pipe a Scanner used to get the input
     * @param prompt the prompt that tells the user what to enter
     * @return a double of any value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0.0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash + " (A double has a period, so 2.5 is a double)");
            }
        }while(!done);
        return retVal;
    }

    /**
     * Gets an integer from the user via the console within a specified range
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low the inclusive low bound
     * @param high the inclusive high bound
     * @return an int within the specified bounds
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high){
                    done = true;
                }else{
                    System.out.println("You must enter a value within the range [" + low + "-" + high + "]: ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer not " + trash);
            }
        }while(!done);
        return retVal;
    }

    /**
     * Gets a double from the user via the console within a specified range
     * @param pipe the Scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low the inclusive low bound
     * @param high the inclusive high bound
     * @return an double within the specified bounds
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()){
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high){
                    done = true;
                }else{
                    System.out.println("You must enter a value within the range [" + low + "-" + high + "]: ");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }
        }while(!done);
        return retVal;
    }

    /**
     * Gets a Y or N from the user (yes or no) and returns the equivalent true or false
     * @param pipe the Scanner used for input
     * @param prompt tells the user what to enter
     * @return true or false based on Y or N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean done = false;
        String YNResponse ="";

        do{
            System.out.print(prompt + ": ");
            YNResponse = pipe.nextLine();
            if(!YNResponse.matches("[YyNn]"))
                System.out.println("You must enter [Y/N]: ");
            else
            {
                done = true;
                switch (YNResponse)
                {
                    case "Y":
                    case "y":
                        retVal = true;
                        break;
                    case "n":
                    case "N":
                        retVal = false;
                        break;
                }
            }
        }while(!done);
        return retVal;
    }

    /**
     * Prompts the user to input a string that matches a RegEx pattern
     * @param pipe the scanner used
     * @param prompt the message to display as the input text
     * @param regEx the regEx pattern in java string format to use for matching
     * @return
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;

        do {
            System.out.print(prompt + " " + regEx + ": ");
            retVal = pipe.nextLine();
            if (retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("You must enter a matching expression " + regEx + " not " + retVal);
            }
        }while(!done);

        return retVal;
    }

    public static void prettyHeader(String msg)
    {
        int totalWidth = 60;
        int msgLength = msg.length();
        int totalSpaces = totalWidth - 6 - msgLength;
        int leftSpaces = totalSpaces / 2;
        int rightSpaces = totalSpaces - leftSpaces;

        for (int i=0; i<totalWidth; i++)
            System.out.print("*");

        System.out.println();

        System.out.print("***");

        for(int i=0; i<leftSpaces; i++)
            System.out.print(" ");

        System.out.print(msg);

        for(int i=0; i<rightSpaces; i++)
            System.out.print(" ");

        System.out.print("***");

        System.out.println();

        for (int i=0; i<totalWidth; i++)
            System.out.print("*");
    }



}
