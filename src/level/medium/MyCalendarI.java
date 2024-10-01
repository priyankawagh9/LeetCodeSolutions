package level.medium;

import java.util.*;


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

public class MyCalendarI {

    TreeSet<int[]> event;

    public MyCalendarI() {
        this.event = new TreeSet<>((e1,e2) -> (e1[0]-e2[0]));
    }

    public boolean book(int start, int end) {
        boolean booked = false;

        int[] newEvent = {start, end};

        if(event.isEmpty()) {
            event.add(newEvent);
            booked = true;
        } else {

            int[] floorNeighbor = event.floor(newEvent);
            int[] ceilingNeighbor = event.ceiling(newEvent);

            if(((floorNeighbor==null || newEvent[0]>=floorNeighbor[1])
                    && ((ceilingNeighbor == null) || (newEvent[1] <= ceilingNeighbor[0])))){
                event.add(newEvent);
                booked = true;
            } else
                booked = false;
        }
        return booked;
    }
}
