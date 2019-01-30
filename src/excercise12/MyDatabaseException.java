package excercise12;

public class MyDatabaseException extends Exception{

    MyDatabaseException (){

    }

    @Override
    public String getMessage(){
        return "!!!!!!!!!!!Jetzt geht gar nix mehr!!!!!!!!!!!!";
    }
}
