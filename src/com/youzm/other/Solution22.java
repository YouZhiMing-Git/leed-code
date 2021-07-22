package com.youzm.other;

import java.util.*;

/***
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
 * orders[i]=[customerNamei,tableNumberi,foodItemi]
 * 其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。
 * 在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
 * 后面每一列都是按字母顺序排列的餐品名称。
 * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 */

public class Solution22 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> resultList = new ArrayList<>();
        TreeMap<Integer, List<String>> sortedMap = new TreeMap<>();
        SortedSet<String> sortedSet = new TreeSet<>();
        for (List<String> order : orders) {
            int tableNumber =Integer.parseInt(order.get(1)) ;
            if(sortedMap.get(tableNumber)==null){
                sortedMap.put(tableNumber,new ArrayList<>());
            }
            sortedMap.get(tableNumber).add(order.get(2));
            sortedSet.add(order.get(2));
        }
        List<String> firstCol = new ArrayList<>();
        firstCol.add("Table");
        firstCol.addAll(1, sortedSet);
        resultList.add(firstCol);
        int length=firstCol.size();
        for (Map.Entry<Integer, List<String>> entry : sortedMap.entrySet()) {
          String[] list = new String[length];
            for (int i = 0; i < list.length; i++) {
                list[i]="0";
            }
            list[0]=entry.getKey().toString();
            List<String> foodItems = entry.getValue();
            HashMap<String, Integer> order = new HashMap<String, Integer>();
            foodItems.forEach(food -> {
                order.put(food, order.getOrDefault(food, 0) + 1);
            });
            order.forEach((food, num) -> {
                int i = firstCol.indexOf(food);
                list[i]=num.toString();
            });
            resultList.add(new ArrayList<>(Arrays.asList(list)));
        }

        return resultList;
    }

    public static void main(String[] args) {
        Solution22 solution = new Solution22();

        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(new ArrayList<>(Arrays.asList("David","3","Ceviche")));
        lists.add(new ArrayList<>(Arrays.asList("Corina","10","Beef Burrito")));
        lists.add(new ArrayList<>(Arrays.asList("David","3","Fried Chicken")));
        lists.add(new ArrayList<>(Arrays.asList("Carla","5","Water")));
        lists.add(new ArrayList<>(Arrays.asList("Carla","5","Ceviche")));
        lists.add(new ArrayList<>(Arrays.asList("Rous","3","Ceviche")));
        System.out.println(solution.displayTable(lists));

    }
}
