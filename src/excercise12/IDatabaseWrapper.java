package excercise12;

import java.util.Optional;

    /**
     * Part 1:
     * This interface defines a wrapper for the {@link UnreliableDatabase}.
     * Implement it with your wrapper class.
     */
    public interface IDatabaseWrapper {

        /**
         * Save a key-value-pair using the {@link UnreliableDatabase}.
         * <p>
         * When the {@link UnreliableDatabase} throws a {@link ex12.UnreliableDatabase.UnreliabilityException},
         * try again until it succeeds.
         *
         * @param key   the "primary key"
         * @param value the value to be saved
         */
        void saveString(int key, String value) throws MyDatabaseException;

        /**
         * Load a value from the {@link UnreliableDatabase}.
         * <p>
         * When the {@link UnreliableDatabase} throws a {@link ex12.UnreliableDatabase.UnreliabilityException},
         * try again until it succeeds.
         *
         * @param key the search key (primary key)
         * @return {@link Optional} containing value found with given key. Is {@link Optional#EMPTY} if no value is found
         */
        Optional<String> loadString(int key) throws MyDatabaseException;
    }

