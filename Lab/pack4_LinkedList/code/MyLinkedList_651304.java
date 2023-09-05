package code;

public class MyLinkedList_651304{
    public class Node{
        int data;
        Node next;

        public Node(int d){
            data = d;
        }
    }

    Node head = null;

    //task 1
    //add
    public void add(int d){
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    //insert
    public void insert(int data){
        Node newNode = new Node(data);
        if (head == null || data < head.data){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && data >= current.data){
            prev = current;
            current = current.next;
        }
        prev.next = newNode;
        newNode.next = current;
    }
    
    //find
    public int find(int d){
        int index = 0;
        Node p = head;
        while (p != null){
            if (p.data == d) {
                return index;
            }
            p = p.next;
            index++;
        }
        return -1;
    }

    //delete
    public void delete(int d){
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while ((p.next != null) && (p.next.data != d)){
            p = p.next;
        }
        if (p.next != null){
            p.next = p.next.next;
        }
        head = t.next;
    }



    //task2
    //size
    private int size(){
        int count = 0;
        Node p = head;
        while (p != null){
            count++;
            p = p.next;
        }
        return count;
    }

    //add[]
    public void add(int[] d){
        for (int i = d.length - 1; i >= 0; i--){
            add(d[i]);
        }
    }

    //insert[]
    public void insert(int[] d) {
        for (int i = 0; i < d.length; i++) {
            insert(d[i]);
        }
    }



    //task3
    //q1
    public void q1_rotate_clockwise(int k){
        int linkSize = size();
        if (k == 0 || k >= linkSize){
            return;
        }
        Node current = head;
        int count = 1;
        while (count < k && current != null){
            current = current.next;
            count++;
        }
        if (current == null)
            return;
        Node kth = current;
        while (current.next != null)
            current = current.next;
        current.next = head;
        head = kth.next;
        kth.next = null;
    }
    
    //q2
    public void q2_reverse(){
        Node previous = null;
        Node current = head;
        Node next;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }
    
    //q3
    public void q3_remove_dup(){
        if (head == null){
            return;
        }
        Node current = head;
        while (current != null){
            Node runner = current;
            while (runner.next != null){
                if (runner.next.data == current.data){
                    runner.next = runner.next.next;
                } 
                else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    //q4
    public void q4_increment_digits() {
        Node p = head;
        int sum = 0;
        int nines = 0;
        int size = size();
        for (int i = size - 1; i >= 0; i--) {
            if (p.data != 9) {
                nines++;
            }
            sum += p.data * Math.pow(10, i);
            delete(p.data);
            p = p.next;
        }
        sum++;
        if (nines == size) {
            while (sum >= 10) {
                add(0);
                sum /= 10;
            }
            add(1);
        } else {
            while (size > 0) {
                int temp = (int) (sum / Math.pow(10, size - 1));
                add(temp);
                sum -= temp * Math.pow(10, size - 1);
                size--;
            }
            q2_reverse();
        }
    }

    //q5
    public boolean q5_isPalindrome() {
        int[] elements = new int[size()];
        Node current = head;
        int index = 0;
        while (current != null) {
            elements[index++] = current.data;
            current = current.next;
        }
        int left = 0;
        int right = elements.length - 1;
        while (left < right) {
            if (elements[left] != elements[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head ");
        Node p = head;
        while (p != null) {
            sb.append("--> (");
            sb.append(p.data);
            sb.append(") ");
            p = p.next;
        }
        sb.append("-> null");
        return sb.toString();
    }
}