package code;

public class MyStackL_651304 {
    int MAX_SIZE=100;
    String stack[] = new String[MAX_SIZE];
    int top = 0;


    //push()
    public void push(String d) {
        if (!isFull()) {
            stack[top] = d;
            top++;
        }
        else {
            System.out.println("Stack is full");
        }
    }

    //pop()
    public String pop() {
        if (!isEmpty()) {
            return stack[--top];
        }
        else {
            System.out.println("Stack is empty");
            return null;
        }
    }

    //top
    public String top() {
        if (!isEmpty()) {
            return stack[top - 1];
        }
        else {
            System.out.println("Stack is empty");
            return null;
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