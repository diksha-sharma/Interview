import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/24/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/colorful-number/
 */
public class ColorfulNumber
{
    public static void main(String args[])
    {
        System.out.println(colorful(123));
    }

    public static int colorful(int a)
    {
        ArrayList<Integer> al = new ArrayList<>();
        String s = String.valueOf(a);
        for(int i=0; i< s.length(); i++)
        {
            int temp = 1;
            for(int k=i; k< s.length(); k++)
            {
                temp = temp * Integer.parseInt(String.valueOf(s.charAt(k)));
                //System.out.println(temp);
                al.add(temp);
            }
        }
        Collections.sort(al);

        for(int i=0; i< al.size()-1; i++)
        {
            if(al.get(i) == al.get(i+1))
            {
                return 0;
            }
        }
        return 1;
    }
}
