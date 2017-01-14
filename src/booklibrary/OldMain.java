package booklibrary;
import java.util.Scanner;
//import java.io.Serializable;
import java.io.*;
import java.io.ObjectInputStream;
//import java.lang.*;

public class OldMain {

  
      
   /* public static void main(String[] args) {
       System.out.println("hello");
       Booklibrary bl =new Booklibrary();
       System.out.println("hello");
       bl.setVisible(true);
       System.out.println("hello");
        
       /* Arrayir data = new Arrayir();
        FriendList fdata = new FriendList(); 
            
   /*     File f2=new File ("record.ser");
        if(f2.exists()&&!f2.isDirectory())
        {
          try
      {
         FileInputStream fileIn = new FileInputStream("record.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         data = (Arrayir) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
          
      {
         i.printStackTrace();
         return;
      }catch(ClassNotFoundException c)
      
      {
        // System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
        } 
        
         File f1=new File ("frecord.ser");
        if(f1.exists()&&!f1.isDirectory())
        {
               try
      {
         FileInputStream fileIn = new FileInputStream("frecord.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         fdata = (FriendList) in.readObject();
         in.close();
         fileIn.close();
      }catch(IOException i)
          
      {
         i.printStackTrace();
         return;
      
      }catch(ClassNotFoundException c)
      
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return;
      }
        }
              
        
    /*   Scanner f= new Scanner(System.in);
       
       System.out.println("Welcome to library.....\n");
       System.out.println("Enter no infront operation which you want to perform");
       System.out.println("1->Create book");
       System.out.println("2->Delete book");
       System.out.println("3->Display book");
       System.out.println("4->Change book to referance");
       System.out.println("5->Search a book");
       System.out.println("6->Find total cost of books in library");
       System.out.println("7->Create friend record");
       System.out.println("8->Delete friend record");
       System.out.println("9->Modify friend record");
       System.out.println("10->Query friend");
       System.out.println("11->Issue book");
       System.out.println("12->Return book");
       System.out.println("13->Query Issued books");
       System.out.println("14->Query book");
       System.out.println("15->Display statistics");
       System.out.println("16->Trace book issue history");
       System.out.println("17->Borrow book from friend");
       System.out.println("18->Return book to friend");
       System.out.println("19->Display all borroed book");
       
       //int a=f.nextInt();
       
    /*while(a!=-1)
    {
      if(a==1)
          data.creatbook();
      else if(a==2)
          data.deleteBook();
      else if(a==3)
          data.displayBook();
      else if(a==4)
          data.changeBookToReferance();
      else if(a==5)
          data.searchBook();
      else if(a==6)
          data.totalCost();
      else if(a==7)
          fdata.creatFriendRecord();
      else if(a==8)
           fdata.delete(data);
      else if(a==9)
         fdata.modify() ;
      else if(a==10)
          fdata.query();
      else if(a==11)
          fdata.issue(data);
      else if(a==12)
          fdata.ReturnBook(data);
      else if(a==13)
          fdata.queryissuedbook(data);
      else if(a==14)
            fdata.querybook(data);  
      else if(a==15)
            fdata.displaystatistics(data); 
      else if(a==16)
              fdata.tracebookissuehistory(data);
      else if(a==17)
          data.borrowbook();
      else if(a==18)
          data.returnBoorowedBook();
      else if(a==19)
          data.displayBorrowedBook();
      else if(a==-1)
          break;
      else
          System.out.println("wrong input //\t input again");
      a=f.nextInt();
      
      
    }
    
    try
      {
         FileOutputStream fileOut =
         new FileOutputStream("record.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(data);
         out.close();
         fileOut.close();
      //   System.out.printf("Serialized data is saved in /tmp/employee.ser");
      }catch(IOException i)
          
      {
          i.printStackTrace();
      }
    try
      {
         FileOutputStream fileOut =
         new FileOutputStream("frecord.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(fdata);
         out.close();
         fileOut.close();
      //   System.out.printf("Serialized data is saved in /tmp/employee.ser");
      }catch(IOException i)
          
      {
          i.printStackTrace();
      }
       
    }*/
    
}
