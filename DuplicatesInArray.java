import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/23/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/find-duplicate-in-array/
 */
public class DuplicatesInArray
{
    public static void main(String args[])
    {
        List<Integer> l = new LinkedList<>();
        l.add(3);
        l.add(4);
        l.add(1);
        l.add(4);
        l.add(1);
        System.out.println(repeatedNumber(l));
    }

    public static int repeatedNumber(final List<Integer> a)
    {
        Collections.sort(a);
        int size = a.get(a.size()-1);
        int[] arr = new int[size+1];
        for(int i=0; i< arr.length; i++)
        {
            arr[i] = 0;
        }

        for(int i=0; i< a.size(); i++)
        {
            if(arr[a.get(i)] > 0)
            {
                return a.get(i);
            }
            else
            {
                arr[a.get(i)] = 1;
            }
        }
        return -1;
    }
}
