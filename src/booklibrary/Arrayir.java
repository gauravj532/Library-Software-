package booklibrary;
import java.util.Date;
import java.util.Scanner;

public class Arrayir implements java.io.Serializable {
    
    IssueBook[] IB = new IssueBook[1000];
    RefBook [] RB = new RefBook[1000];
    BorrowBook[] BB = new BorrowBook[1000];
    
    public int iib=0,irb=0,tcost=0,nbb;
    String newbook;
    static Scanner f= new Scanner(System.in);
    Date dt=new Date();
    
    public Arrayir()
    {
        for(int i=0;i<1000;i++)
        {
            IB[i]=new IssueBook();
            RB[i]=new RefBook();
            BB[i]=new BorrowBook();
        }
    }

    public void creatbook(String title,String dop,int year,int cost,String pbr,int b)
    {
       
        if(b==1)
        {
            
            
            IB[iib].title=title;  
            IB[iib].year=year;
            IB[iib].dop=dop;
            IB[iib].cost=cost;
            tcost+=IB[iib].cost;
            IB[iib].Pbr=pbr;
            IB[iib].id=(iib)+irb+1;
            iib++;
        }   
        
        else 
        {
            RB[irb].title=title;  
            RB[irb].year=year;
            RB[irb].dop=dop;
            RB[irb].cost=cost;
            tcost+=IB[irb].cost;
            RB[irb].Pbr=pbr;
            RB[irb].id=(iib)+irb+1;
            irb++;
        }
         
    }
    
    public void totalCost()
    {
  
        System.out.printf("Total cost is--> %d \n", tcost);
        System.out.println("Enter next operation or -1 to exit");
    }
    
    public String deleteBook(String newbook)
    {
        //System.out.println("Enter name of book which you want to delete...");
       // f.nextLine();
        
        int k=0,p=0;
        for(int i=0;i<iib;i++)
        {
            if(newbook.equals(IB[i].title) && IB[i].did==0)
            {
                if(IB[i].isavailabile==0)
                {
                    p++;
                   return "You cant delete this book it is issued to someone";
                    
                }
                else
                {
                    IB[i].did=1;
                    IB[i].isavailabile=0;
                    tcost-=IB[i].cost;
                    k++;
                    break;
                }
            }    
        }
        for(int i=0;i<irb;i++)
        {
             if(newbook.equals(RB[i].title) && RB[i].did==0 )
            {
               
                if(RB[i].borrowid==1)
                {
                    p=1;
                    return "You cant delete this book it is borrowed one\nEnter next operation or -1 to exit";
                    
                }
                else
                {
                    RB[i].did=1;
                    tcost-=RB[i].cost;
                    k++;
                    break;
                }
            }    
        }
        if(p==0)
        {
        if(k==0)
          return "Book not found\nEnter next operation or -1 to exit";
        else 
           return "Successfully Deleted\nEnter next opration or -1 to exit";
        }
        return null;
        
    }
    
    public void displayBook()
    {
        int k=0,m=0;
        for(int i=0;i<iib;i++)
        {
            if(IB[i].did==0)
            {
                if((k++)==0)
                    System.out.println("Isuuable book in library....");
                System.out.println(IB[i].title);
            }
        }
        
        for(int i=0;i<irb;i++)
        {
            if(RB[i].did==0)
            {
                if((m++)==0 )
                    System.out.println("Referance book in library.....");
                System.out.println(RB[i].title);
            }
        }
        if(k==0 && m==0)
            System.out.println("No book is present in library\nEnter next operation or -1 to exit");
        else
            System.out.println("Successfully Displayed\nEnter next operation or -1 to exit");
    }
    
    public void changeBookToReferance()
    {
        int i;
        System.out.println("Enter name of book which you want to change...");
       // f.nextLine();
        newbook=f.nextLine();
        for( i=0;i<iib;i++)
        {
            if( newbook.equals(IB[i].title) && (IB[i].did==0) && IB[i].isavailabile==1)
            {
                IB[i].did=1;
                IB[i].isavailabile=0;
                break;
            }
        }
        
        if(i==iib)
            System.out.println("This book is not available in Issuable book");
        else
        {
            RB[irb].title=IB[i].title;
            RB[irb].year=IB[i].year;
            RB[irb].dop=IB[i].dop;
            RB[irb].cost=IB[i].cost;
            RB[irb].Pbr=IB[i].Pbr;        
            RB[irb].id=IB[i].id;
            irb++;
            System.out.println("Successfully changed \nEnter next opration or -1 to exit");

        }
            
    }
    
