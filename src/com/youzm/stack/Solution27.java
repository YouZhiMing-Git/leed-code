package com.youzm.stack;

import java.util.ArrayList;
import java.util.List;

public class Solution27 {
    List<String> itinerary = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        findDestination(tickets,"JFK");
        return itinerary;
    }

    public void findDestination(List<List<String>> tickets, String departure) {
        itinerary.add(departure);
        if(tickets.size()==0)return;
        int index = -1;
        String destination = "ZZZ";
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).get(0).equals(departure)) {
                if (tickets.get(i).get(1).compareTo(destination) < 0) {
                    index = i;
                    destination = tickets.get(i).get(1);
                }
            }
        }
        if(index<0)return;
        tickets.remove(index);
        findDestination(tickets,destination);
    }

    public static void main(String[] args) {
        Solution27 solution27=new Solution27();

    }
}
