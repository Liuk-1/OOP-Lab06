package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int START = 1000;
	private static final int STOP = 2000;
	private static final int N_ELEMENTS = 2000;
	private static final int TO_MS = 1_000_000;
	private static final int READ_TIMES = 1000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	
    	for(int i = START; i < STOP; i++) {
    		arrayList.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	LinkedList<Integer> linkedList = new LinkedList<Integer>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	var temp = arrayList.get(0);
    	arrayList.set(0, arrayList.get(arrayList.size() - 1));
    	arrayList.set(arrayList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(Integer elem : arrayList) {
    		System.out.println(elem);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time = System.nanoTime();
    	
    	for(int i = 0; i < N_ELEMENTS; i++) {
    		arrayList.add(i, i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println(time / TO_MS);
    	
    	time = System.nanoTime();
    	
    	for(int i = 0; i < N_ELEMENTS; i++) {
    		linkedList.add(i, i);
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println(time / TO_MS);
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	time = System.nanoTime();
    	for(int i = 0; i < READ_TIMES; i++) {
    		arrayList.get(arrayList.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println(time / TO_MS);
    	
    	time = System.nanoTime();
    	for(int i = 0; i < READ_TIMES; i++) {
    		linkedList.get(arrayList.size() / 2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println(time / TO_MS);
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> worldMap = new HashMap<String, Long>();
    	worldMap.put("Africa", 1110635000L);
    	worldMap.put("Americas", 972005000L);
    	worldMap.put("Antartica", 0L);
    	worldMap.put("Asia", 4298723000L);
    	worldMap.put("Europe", 742452000L);
    	worldMap.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
    	Long worldPopulation = 0L;
    	for(final Long population : worldMap.values()) {
    		worldPopulation += population;
    	}
    	System.out.println(worldPopulation);
    }
}
