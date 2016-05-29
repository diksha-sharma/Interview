import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/24/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
 }
 */
public class Anagrams
{
    public static void main(String args[])
    {
        ArrayList<String> l = new ArrayList<String>();
        /*l.add("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba");
        l.add("abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa");
        l.add("babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab");
        l.add("bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb");
        l.add("abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab");
        l.add("aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba");
        l.add("abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa");
        l.add("aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb");*/

        /*l.add("caat");
        l.add("taac");
        l.add("dog");
        l.add("god");
        l.add("acta");*/

        l.add("abcd");
        l.add("dcba");
        l.add("dcba");
        l.add("abcd");
        l.add("abcd");
        l.add("adbc");
        l.add("dabc");
        l.add("adcb");

        ArrayList<ArrayList<Integer>> p = anagrams(l);
        for(int i=0; i< p.size(); i++)
        {
            for(int j=0; j< p.get(i).size(); j++)
            {
                System.out.print(p.get(i).get(j) + "  ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a)
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int[] processedIndex = new int[56];
        int h=-1;
        int[][] arr = new int[a.size()][26];
        int index = -1;
        for(int i=0; i< a.size(); i++)
        {
            for(int j=0; j< a.get(i).length(); j++)
            {
                index = a.get(i).charAt(j) - 97;
                arr[i][index] = arr[i][index] + 1;
            }
        }
        boolean bMatch = true;
        boolean bUnique = true;
        for(int i=0; i< arr.length; i++)
        {
            bUnique = true;
            for (int k = i+1; k < arr.length; k++)
            {
                bMatch = true;
                for (int j = 0; j < 26; j++)
                {
                    if(arr[i][j] != arr[k][j])
                    {
                        bMatch = false;
                        break;
                    }
                }
                if(bMatch == true)
                {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(k);
                    h++;
                    System.out.println("h: " + h);
                    processedIndex[h] = i;
                    h++;
                    System.out.println("h: " + h);
                    processedIndex[h] = k;
                    res.add(temp);
                    bUnique = false;
                }
            }
            if(bUnique == true)
            {
                boolean bAdded = false;
                for(int m=0; m <= h; m++)
                {
                    if(i == processedIndex[m])
                    {
                        bAdded = true;
                        break;
                    }
                }
                if(bAdded == false)
                {
                    h++;
                    processedIndex[h] = i;
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    res.add(temp);
                }
            }
        }
        for(int i=0; i<= h; i++)
        {
            processedIndex[i] = -1;
        }
        h=0;

        for(int i=0; i< res.size(); i++)
        {
            //System.out.println("i: " + i);
            for(int k=i+1; k < res.size(); k++)
            {
                //System.out.println("k: " + k);
                for(int j=0; j< res.get(i).size(); j++)
                {
                    //System.out.println("j: " + j);
                    if(res.get(k).contains(res.get(i).get(j)))
                    {
                        //System.out.println("Found: ");
                        boolean bDone = false;
                        for(int f=0; f<= h; f++)
                        {
                            if(processedIndex[f] == k)
                            {
                                bDone = true;
                            }
                        }
                        if(bDone == false)
                        {
                            processedIndex[h] = k;
                            //System.out.println("Added k: " + k);
                        }

                        for(int l=0; l< res.get(k).size(); l++)
                        {
                            if(!res.get(i).contains(res.get(k).get(l)))
                            {
                                res.get(i).add(res.get(k).get(l));
                            }
                        }
                        Collections.sort(res.get(i));
                        //System.out.println("Sorted: " + res.get(i).toString());
                    }
                }
            }
        }
        for(int i=0; i< res.size()-1; i++)
        {
            if(res.get(i).equals(res.get(i+1)))
            {
                res.remove(i);
                for(int j=0; j< res.get(i).size(); j++)
                {
                    int val = res.get(i).get(j) +1 ;
                    res.get(i).set(j, val);
                }
            }
            else
            {
                for(int j=0; j< res.get(i).size(); j++)
                {
                    int val = res.get(i).get(j) +1;
                    res.get(i).set(j, val);
                }
            }
        }
        int i= res.size()-1;
        for(int j=0; j< res.get(i).size(); j++)
        {
            int val = res.get(i).get(j) +1;
            res.get(i).set(j, val);
        }

        return res;
    }

}
