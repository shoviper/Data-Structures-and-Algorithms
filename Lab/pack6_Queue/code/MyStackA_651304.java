package code;

public class MyStackA_651304 {
    int MAX_SIZE=100;
    double stack[] = new double[MAX_SIZE];
    int top = 0;


    //push()
    public void push(double d) {
        if (!isFull()) {
            stack[top] = d;
            top++;
        }
        else {
            System.out.println("Stack is full");
        }
    }

    //pop()
    public double pop() {
        if (!isEmpty()) {
            return stack[--top];
        }
        else {
            System.out.println("Stack is empty");
            return 0.0;
        }
    }

    //top
    public double top() {
        if (!isEmpty()) {
            return stack[top - 1];
        }
        else {
            System.out.println("Stack is empty");
            return 0.0;
        }
    }

    //isFull()
    public boolean isFull() {
        return top == MAX_SIZE;
    }

    //isEmpty()
    public boolean isEmpty() {
        return top == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("top->");
        for(int i=top-1; i>=0; i--) {
            sb.append("[");
            sb.append(stack[i]);
            sb.append("]->");
        }
        sb.append("bottom");
        return new String(sb);
    }
}