    public void searchBook()
    {
        int k=0;
        System.out.println("Enter text to search...");
       // f.nextLine();
        newbook=f.nextLine();
        for(int i=0;i<iib;i++)
        {
            if(IB[i].title.contains(newbook)==true  && IB[i].did!=1)
            {
                if(k==0)
                {
                    System.out.println("Issuable Book matched with your search");
                    k++;
                }
                System.out.println(IB[i].title);
            }
        }
        int m=0;
        for(int i=0;i<irb;i++)
        {
            if(RB[i].title.contains(newbook)==true && RB[i].did!=1)
            {
                if(m==0)
                {
                     System.out.println("Referance Book matched with your search");
                     m++;
                }
                 System.out.println(RB[i].title);
            }
                
        }
        if(k==0 && m==0)
            System.out.println("No book with your search found");
        
        System.out.println("Enter next opration or -1");
       
    }
    
    public void borrowbook(String bname,String fname,int y,int c,String pb)
    {
       
        //System.out.println("Enter name of friend from which you want to borrow book");
        BB[nbb].friendname=fname;
       // System.out.println("Enter title of book you want to borrow");
        BB[nbb].title=bname;
        BB[nbb].DOB=dt.toString();
        
        //creating this book in referance
            RB[irb].title=BB[nbb].title;
            //System.out.println("Enter Year of publication");
            RB[irb].year=y;
           // System.out.println("Enter Price");
            
            RB[irb].cost=c;
          //  f.nextLine();
            tcost+=RB[irb].cost;
            
            //System.out.println("Enter Publisher");
            RB[irb].Pbr=pb;
            
            RB[irb].dop=dt.toString();
            RB[irb].borrowid=1;
            RB[irb].id=iib+(irb)+1;
            irb++;
            nbb++;
            
          //  System.out.println("Successfully Borrowed\nEnter next opration or -1 to exit");
        
    }
    
    public void returnBoorowedBook()
    {
        String bname,fname;
        int k=0;
        System.out.println("Enter title of book you wnat to return");
        bname=f.nextLine();
        System.out.println("Enter name of friend from whome you borrowed book");
        fname=f.nextLine();
        
        for(int i=0;i<nbb;i++)
        {
            if(bname.equals(BB[i].title))
            {
                if(fname.equals(BB[i].friendname))
                        {
                            
                            
                            for(int j=0;j<irb;j++)
                            {
                                if(bname.equals(RB[j].title))
                                {
                                     RB[j].did=1;
                                     tcost-=RB[j].cost;
                                     k++;
                                     break;
                                }
                            }
                            BB[i].DOR=dt.toString();
                            BB[i].isreturn=1;
                            break;
                        }
            }
        }
        if(k==0)
            System.out.println("This book is either not borrowed or borrowed by  some other friend \nEnter next opration or -1 to exit ");
        else
            System.out.println("Succesfully returned\n Enter next opration or -1 to exit");
        
    }
    
    public void displayBorrowedBook()
    {
       
        int j=1;
         System.out.println("Borrowed Book which is reurned");
         for(int i=0;i<nbb;i++)
            if(BB[i].isreturn==1)
                System.out.println("Sr no "+(j++) +"\n" +"Name of book -> " + BB[i].title +"\nName of friend -> "+BB[i].friendname+"\nDate of borrowed -> "+BB[i].DOB +"\nDate of return -> "+BB[i].DOR +"\n");
          j=1;
          System.out.println();
         System.out.println("Borrowed Book which is still in library");
       
         for(int i=0;i<nbb;i++)
            if(BB[i].isreturn==0)
                System.out.println("Sr no "+(j++) +"\n" +"Name of book -> " + BB[i].title +"\nName of friend -> "+BB[i].friendname+"\nDate of borrowed -> "+BB[i].DOB +"\n ");
        
        System.out.println("Successfully Displayed \n Enter next opration or -1 to exit");
        
    }
}
