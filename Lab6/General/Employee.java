package Lab6.General;
//empid(protected), ename(private) and a public method as earnings() which calculate total earnings as
//earnings         basic + DA (80% of basic) + HRA (15% of basic)

public class Employee {
    public double bs,DA,HRA;
    protected int empid;
    private int ename;

    public Employee(double bs){
        this.bs=bs;
        DA=bs*0.8;
        HRA=bs*0.15;
    }
    public double earnings(){
        double earning=bs+DA+HRA;
        return earning;
    }
}
