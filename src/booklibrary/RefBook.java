
package booklibrary;

public class RefBook extends Book implements java.io.Serializable {
  public RefBook()
    {
        this("0","0","0",0,0,0,0,0);
    }
    
    public RefBook(String title, String pbr ,String dop ,int year , int cost,int did,int id,int borrowid)
    {
        this.title=title;
        this.Pbr=pbr;
        this.dop=dop;
        this.year=year;
        this.cost=cost;
        this.did=did;
        this.id=id;
        this.borrowid=borrowid;
    }    
}
