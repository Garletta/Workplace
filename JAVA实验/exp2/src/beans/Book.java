package beans;

public class Book {

    private String BOOKID;
    private String BOOKNAME;
    private double BOOKPRICE;

    public String getBOOKID() {
        return BOOKID;
    }

    public void setBOOKID(String BOOKID) {
        this.BOOKID = BOOKID;
    }

    public String getBOOKNAME() {
        return BOOKNAME;
    }

    public void setBOOKNAME(String BOOKNAME) {
        this.BOOKNAME = BOOKNAME;
    }

    public double getBOOKPRICE() {
        return BOOKPRICE;
    }

    public void setBOOKPRICE(double BOOKPRICE) {
        this.BOOKPRICE = BOOKPRICE;
    }
}
