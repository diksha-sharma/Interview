import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/24/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence
{
    public static void main(String args[])
    {
        List<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(1);
        l.add(2);
        l.add(2);
        l.add(3);
        l.add(3);
        l.add(4);
        l.add(4);
        l.add(5);
        l.add(5);
        int res = longestConsecutive(l);
        System.out.println(res);
    }

    public static int longestConsecutive(final List<Integer> a)
    {
        int[] arr = new int[a.size()];
        Collections.sort(a);
        int g=0;
        arr[0] = a.get(0);
        //System.out.println("arr[g]: " + arr[g]);
        g++;
        for (int i = 1; i < a.size(); i++)
        {
            if(a.get(i) == a.get(i-1))
            {
                continue;
            }
            else
            {
                arr[g] = a.get(i);
                //System.out.println("arr[g]: " + arr[g]);
                g++;
            }
        }
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < arr.length-1; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            //System.out.println("Processing arr[i]: " + arr[i]);
            if((arr[i]+1) == arr[i+1])
            {
                while((i< arr.length-1) && (arr[i]+1) == arr[i+1])
                {
                    temp.add(arr[i]);
                    //System.out.println("Added to temp: " + arr[i]);
                    i++;
                }
                temp.add(arr[i]);
                //System.out.println("Added to temp: " + arr[i]);
                if(temp.size() > 0)
                {
                    //System.out.println("Added to al: " + temp.toString());
                    al.add(temp);
                }
            }
        }

        int minLength = 1;
        if(al.size() > 0)
        {
            for(int k=0; k < al.size(); k++)
            {
                if(al.get(k).size() > minLength)
                {
                    minLength = al.get(k).size();
                }
            }
        }

        return minLength;
    }
}
