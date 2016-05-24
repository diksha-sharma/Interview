import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by diksha sharma on 5/18/2016.
 * Problem Statement: Write a method to decide if two strings are anagrams or not.
 */
public class AnagramsCheck
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        if(s1.equals("") && s2.equals(" "))
        {
            System.out.println("Method 1 - anagrams");
        }
        else
        {
            //Method 1 using integer array
            int[] i1 = new int[26];
            int[] i2 = new int[26];
            int j1 = -1;
            int j2 = -1;
            int index = -1;
            for(int i=0; i< s1.length(); i++) //assuming only lower case alphabets, no punctuations and spaces
            {
                if(s1.charAt(i) == ' ')
                {
                    continue;
                }
                index = s1.charAt(i) - 97;
                i1[index] = i1[index] + 1;
                j1++;
            }

            for(int i=0; i< s2.length(); i++) //assuming only lower case alphabets, no punctuations and spaces
            {
                if(s2.charAt(i) == ' ')
                {
                    continue;
                }
                index = s2.charAt(i) - 97;
                i2[index] = i2[index] + 1;
                j2++;
            }

            boolean bAnagrams = true;
            if(j1 != j2)
            {
                System.out.println("Method 1 - not anagrams");
            }
            else
            {
                for(int i=0; i< j1; i++)
                {
                    if(i1[i] != i2[i])
                    {
                        System.out.println("Method 1 - not anagrams");
                        bAnagrams = false;
                        break;
                    }
                }
                if(bAnagrams == true)
                {
                    System.out.println("Method 1 - anagrams");
                }
            }
        }
    }
}
