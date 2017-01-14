
package booklibrary;


public class BorrowBook implements java.io.Serializable {
    public String title,DOB,DOR,friendname;
    int isreturn;
    
    public BorrowBook()
    {
        title="0";
        DOB="0";
        DOR="0";
        friendname="0";
        isreturn=0;
    }
    
}
