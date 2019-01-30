package excercise12;

public class Main12 {

    public static void main(String[] args){

        //Aufgabe 1

        MyWrapper wrapper = new MyWrapper("TestText.txt");

        try {
            wrapper.saveString(2, "TestText1");
            wrapper.loadString(2);
        }

        //Aufgabe 2

        catch (MyDatabaseException e){
            System.out.println("");
            System.out.println(e.getMessage());
            System.out.println("-------------------------------------------------------------");
        }


    }
}
