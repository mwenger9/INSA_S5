package fr.insa_rennes.sdd.priority_queue;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2){
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
