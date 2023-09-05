package code;

public class MyArray_651304 {
    protected int MAX_SIZE = 100000;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;
    
    public MyArray_651304(int max){
        MAX_SIZE = max;
        data = new int[MAX_SIZE];
        size = 0;
    }

    public MyArray_651304(){}

    public MyArray_651304(int... a) {
        int dataSize = (a == null) ? 0 : Math.min(a.length, MAX_SIZE);
        data = new int[MAX_SIZE];
        for (int i = 0; i < dataSize; i++) {
            data[i] = a[i];
        }
        size = dataSize;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int d){
        if (isFull())
            Expand();
        data[size] = d;
        size++;
    }

    public void insert(int d, int index){
        if (index < 0 || index > size){
            System.out.println("Invalid index.");
            return;
        }

        if (size >= MAX_SIZE){
            System.out.println("The array is full.");
            return;
        }

        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }
        
        data[size] = d;
        size++;
        System.out.println(d + " added to be in array.");

    }

    public int find(int d){
        for (int i = 0; i < size; i++){
            if (data[i] == d){
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int d) {
        int l = 0;
        int r = size - 1;

        while (l <= r) {

            int m = l + (r - l) / 2;
            
            if (data[m] == d) {
                return m; 
            } 
            else if (data[m] < d) {
                l = m + 1;
            } 
            else {
                r = m - 1;
            }
        }
        return -1;
    }

    int[] ExpandByK(int k){
        int[] temp = new int[MAX_SIZE * k];
        for(int i = 0; i < size; i++){
            temp[i] = data[i];
        }
        MAX_SIZE *= k;
        data = temp;
        return data;
    }

    int[] Expand(){
        return ExpandByK(2);
    }
    
    public void delete(int index) {
        if (!isEmpty()) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        } else {
            System.out.println("The Array is empty.");
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }


}