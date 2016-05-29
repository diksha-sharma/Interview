import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/29/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/valid-sudoku/
 */
public class ValidSudoku
{
    public static void main(String args[])
    {
        List<String> l = new ArrayList<>();
        l.add("53..7....");
        l.add("6..195...");
        l.add(".98....6.");
        l.add("8...6...3");
        l.add("4..8.3..1");
        l.add("7...2...6");
        l.add(".6....28.");
        l.add("...419..5");
        l.add("....8..79");
        System.out.println(isValidSudoku(l));
    }
    public static int isValidSudoku(final List<String> a)
    {
        int iValid = 0;
        char[][] arr = new char[10][10];

        for(int i=1; i< 10; i++)
        {
            for(int j=1; j< 10; j++)
            {
                arr[i][j] = a.get(i-1).charAt(j-1);
                //System.out.print(arr[i][j] + " ");
            }
            //System.out.println();
        }

        //Checking for rows
        boolean bValid = true;
        boolean[] check1 = new boolean[10];
        for(int i=1; i< 10; i++)
        {
            for(int k=1; k< 10; k++)
            {
                check1[k] = false;
            }
            for (int j = 1; j < 10; j++)
            {
                if(arr[i][j] != '.')
                {
                    int index = arr[i][j] - 48;
                    if(check1[index] == false)
                    {
                        check1[index] = true;
                    }
                    else
                    {
                        bValid = false;
                        break;
                    }
                }
            }

            if(bValid == false)
            {
                break;
            }
        }

        //Checking for columns
        boolean[][] check2 = new boolean[1][10];
        for(int i=1; i< 10; i++)
        {
            for (int k = 1; k < 10; k++)
            {
                check2[0][k] = false;
            }
            for (int j = 1; j < 10; j++)
            {
                if(arr[j][i] != '.')
                {
                    int index = arr[j][i] - 48;
                    if(check2[0][index] == false)
                    {
                        check2[0][index] = true;
                    }
                    else
                    {
                        bValid = false;
                        break;
                    }
                }
            }

            if(bValid == false)
            {
                break;
            }
        }

        //Checking for sub boxes
        boolean[] check3 = new boolean[10];
        for(int i=1; i< 10; i=i+3)
        {
            for(int j = 1; j < 4; j++)
            {
                //System.out.println("j: " + j);
                int colIndex = 0;
                if(j == 1)
                {
                    colIndex = 1;
                }
                else if(j == 2)
                {
                    colIndex = 4;
                }
                else if(j == 3)
                {
                    colIndex = 7;
                }

                for(int k=1; k < 10; k++)
                {
                    check3[k] = false;
                }
                //System.out.println();
                int rowIndex = i;
                for(int l = rowIndex; l < rowIndex+3; l++)
                {
                    for(int k = colIndex; k < colIndex+3; k++)
                    {
                        //System.out.println("Index: " + l+k);
                        if(arr[l][k] != '.')
                        {
                            int index = arr[l][k] - 48;
                            //System.out.println(arr[l][k]);
                            if(check3[index] == false)
                            {
                                check3[index] = true;
                            }
                            else
                            {
                                bValid = false;
                                break;
                            }
                        }
                    }
                }
            }
        }

        if(bValid == false)
        {
            iValid = 0;
        }
        else
        {
            iValid = 1;
        }
        return iValid;
    }
}
