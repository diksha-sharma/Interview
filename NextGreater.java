import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/23/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/nextgreater/
 */
public class NextGreater
{
    public static void main(String args[])
    {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(4);
        l.add(5);
        l.add(2);
        l.add(10);
        ArrayList<Integer> p = nextGreater(l);
        System.out.println(p.toString());
    }

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> a)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] arr = new int[a.size()];
        for(int i=0; i< arr.length; i++)
        {
            arr[i] = a.get(i);
        }

        boolean bGreater = false;
        for(int i=0; i< arr.length; i++)
        {
            bGreater = false;
            for(int j=(i+1); j< arr.length; j++)
            {
                if(arr[i] < arr[j] && bGreater == false)
                {
                    res.add(arr[j]);
                    bGreater = true;
                }
            }
            if(bGreater == false)
            {
                res.add(-1);
            }
        }
        return res;
    }
}
