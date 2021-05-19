package com.youzm.stack;

import com.youzm.contruct.NestedInteger;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> stack=new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger nested:nestedList){
            splitNestedInteger(nested);
        }
    }

    public void splitNestedInteger(NestedInteger nestedInteger){
        if(nestedInteger.isInteger()){
            stack.add(nestedInteger.getInteger());
            return;
        }else {
            for(NestedInteger integer:nestedInteger.getList()){
                splitNestedInteger(integer);
            }

        }
    }

    @Override
    public Integer next() {
        return stack.poll();
    }

    @Override
    public boolean hasNext() {
        return !(stack.size()==0);
    }
}

