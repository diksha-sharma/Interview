import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/23/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/median-of-array/
 */
public class ArrayMedian
{
    public static void main(String args[])
    {
        List<Integer> l1 = new LinkedList<>();
        //A : [ -49, 33, 35, 42 ]
        //B : [ -26 ]
        l1.add(-49);
        l1.add(33);
        l1.add(35);
        l1.add(42);
        List<Integer> l2 = new LinkedList<>();
        l2.add(-26);

        System.out.println(findMedianSortedArrays(l1, l2));
    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b)
    {
        if(a.size() > 0 && b.size() > 0)
        {
            int totalLength = a.size() + b.size();
            List<Integer> l = new LinkedList<>();
            int i=0;
            int j=0;
            while(i < a.size() && j < b.size())
            {
                if(l.size() > (totalLength/2))
                {
                    break;
                }
                if(a.get(i) < b.get(j))
                {
                    l.add(a.get(i));
                    i++;
                }
                else if (a.get(i) > b.get(j))
                {
                    l.add(b.get(j));
                    j++;
                }
                else
                {
                    l.add(a.get(i));
                    l.add(b.get(j));
                    i++;
                    j++;
                }
            }

            if(l.size() < (totalLength/2 + 1))
            {
                if(i< a.size())
                {
                    while(i< a.size())
                    {
                        l.add(a.get(i));
                        i++;
                    }
                }

                if(j< b.size())
                {
                    while(j< b.size())
                    {
                        l.add(b.get(j));
                        j++;
                    }
                }
            }
            /*for(int f=0; f< l.size(); f++)
            {
                System.out.println(l.get(f));
            }*/

            if(totalLength%2 == 0)
            {
                int index = totalLength/2;
                double median = (double)(l.get(index) + l.get(index-1))/2.0;
                return median;
            }
            else
            {
                int index = totalLength/2;
                double median = (double)(l.get(index));
                return median;
            }
        }
        else if(a.size() == 0 && b.size()> 0)
        {
            int totalLength = b.size();
            if(totalLength%2 == 0)
            {
                int index = totalLength/2;
                double median = (double)(b.get(index) + b.get(index-1))/2.0;
                return median;
            }
            else
            {
                int index = totalLength/2;
                double median = (double)(b.get(index));
                return median;
            }
        }
        else if(b.size() == 0 && a.size()> 0)
        {
            int totalLength = a.size();
            if(totalLength%2 == 0)
            {
                int index = totalLength/2;
                double median = (double)(a.get(index) + a.get(index-1))/2.0;
                return median;
            }
            else
            {
                int index = totalLength/2;
                double median = (double)(a.get(index));
                return median;
            }
        }

        return (double) 0.0;
    }
}
