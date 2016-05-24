import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/23/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement: https://www.interviewbit.com/problems/generate-all-parentheses/
 */
public class ParanthesisMatch
{
    public static void main(String args[])
    {
        System.out.println(isValid("[{"));
    }

    public static int isValid(String a)
    {
        String s = a;
        char c;
        Stack<Character> st = new Stack<>();
        boolean bValid = true;
        for(int i=0; i< s.length(); i++)
        {
            c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(')
            {
                st.push(c);
            }
            else if( c=='}')
            {
                if(st.size() >= 1)
                {
                    char top = st.pop();
                    if(top != '{')
                    {
                        bValid = false;
                        break;
                    }
                }
                else
                {
                    bValid = false;
                    break;
                }
            }
            else if( c ==']')
            {
                if(st.size() >= 1)
                {
                    char top = st.pop();
                    if(top != '[')
                    {
                        bValid = false;
                        break;
                    }
                }
                else
                {
                    bValid = false;
                    break;
                }
            }
            else if( c ==')')
            {
                if(st.size() >= 1)
                {                    char top = st.pop();
                    if(top != '(')
                    {
                        bValid = false;
                        break;
                    }
                }
                else
                {
                    bValid = false;
                    break;
                }
            }
        }

        if(st.size() > 0)
        {
            bValid = false;
        }

        if(bValid == true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
