package excercise12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class MyWrapper implements IDatabaseWrapper {

    UnreliableDatabase db;
    int count=0;

    MyWrapper (String filename){
        wrap(filename);
    }


    public void wrap (String filename){

        try {
            db = new UnreliableDatabase(filename);
            System.out.println("-------------------------------------------------------------");
            System.out.println("Datei erfolgreich geladen");
            System.out.println("");
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Die Datei " + filename + " konnte nicht gefunden werden");
            System.out.println("Bitte Dateiname neu eingeben");
            Scanner s = new Scanner(System.in);
            String newFilename = s.next();
            wrap(newFilename);
            s.close();
        }

    }

    @Override
    public void saveString(int key, String value) throws MyDatabaseException {

        if(count>1){
            throw new MyDatabaseException();
        }

        try{
            db.saveString(key,value);
            System.out.println("Speichern erfolgreich");
            System.out.println("");
        }
        catch (IOException ioexception){
            System.out.println(ioexception.getMessage());
            System.out.println("Achtung IO!!!");
            count++;
        }
        catch (UnreliableDatabase.UnreliabilityException unRelExeption){
            System.out.println(unRelExeption.getMessage());
            System.out.println("Die Save Methode sollte zuverlässiger gemacht werden!");
            count++;
            this.saveString(key,value);
        }


    }

    @Override
    public Optional<String> loadString(int key) throws MyDatabaseException {

        if(count>1){
            throw new MyDatabaseException();
        }

        try{
           db.loadString(key);
           System.out.println("Laden erfolgreich");
           System.out.println("-------------------------------------------------------------");
        }
        catch (IOException ioexception){
            System.out.println(ioexception.getMessage());
            System.out.println("Achtung IO!!!");
            count++;
        }
        catch (UnreliableDatabase.UnreliabilityException unRelExeption){
            System.out.println(unRelExeption.getMessage());
            System.out.println("Die Load Methode sollte zuverlässiger gemacht werden!");
            count++;
            this.loadString(key);
        }

        return Optional.empty();
    }
}
