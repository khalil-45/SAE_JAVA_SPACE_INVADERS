public class ChainePositionnee{
    int x,y;
    String c;
    public ChainePositionnee(int a,int b, String d){x=a; y=b; c=d;}

    @Override
    public String toString() {
        return "ChainePositionnee{" +
                "x=" + x +
                ", y=" + y +
                ", c='" + c + '\'' +
                '}';
    }
}
