package types.hierarchial_Inheritance.example;

public class A extends Box{
    double price;

    public A(){
        super();
        this.price = -1;
    }

    public A(double price){
        super();
        this.price = price;
    }

    public A(A other){
        super(other);
        this.price = other.price;
    }

    public A(double l, double w, double h, double price){
        super(l,w,h);
        this.price = price;
    }

}
