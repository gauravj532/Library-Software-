
package booklibrary;


public class FriendBookRecord implements java.io.Serializable{
    public String DOI,BookName;
    int isreturn;
    
    public  FriendBookRecord()
    {
        this("0","0",0);
    }
    public FriendBookRecord(String DOI, String BookName ,int isreturn)
    {
        this.DOI=DOI;
        this.BookName=BookName;
        this.isreturn=isreturn;
    }
    
}
