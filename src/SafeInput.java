import java.util.Scanner;

public class SafeInput {

    //Part A getNonZeroLenString
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; //Set this to zero length. Loops until it isn't
        do
        {
            System.out.print("\n" + prompt + ": "); //show prompt add space
            retString = pipe.nextLine();
        } while(retString.length() == 0);

        return retString;
    }

    //Part B getInt
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while(!done);

        return retVal;
    }

    //Part C getDouble
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while(!done);

        return retVal;
    }

    //Part D getRangedInt
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " +retVal);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while(!done);

        return retVal;
    }

    //Part E getRangedDouble
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + "[" + low + "-" + high +"]: ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while(!done);

        return retVal;
    }

    //Part F getYNConfirm
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotAVal = true;
                retVal = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotAVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N] " + response );
            }
        } while(!gotAVal);

        return retVal;
    }

    //Part G getRegExString

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotAVal = true;
            }
            else
            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);;
                System.out.println("Try again!");
            }
        } while(!gotAVal);

        return response;
    }

    //Part H Pretty Header
}
