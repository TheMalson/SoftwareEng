package exercise2;



public class Car {

    int fuelConsumption;

    public static void main(String[] args){
        System.out.println(FueltypeEnum.SUPER.getDescript() + " " + FueltypeEnum.SUPER.getOctan());
        System.out.println(FueltypeEnum.DIESEL.getDescript() + " " + FueltypeEnum.DIESEL.getOctan());
        System.out.println(FueltypeEnum.NORMAL.getDescript() + " " + FueltypeEnum.NORMAL.getOctan());
    }

}
