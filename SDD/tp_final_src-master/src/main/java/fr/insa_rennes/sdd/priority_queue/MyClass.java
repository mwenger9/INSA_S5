package fr.insa_rennes.sdd.priority_queue;
import fr.insa_rennes.sdd.graph.*;
import fr.insa_rennes.sdd.dijkstra.*;
import java.util.*;

public class MyClass<T> {

    Comparator<? super T> comparator;
    Comparator<Integer> comp2;
    Comparator<Integer> comp3;
    public MyClass(){
        this.comparator = (t1, t2) -> ((Comparable<? super T>)t1).compareTo(t2);
        this.comp2 = (x,y) -> x > y ? 1 : -1 ;
        this.comp3 = new IntegerComparator();
    }

    public static void main(String args[]) {

        Comparator<Integer> myComparator = (x,y) -> x > y  ? 1 : -1 ;
        /*
        MyClass<Integer> test = new MyClass<Integer>();
        List<Integer> l = new ArrayList<Integer>();
        int testComp = myComparator.compare(1,2);
        l.add(7);
        l.add(3);
        l.add(1);
        l.add(30);
        Comparable<? super Integer> a;
        Collections.sort(l,test.comparator);
        //System.out.println(test.comparator.getClass().getName());
        System.out.println(l.toString());
        Collections.sort(l,test.comp2);
        System.out.println(l.toString());
        Collections.sort(l,test.comp3);
        System.out.println(l.toString());


        HeapPQ<Integer> tas = new HeapPQ<>(myComparator);
        tas.add(7);
        tas.add(2);
        tas.add(17);
        tas.add(25);
        tas.add(100);
        tas.add(36);

        System.out.println((tas.toString()));

         */
        Graph<Integer> g = new IndexedGraph(5);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 3, 10);
        g.addEdge(1, 2, 4);
        g.addEdge(1, 3, 4);
        g.addEdge(3, 4, 3);
        g.addEdge(4, 3, 2);

        Dijkstra<Integer> dijkstra = new Dijkstra<>(g,0);
        double dist = (dijkstra.getCost(3));
        System.out.println((dijkstra.getCost(3)));

    }
}
