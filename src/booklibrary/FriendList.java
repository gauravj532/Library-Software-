
package booklibrary;

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;


public class FriendList implements java.io.Serializable {
    
    Friend [] FR = new Friend[1000]; 
    int count=0;
    String delobj;
    Date dt=new Date();
    static Scanner f= new Scanner(System.in);
    
    public  FriendList()
    {
       // System.out.println("inside friendlist");
        for(int i=0;i<1000;i++)
            FR[i] =new Friend();
       // System.out.println("ending friend");
    }
    
    public void creatFriendRecord()
    {
        
        Runnable t1=new Runnable(){
            //thread 1
                public void run(){
                    System.out.println("Name "+FR[count-1].name);
                    System.out.println("Address "+FR[count-1].address);
                 }    
            };
            Thread thr1 = new Thread(t1);
            
            Runnable t2=new Runnable(){
            //thread 2
                public void run(){
                    System.out.println("Mobile no "+FR[count-1].pno1);
                    System.out.println("Landline no "+FR[count-1].pno2);
                 }    
            };
            Thread thr2 = new Thread(t2);
            thr1.start();
            thr2.start();
               System.out.printf("Friend account is succesfully created\tEnter next opraetin or -1 to exit\n");
    }
    
    public void delete(Arrayir data)
    {
        System.out.println("Enter complete name of friend you want to delete");
        delobj=f.nextLine();
        String bk;
        int i,j,k;
        for( i=0;i<count;i++)
        {
            if(delobj.equals(FR[i].name) && FR[i].status!=-1)
            {
                for(j=0;j<FR[i].nBook;j++)
                {
                    bk=FR[i].fbr[j].BookName;
                    for(k=0;k<data.iib;k++)
                    {
                        if(bk.equals(data.IB[k].title))
                        {
                            data.IB[k].isavailabile=1;
                            data.IB[k].bh[data.IB[k].bhi-1].DOR=dt.toString();
                        }
                    }
                }
                FR[i].status=-1;
                break;
            }
                
        }
        if(i==count)
            System.out.println("None friend with this name is registered");
        else 
             System.out.println("Successfully deleted");
        
    }
    
    public void modify()
    {
        System.out.println("Enter name of friend");
        delobj=f.nextLine();
        int i;
        String check;
        for(i=0;i<count;i++)
        {
            if(delobj.equals(FR[i].name) && FR[i].status!=-1)
            {
                System.out.println("Enter modified Address in single line ");
                FR[i].address=f.nextLine();
                System.out.println("Enter modified Land Line no");
                FR[i].pno1=f.nextLine();
                System.out.println("Enter Modified Mobile no");
                FR[i].pno2=f.nextLine();
                break;
            }
        }
        if(i==count)
            System.out.println("None friend with this name is registered\tEnter next opraetin or -1 to exit");
        else
            System.out.println("Successfully Modified\tEnter next opraetin or -1 to exit");
        
    }
                
    public void query()
    {
        System.out.println("Enter substring matching to your friends name whome you want to search");
        delobj=f.nextLine();
        int k=0,i;
        for(i=0;i<count;i++)
        {
            if(FR[i].name.contains(delobj) && FR[i].status!=-1)
            {
                if((k++)==0)
                    System.out.println("Friends matches with your search");
                System.out.println(FR[i].name);
            }
        }
        if(k==0)
             System.out.println("None is found with your search");
        else
            System.out.println("Successfully Displayed\tEnter next opraetin or -1 to exit");
    }
    
    public void issue(Arrayir data)
    {
        System.out.println("Enter name of friend");
        delobj=f.nextLine();
        int i,k=0,l,c=0;
        
        for(i=0;i<count;i++)
        {
            if(delobj.equals(FR[i].name) && FR[i].status!=-1 )
            {
                for(int j=0;j<FR[i].nBook;j++)
                {
                    if(FR[i].fbr[j].isreturn==0)
                    {
                        if((k++)==0)
                            System.out.println("Books Outstanding against"+"  "+FR[i].name+"are-->");
                         System.out.println(FR[i].fbr[j].BookName+"  "+FR[i].fbr[j].DOI);
                    }                    
                }
                
                System.out.println("Enter name of book you want to issue");
                delobj=f.nextLine();
                for(l=0;l<data.iib;l++)
                {
                    if(delobj.equals(data.IB[l].title) && data.IB[l].did==0 && data.IB[l].isavailabile==1)
                    {
                       //  System.out.println(delobj+" "+i+" "+FR[i].nBook+ FR[i].fbr[FR[i].nBook]);
                         FR[i].fbr[FR[i].nBook].BookName=delobj;
                         FR[i].fbr[FR[i].nBook++].DOI=dt.toString();
                         data.IB[l].bh[data.IB[l].bhi].friendname=FR[i].name;
                         data.IB[l].bh[data.IB[l].bhi].DOI=dt.toString();
                         data.IB[l].isavailabile=0;
                         data.IB[l].bhi++;
                         c=1;
                         break;
                    }
                    
                }
                break;
            }
        }
        if(c==0)
            System.out.println("This book is not present in issuable book\tEnter next opraetin or -1 to exit");
        if(c==1)
            System.out.println("Successfully issued\tEnter next opraetin or -1 to exit");
    }
    
