import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/23/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class SetMatrixZeros
{
    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp0 = new ArrayList<>();
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp0.add(1);
        temp0.add(0);
        temp0.add(1);
        temp1.add(1);
        temp1.add(1);
        temp1.add(1);
        al.add(temp0);
        al.add(temp1);

        setZeroes(al);
    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a)
    {
        for(int i=0; i< a.size(); i++)
        {
            for (int j = 0; j < a.get(i).size(); j++)
            {
                System.out.print(a.get(i).get(j) + "  ");
            }
            System.out.println();
        }
        System.out.println();
        ArrayList<String> al = new ArrayList<>();
        String temp;
        for(int i=0; i< a.size(); i++)
        {
            for(int j=0; j< a.get(i).size(); j++)
            {
                if(a.get(i).get(j) == 0)
                {
                    temp = i+ "," + j;
                    al.add(temp);
                }
            }
        }

        StringTokenizer st;
        for(int i=0; i< al.size(); i++)
        {
            st = new StringTokenizer(al.get(i), ",");
            int index1 = Integer.parseInt(st.nextToken());
            int index2 = Integer.parseInt(st.nextToken());

            for(int j=0; j< a.get(index1).size(); j++)
            {
                a.get(index1).set(j,0);
            }

            for(int j=0; j< a.size(); j++)
            {
                a.get(j).set(index2, 0);
            }
        }

        for(int i=0; i< a.size(); i++)
        {
            for (int j = 0; j < a.get(i).size(); j++)
            {
                System.out.print(a.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }
}
