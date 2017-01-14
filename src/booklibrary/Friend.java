
package booklibrary;

public class Friend implements java.io.Serializable{
    public String name,address,pno1,pno2;
    public int status,nBook;
    FriendBookRecord [] fbr=new FriendBookRecord [100];
    
    public  Friend()
    {
        this("0","0","0","0",0,0);
       
    }
    
    public  Friend (String name,String address,String pno1,String pno2,int status ,int nBook)
    {
        this.name=name;
        this.address=address;
        this.pno1=pno1;
        this.pno2=pno2;
        this.status=status;
        this.nBook=nBook;
        for(int i=0;i<100;i++)
           fbr[i]=new FriendBookRecord();
    }
}
