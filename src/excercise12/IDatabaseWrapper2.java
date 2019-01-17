package excercise12;

import java.util.Optional;


    /**
     * Part 2:
     * This interface defines a wrapper for the {@link UnreliableDatabase}.
     * Implement it with your wrapper class.
     */
  //  public interface IDatabaseWrapper2 {

        /**
         * Save a key-value-pair using the {@link UnreliableDatabase}.
         * <p>
         * When the {@link UnreliableDatabase} throws a {@link ex12.UnreliableDatabase.UnreliabilityException},
         * try again a few times (e.g.: 2 times).
         * If the {@link UnreliableDatabase} continues to fail, a {@link MyDatabaseException} should be thrown.
         * (You need to implement the {@link MyDatabaseException}.)
         *
         * @param key   the "primary key"
         * @param value the value to be saved
         * @throws MyDatabaseException if the unreliable database failed several times.
         */
      //  void saveString(int key, String value) throws MyDatabaseException;


        /**
         * Load a value from the {@link UnreliableDatabase}.
         * <p>
         * When the {@link UnreliableDatabase} throws a {@link ex12.UnreliableDatabase.UnreliabilityException},
         * try again a few times (e.g.: 2 times).
         * If the {@link UnreliableDatabase} continues to fail, a {@link MyDatabaseException} should be thrown.
         * (You need to implement the {@link MyDatabaseException}.)
         *
         * @param key the search key (primary key)
         * @return {@link Optional} containing value found with given key. Is {@link Optional#EMPTY} if no value is found
         * @throws MyDatabaseException if the unreliable database failed several times.
         */
   //     Optional<String> loadString(int key) throws MyDatabaseException;
  //  }



