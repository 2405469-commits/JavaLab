package Lab2;

public class ObjCount {
    static int count=0;
    static int len,bre,hei;
    static int vol;
    ObjCount(int l,int b,int h)
    {
        len=l;
        bre=b;
        hei=h;
        vol=len*bre*hei;
        count++;
    }
    ObjCount(int l)
    {
        len=l;
        vol=l*l*l;
        count++;
    }
    ObjCount()
    {
        len=10;
        bre=12;
        hei=5;
        vol=len*bre*hei;
        count++;
    }


    public static void main(String[] args){

        ObjCount o1=new ObjCount();
        ObjCount o5=new ObjCount();
        ObjCount o6=new ObjCount();

        ObjCount o2=new ObjCount(5,12,20);
        ObjCount o3=new ObjCount(5);
        System.out.println("No of objects made:"+count);
    }
}
