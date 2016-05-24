import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by diksha sharma on 5/18/2016.
 * Problem Statement: Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class UniqueCharacterString
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean bUnique = true;
        //Method 1 using HashMap
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i=0; i< input.length(); i++)
        {
            //ignoring spaces
            if(input.charAt(i) == ' ')
            {
                continue;
            }
            if(hm.containsKey(input.charAt(i)))
            {
                System.out.println("Method 1 - Not all unique characters...");
                bUnique = false;
                break;
            }
            else
            {
                hm.put(input.charAt(i), 1);
            }
        }
        if(bUnique == true)
        {
            System.out.println("Method 1 - All unique characters...");
        }

        //Method 2 using boolean array
        bUnique = true;
        boolean[] bl = new boolean[26]; //assuming all lower case alphabets - should be changed based on input size
        for(int i=0; i< bl.length; i++)
        {
            bl[i] = false; //initialize the array elements to false
        }
        int j = -1;
        for(int i=0; i< input.length(); i++)
        {
            //ignoring spaces
            if(input.charAt(i) == ' ')
            {
                continue;
            }
            j = input.charAt(i) - 97;
            if(bl[j] == true)
            {
                System.out.println("Method 2 - Not all unique characters...");
                bUnique = false;
                break;
            }
            else
            {
                bl[j] = true;
            }
        }
        if(bUnique == true)
        {
            System.out.println("Method 2 - All unique characters...");
        }

        //Method 3 no additional data structure - Naive method
        char c;
        bUnique = true;
        for(int i=0; i< input.length(); i++)
        {
            //ignoring spaces
            if(input.charAt(i) == ' ')
            {
                continue;
            }
            c = input.charAt(i);
            if(input.substring(i+1).contains(String.valueOf(c)))
            {
                System.out.println("Method 3 - Not all unique characters...");
                bUnique = false;
                break;
            }
        }
        if(bUnique == true)
        {
            System.out.println("Method 3 - All unique characters...");
        }

        //Method 4 using index of first and last occurence of each character in input string
        bUnique = true;
        char[] ca = input.toCharArray();
        int firstIndex = -1;
        int lastIndex = -1;
        for(int i=0; i< input.length(); i++)
        {
            //ignoring spaces
            if(input.charAt(i) == ' ')
            {
                continue;
            }
            firstIndex = input.indexOf(input.charAt(i));
            lastIndex = input.lastIndexOf(input.charAt(i));
            if(firstIndex != lastIndex)
            {
                System.out.println("Method 4 - Not all unique characters...");
                bUnique = false;
                break;
            }
        }
        if(bUnique == true)
        {
            System.out.println("Method 4 - All unique characters...");
        }

        //Method 5 using an integer's bits to check what characters have been seen - No additional data structure used
        //Best approach from Cracking the coding interview book
        //Explanation found on: http://stackoverflow.com/questions/19484406/detecting-if-a-string-has-unique-characters-comparing-my-solution-to-cracking
        int checker = 0;
        bUnique = true;
        if(input.length() > 26) //assuming all lower case alphabets and no punctuations or spaces
        {
            System.out.println("Method 5 - Not all unique characters...");
            bUnique = false;
        }
        else
        {
            int index = -1;
            for(int i=0; i< input.length(); i++)
            {
                //ignoring spaces
                if(input.charAt(i) == ' ')
                {
                    continue;
                }
                index = input.charAt(i) - 97;
                if((checker & (1 << index)) > 0)
                {
                    System.out.println("Method 4 - Not all unique characters...");
                    bUnique = false;
                    break;
                }
                else
                {
                    checker  = checker | (1 << index);
                }
            }
            if(bUnique == true)
            {
                System.out.println("Method 5 - All unique characters...");
            }
        }
    }
}
