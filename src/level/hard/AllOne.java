package level.hard;

import java.util.*;

/*
432. All O`one Data Structure
Design a data structure to store the strings’ count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
Example 1:

Input

["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output: [null, null, null, “hello”, “hello”, null, “hello”, “leet”]

Explanation:

AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"
Constraints:

1 <= key.length <= 10
key consists of lowercase English letters.
It is guaranteed that for each call to dec, key is existing in the data structure.
At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.
 */
public class AllOne {

    TreeMap<Integer, List<String>> counter2StringMap;
    Map<String, Integer> string2ValueMap;

    public AllOne() {
        counter2StringMap = new TreeMap<Integer, List<String>>();
        string2ValueMap = new HashMap<>();
    }

    public void inc(String key) {
        int counter;
        List<String> strings;

        if (string2ValueMap.containsKey(key)) {
            counter = string2ValueMap.get(key); //get position for key String.


            strings = counter2StringMap.get(counter);
            strings.remove(key);
            if (!strings.isEmpty())
                counter2StringMap.replace(counter, strings); //remove existing record
            else
                counter2StringMap.remove(counter); //remove complete list if its empty

            counter++;
            string2ValueMap.replace(key, counter);
            strings = counter2StringMap.get(counter);
            if(strings==null)
                strings = new ArrayList<>();
            else
                counter2StringMap.remove(counter,strings);

            strings.add(key);
        } else {
            string2ValueMap.put(key, 1);

            strings = counter2StringMap.get(1);
            if(strings==null)
                strings = new ArrayList<>();

            strings.add(key);
            counter = 1;
        }

        counter2StringMap.put(counter, strings);
    }

    public void dec(String key) {
        int counter;
        List<String> strings;

        if (!string2ValueMap.containsKey(key)) {
            return;
        }

        counter = string2ValueMap.get(key); //get position for key String.
        strings = counter2StringMap.get(counter); //remove existing record
        strings.remove(key);

        if(strings==null || strings.isEmpty()) {
            counter2StringMap.remove(counter);
        } else {
            counter2StringMap.replace(counter, strings);
        }

        counter--;
        if (counter > 0) {
            strings = counter2StringMap.get(counter);

            if(strings==null) {
                strings = new ArrayList<>();
                strings.add(key);
            } else {
                strings.add(key);
            }

            counter2StringMap.put(counter, strings);
            string2ValueMap.put(key, counter);
        } else
            string2ValueMap.remove(key);
    }

    public String getMaxKey() {
        List<String> strings;
        if (!counter2StringMap.isEmpty()) {
            strings = counter2StringMap.lastEntry().getValue();
            return strings.getFirst();
        }
        return "";
    }

    public String getMinKey() {
        List<String> strings;

        if (!counter2StringMap.isEmpty()) {
            strings = counter2StringMap.firstEntry().getValue();
            return strings.getFirst();
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */