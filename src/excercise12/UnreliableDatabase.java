package excercise12;

import java.io.*;
import java.util.Optional;
import java.util.Random;
import java.util.StringTokenizer;


public class UnreliableDatabase {
private final File file;

        /**
         * Constructor creating file, FileReader and FileWriter
         *
         * @param filename something like "c:\\temp\\mydatabase.csv" or "/tmp/mydatabase.csv"
         * @throws FileNotFoundException if file cannot be created or found
         */
        public UnreliableDatabase(final String filename) throws FileNotFoundException{
            file = new File(filename);
            if (!file.exists()) {
                throw new FileNotFoundException("No file at: " + file.getAbsolutePath());
            }
        }

        /**
         * Saves Strings in the DB (File)
         *
         * @param key   the "primary key"
         * @param value the value to be saved
         * @throws IOException if somethings goes wrong. <- very helpful documentation!!1
         */
        public void saveString(final int key, final String value) throws UnreliabilityException, IOException {
            throwRandomError();
            final FileReader fileReader = new FileReader(this.file);
            final BufferedReader reader = new BufferedReader(fileReader);
            final StringBuffer fileContent = new StringBuffer();
            boolean keyFound = false;

            while (reader.ready()) {
                final String line = reader.readLine();
                final StringTokenizer toki = new StringTokenizer(line, ",");
                int key0 = Integer.parseInt(toki.nextToken());
                if (key == key0) {
                    //there is already content with that key: replace it
                    fileContent.append(key + "," + value + "\n");
                    keyFound = true;
                } else {
                    fileContent.append(line + "\n");
                }
            }

            if (!keyFound) {
                //content is new
                fileContent.append(key + "," + value + "\n");
            }

            reader.close();

            final FileWriter writer = new FileWriter(file);
            writer.write(fileContent.toString());
            writer.flush();
            writer.close();
        }

        /**
         * Retrieves values from DB (file)
         *
         * @param key the search key (primary key)
         * @return {@link Optional} containing value found with given key. Is {@link Optional#EMPTY} if no value is found
         * @throws UnreliabilityException if something weird goes wrong. mayby try again?!
         * @throws IOException            if somethings else goes wrong. <- very helpful documentation!!1
         */
        public Optional<String> loadString(final int key) throws UnreliabilityException, IOException {
            throwRandomError();
            final FileReader fileReader = new FileReader(file);
            final BufferedReader reader = new BufferedReader(fileReader);
            String foundContent = null;
            while (reader.ready()) {
                final String line = reader.readLine();
                final StringTokenizer toki = new StringTokenizer(line, ",");
                final int key0 = Integer.parseInt(toki.nextToken());
                final String value = toki.nextToken();
                if (key == key0) {
                    foundContent = value;
                }
            }
            reader.close();
            return Optional.ofNullable(foundContent);
        }

        /**
         * Method simulates random database errors
         *
         * @throws UnreliabilityException if somethings goes wrong. <- very helpful documentation!!1
         */
        private void throwRandomError() throws UnreliabilityException {
            final Random random = new Random();
            final Double number = random.nextGaussian() * 100;
            final int intnumber = number.intValue();
            if ((intnumber % 4) == 0) {
                throw new UnreliabilityException("Error Code: " + intnumber);
            }
        }

        public class UnreliabilityException extends Exception {
            UnreliabilityException(final String s) {
                super(s);
            }
        }
    }



