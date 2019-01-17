package excercise12;

public class Main12 {

    public static void main(String[] args){

        //Aufgabe 1

        MyWrapper wrapper = new MyWrapper("textfile.txt");

        try {
            wrapper.saveString(2, "TestText1");
            wrapper.loadString(2);
        }

        //Aufgabe 2
        catch (MyDatabaseException e){
            e.getMessage();
        }


    }
}
