package excercise3;

public class Main3 {

    public static void printBrand(Car car){
        System.out.println(car.getBrand());
    }

    public static void convertInText(boolean b){
        if(b){
            System.out.println("Sind gleich");
        }
        else{
            System.out.println("Sind nicht gleich");
        }
    }

    public static void main (String[] args){

    Polo racer1 = new Polo();
    Cayenne racer2 = new Cayenne();

    printBrand(racer1);
    printBrand(racer2);

    Golf racer3 = new Golf();
    Golf racer4 = new Golf();

    convertInText(racer1.equals(racer2));
    convertInText(racer1.equals(racer3));
    convertInText(racer2.equals(racer3));
    System.out.println("");
    convertInText(racer1.isEqualModle(racer3));
    convertInText(racer3.isEqualModle(racer4));
    }
}
