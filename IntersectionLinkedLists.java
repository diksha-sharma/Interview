import java.util.*;
import java.io.*;

/**
 * Created by Diksha Sharma on 5/24/2016.
 * Contact: diksha2207@gmail.com
 * Problem Statement:
 */
public class IntersectionLinkedLists
{
    public static void main(String args[])
    {

        ListNode temp1 = new ListNode(1);
        ListNode temp2 = new ListNode(2);
        temp1.next = temp2;
        ListNode temp3 = new ListNode(3);
        temp2.next = temp3;
        ListNode temp4 = new ListNode(4);
        temp3.next = temp4;
        ListNode temp10 = new ListNode(8);
        temp4.next = temp10;

        ListNode temp5 = new ListNode(2);
        ListNode temp6 = new ListNode(4);
        temp5.next = temp6;
        ListNode temp7 = new ListNode(5);
        temp6.next = temp7;
        ListNode temp8 = new ListNode(7);
        temp7.next = temp8;
        ListNode temp9 = new ListNode(8);
        temp8.next = temp9;

        ListNode res = Intersection(temp1,temp5);
        while(res.next != null)
        {
            System.out.println(res.val);
            res = res.next;
        }
        System.out.println(res.val);
    }

    static class ListNode
    {
        public int val;
        public ListNode next;
        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }
    public static ListNode Intersection(ListNode a, ListNode b)
    {
        ListNode head = null;
        ListNode res = null;
        boolean first = true;
        while(a.next != null && b.next != null)
        {
            if(a.val < b.val)
            {
                a = a.next;
            }
            else if(a.val > b.val)
            {
                b = b.next;
            }
            else
            {
                if(first == true)
                {
                    head = new ListNode(a.val);
                    res = head;
                    first = false;
                }
                else
                {
                    ListNode temp = new ListNode(a.val);
                    head.next = temp;
                    head = head.next;
                }
                a = a.next;
                b = b.next;
            }
        }

        if(a.next != null)
        {
            boolean bAdded = false;
            while(a.next != null)
            {
                if(a.val == b.val)
                {
                    if(first == true)
                    {
                        head = new ListNode(b.val);
                        res = head;
                        first = false;
                    }
                    else
                    {
                        ListNode temp = new ListNode(b.val);
                        head.next = temp;
                        head = head.next;
                    }
                    bAdded = true;
                    break;
                }
                a = a.next;
            }
            if(bAdded == false)
            {
                if(a.val == b.val)
                {
                    if(first == true)
                    {
                        head = new ListNode(b.val);
                        res = head;
                        first = false;
                    }
                    else
                    {
                        ListNode temp = new ListNode(b.val);
                        head.next = temp;
                        head = head.next;
                    }
                }
            }
        }
        else if(b.next != null)
        {
            boolean bAdded = false;
            while(b.next != null)
            {
                if(a.val == b.val)
                {
                    if(first == true)
                    {
                        head = new ListNode(a.val);
                        res = head;
                        first = false;
                    }
                    else
                    {
                        ListNode temp = new ListNode(a.val);
                        head.next = temp;
                        head = head.next;
                    }
                    bAdded = true;
                    break;
                }
                b = b.next;
            }
            if(bAdded == false)
            {
                if(a.val == b.val)
                {
                    if(first == true)
                    {
                        head = new ListNode(a.val);
                        res = head;
                        first = false;
                    }
                    else
                    {
                        ListNode temp = new ListNode(a.val);
                        head.next = temp;
                        head = head.next;
                    }
                }
            }
        }
        return res;
    }
}
