import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/24/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/first-missing-integer/
 */
public class FirstMissingInteger
{
    public static void main(String args[])
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        /*l.add(-8);
        l.add(-7);
        l.add(-6);*/

        /*l.add(3);
        l.add(4);
        l.add(-1);
        l.add(1);*/

        l.add(1);
        l.add(2);
        l.add(0);
        System.out.println(firstMissingPositive(l));
    }

    public static int firstMissingPositive(ArrayList<Integer> a)
    {
        int res = -1;
        int temp = 1;
        Collections.sort(a);
        for(int i=0; i< a.size(); i++)
        {
            if(a.get(i) > 0 && a.get(i) != temp)
            {
                return temp;
            }
            else if(a.get(i) > 0 && a.get(i) == temp)
            {
                temp++;
            }
        }
        return temp;
    }
}
