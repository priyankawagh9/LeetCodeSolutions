package level.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendarTwo() {
        calendar = new TreeMap<>((a, b) -> a - b);
    }

    public boolean book(int start, int end) {

        if (calendar.isEmpty()) {
            calendar.put(start, 1);
            calendar.put(end, -1);
            return true;
        }

        Map.Entry<Integer, Integer> startFloor = calendar.floorEntry(start);
        Map.Entry<Integer, Integer> startCeiling = calendar.ceilingEntry(start);
        Map.Entry<Integer, Integer> endFloor = calendar.floorEntry(end);
        Map.Entry<Integer, Integer> endCeiling = calendar.ceilingEntry(end);

        //when there is no overlapping
        if ((startFloor == null || startCeiling == null) && startFloor.equals(endFloor) && startCeiling.equals(endCeiling)) {
            calendar.put(start, 1);
            calendar.put(end, -1);
            return true;
        }

        //Fully overlapping:
//        calendar.subMap()
//        if(startFloor.equals(endFloor) && startCeiling.equals(endCeiling) && ((startFloor.getValue()>=2) && ) {

//        }

        if (startFloor == null && startCeiling.getValue() <= 2) {
            calendar.put(start, 1);
//            calendar.put()
        }
//        if ((startFloor.getValue() <= 2 + startCeiling.getValue()) != 0) {
//            return false;
//        }

        calendar.replace(startFloor.getKey(), (startFloor.getValue() + 1));


//        if ()

            return false;
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */

}