    public void ReturnBook(Arrayir data)
    {
        String bname;
        String fd;
        System.out.println("Enter name of book");
        bname=f.nextLine();
        int i,j,k;
        for(i=0;i<data.iib;i++)
        {
            if(bname.equals(data.IB[i].title) && data.IB[i].did==0)
            {
                data.IB[i].bh[data.IB[i].bhi-1].DOR=dt.toString();
                data.IB[i].isavailabile=1;
                fd=data.IB[i].bh[data.IB[i].bhi-1].friendname;
                for(j=0;j<count;j++)
                {
                    if(fd.equals(FR[j].name))
                    {
                        for(k=0;k<FR[j].nBook;k++)
                        {
                            if(bname.equals(FR[j].fbr[k].BookName))
                            {
                                FR[j].fbr[k].isreturn=1;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Successfully returned\tEnter next opraetin or -1 to exit");
    }
    
    public void queryissuedbook(Arrayir data)
    {
        int i,k=0;
        for(i=0;i<data.iib;i++)
        {
            if(data.IB[i].isavailabile==0 && data.IB[i].did==0)
            {
                System.out.println(data.IB[i].title+"  "+data.IB[i].bh[data.IB[i].bhi-1].friendname);
                k++;
            }
        }
        if(k==0)
            System.out.println("None of the book is issued\nEnter next operation or -1 to exit");
        else
            System.out.println("Successfully Displayed\nEnter next operation or -1 to exit");
    }
    
    public void querybook(Arrayir data)
    {
        System.out.println("Enter name of book");
        delobj=f.nextLine();
        int i;
        for(i=0;i<data.iib;i++)
        {
            if(data.IB[i].isavailabile==0 && data.IB[i].did==0 && (delobj.equals(data.IB[i].title)))
            {
                System.out.println(data.IB[i].bh[data.IB[i].bhi-1].friendname+" "+data.IB[i].bh[data.IB[i].bhi-1].DOI);
                break;
            }
        }
        if(i==data.iib)
            System.out.println("Book is not issued");
        else
            System.out.println("Successfully Displayed");
    }
    
    public void displaystatistics(Arrayir data)
    {
        int i;
        for(i=0;i<data.iib;i++)
        {
            if(data.IB[i].did==0)
            System.out.println(data.IB[i].title +"  "+data.IB[i].bhi);
        }
        System.out.println("Successfully Displayed\nEnter next operation or -1 to exit");
    }
    
    public void tracebookissuehistory(Arrayir data)
    {
            int i,j;
            System.out.println("Enter book name");
            delobj=f.nextLine();
            for(i=0;i<data.iib;i++)
            {
                if(delobj.equals(data.IB[i].title))
                {
                    System.out.printf("name\t\tDate of issue\t\tDate of return\n");
                    for(j=0;j<data.IB[i].bhi-1;j++)
                    {
                        System.out.println(data.IB[i].bh[j].friendname+" "+data.IB[i].bh[j].DOI+" "+data.IB[i].bh[j].DOR);
                    }
                    
                    if(data.IB[i].isavailabile==0)
                        System.out.println(data.IB[i].bh[j].friendname+"  "+ data.IB[i].bh[j].DOI+" "+"This book is not returned yet");
                    else
                        System.out.println(data.IB[i].bh[j].friendname+" "+data.IB[i].bh[j].DOI+" " +data.IB[i].bh[j].DOR);
                }
            }
           System.out.println("Successfully Displayed\nEnter next operation or -1 to exit");
    }
}

