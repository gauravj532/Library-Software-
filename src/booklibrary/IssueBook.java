package booklibrary;

public class IssueBook extends Book implements java.io.Serializable  {
    
    HistoryOfBook []bh=new HistoryOfBook[100];
    int bhi,isavailabile;
    public IssueBook()
    {
        this("0","0","0",0,0,0,0,0,1,0);
    }
    
    public IssueBook(String title, String pbr ,String dop ,int year , int cost,int did, int id,int bhi,int isavailable,int borrowid)
    {
        this.title=title;
        this.Pbr=pbr;
        this.dop=dop;
        this.year=year;
        this.cost=cost;
        this.did=did;
        this.id=id;
        this.bhi=bhi;
        this.isavailabile=isavailable;
        this.borrowid=borrowid;
        for(int i=0;i<100;i++)
            bh[i]=new HistoryOfBook();
    }
}
