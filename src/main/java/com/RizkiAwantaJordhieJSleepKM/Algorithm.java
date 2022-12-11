package com.RizkiAwantaJordhieJSleepKM;

import java.util.*;

/**
 * The Algorithm class contains static methods for performing common operations
 * on collections of objects, such as collecting, counting, and finding elements
 * that match a given condition.
 *
 * @author Rizki Awanta Jordhie
 * @version 2 - PT5 - 13/10/2022
 */
public class Algorithm {

    /**
     * This private constructor prevents the class from being instantiated.
     */
    private Algorithm() {

    }

    // collect

    /**
     * Collects all elements from the given array that match the given value
     * and returns them as a List.
     *
     * @param <T> the type of the array elements
     * @param array the array to collect elements from
     * @param value the value to match against
     * @return a List containing all elements from the array that match the value
     */
    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    /**
     * Collects all elements from the given Iterable that match the given value
     * and returns them as a List.
     *
     * @param <T> the type of the Iterable elements
     * @param iterable the Iterable to collect elements from
     * @param value the value to match against
     * @return a List containing all elements from the Iterable that match the value
     */
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    /**
     * Collects all elements from the given Iterator that match the given value
     * and returns them as a List.
     *
     * @param <T> the type of the Iterator elements
     * @param iterator the Iterator to collect elements from
     * @param value the value to match against
     * @return a List containing all elements from the Iterator that match the value
     */
    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    /**
     * Collects all elements from the given array that match the given Predicate
     * and returns them as a List.
     *
     * @param <T> the type of the array elements
     * @param array the array to collect elements from
     * @param pred the Predicate to match against
     * @return a List containing all elements from the array that match the Predicate
     */
    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    /**
     * Collects all elements from the given Iterable that match the given Predicate
     * and returns them as a List.
     *
     * @param <T> the type of the Iterable elements
     * @param iterable the Iterable to collect elements from
     * @param pred the Predicate to match against
     * @return a List containing all elements from the Iterable that match the Predicate
     */
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    /**
     * Collects all elements from the given Iterator that match the given Predicate
     * and returns them as a List.
     *
     * @param <T> the type of the Iterator elements
     * @param iterator the Iterator to collect elements from
     * @param pred the Predicate to match against
     * @return a List containing all elements from the Iterator
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        ArrayList<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                list.add(current);
        }
        return list;
    }

    // count

    /**
     * Counts the number of elements in the given Iterable that match the given Predicate.
     *
     * @param array the type of the Iterable elements
     * @param value the Predicate to match against
     * @return the number of elements in the given Iterable that match the given Predicate
     */
    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    /**
     * Counts the number of elements in the given Iterable that match the given Predicate.
     *
     * @param iterable the Iterable to count elements from
     * @param value the Predicate to match against
     * @return the number of elements in the given Iterable that match the given Predicate
     */
    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    /**
     * Counts the number of elements in the given Iterable that match the given Predicate.
     *
     * @param iterator the Iterable to count elements from
     * @param value the Predicate to match against
     * @return the number of elements in the given Iterable that match the given Predicate
     */
    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    /**
     * Counts the number of elements in the given Iterable that match the given Predicate.
     *
     * @param array the Iterable to count elements from
     * @param pred the Predicate to match against
     * @return the number of elements in the given Iterable that match the given Predicate
     */
    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    /**
     * Counts the number of elements in the given Iterable that match the given Predicate.
     *
     * @param <T> the type of the Iterable elements
     * @param iterable the Iterable to count elements from
     * @param pred the Predicate to match against
     * @return the number of elements in the given Iterable that match the given Predicate
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    /**
     * Counts the number of elements in the given Iterator that match the given Predicate.
     *
     * @param <T> the type of the Iterator elements
     * @param iterator the Iterator to count elements from
     * @param pred the Predicate to match against
     * @return the number of elements in the given Iterator that match the given Predicate
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while (iterator.hasNext())
            if (pred.predicate(iterator.next()))
                ++count;
        return count;
    }

    //find
    public static <T> T find(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    /**
     * Returns the first element in the given iterator that satisfies the given
     * predicate, or `null` if no such element is found.
     *
     * @param <T> the type of the elements in the iterator
     * @param iterator the iterator to search
     * @param pred the predicate to apply to each element
     * @return the first element in the given iterator that satisfies the given
     *         predicate, or `null` if no such element is found
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return current;
        }
        return null;
    }

    // exists
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * Determines whether any element of an Iterator matches the given Predicate.
     *
     * @param iterator The Iterator to search.
     * @param pred The Predicate to test elements against.
     * @param <T> The type of the elements in the Iterator.
     * @return true if any element of the Iterator matches the given Predicate, false otherwise.
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return true;
        }
        return false;
    }

    //paginate
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);
        // skip first occurrences of element
        while (iterator.hasNext() && occurences < startingIdx) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                ++occurences;
        }

        /**
         * Returns a list of objects that match the specified predicate,
         * starting at the specified page and containing at most the specified number of elements.
         *
         * @param iterator the iterator to iterate over
         * @param page the page number to return (0-indexed)
         * @param pageSize the maximum number of elements to return
         * @param pred the predicate to use for matching
         * @return a list of matching objects
         */
        while (iterator.hasNext() && pageList.size() < pageSize) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                pageList.add(obj);
        }
        return pageList;
    }
}
