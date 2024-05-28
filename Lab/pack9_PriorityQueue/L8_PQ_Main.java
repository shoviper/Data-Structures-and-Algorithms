import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import code.Employee651304;
import code.MyMinHeap651304;
import code.MyPriorityQueue651304;

public class L8_PQ_Main {
    static ArrayList<Integer> least3;

    public static void main(String[] args) {
        System.out.println("-demo1---");
        demo1();
        System.out.println("-demo2---");
        demo2();
        // System.out.println("-Bonus---");
        // demo_priorityQueue();
    }

    static void demo1() {
        least3 = new ArrayList<>();
        MyMinHeap651304 heap = new MyMinHeap651304();
        heap.insert(11);
        heap.insert(15);
        heap.insert(16);
        heap.insert(13);
        heap.insert(17);
        heap.insert(18);
        System.out.println("heap strucutre is " + heap);
        least3.add(heap.remove());
        least3.add(heap.remove());
        least3.add(heap.remove());
        System.out.println("least 3 value is " + least3);
    }

    static void demo2() {
        least3 = new ArrayList<>();
        MyPriorityQueue651304 pq = new MyPriorityQueue651304();
        pq.enqueue(11);
        pq.enqueue(15);
        pq.enqueue(16);
        pq.enqueue(13);
        pq.enqueue(17);
        pq.enqueue(18);
        pq.enqueue(19);
        System.out.println("pq structure is " + pq);
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        least3.add(pq.dequeue());
        System.out.println("least 3 value is " + least3);
    }

    static void demo_priorityQueue() {
        PriorityQueue<Employee651304> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.salary,e2.salary));
        List<Employee651304> list = Arrays.asList(new Employee651304("Yindee", 2000), new Employee651304("Preeda",1500), new Employee651304("Pramote", 3000));
        pq.addAll(list);
        System.out.println(pq);
    }
}