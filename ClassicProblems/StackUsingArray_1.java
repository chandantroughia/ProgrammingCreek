package ClassicProblems;

class Stack{
    private int[] array;
    private int maxSize;
    private int top;

    public Stack(int maxSize){
        this.array = new int[maxSize];
        this.maxSize = maxSize;
        top = -1;
    }

    public void push(int value){
        if(!isFull()){
            array[++top] = value;
        }
        else{
            System.out.println("Stack Full.");
        }
    }

    public int pop(){
        if(!isEmpty()){
            return array[top--];
        }
        else{
            System.out.println("Stack Empty.");
            return -1;
        }
    }

    private boolean isEmpty(){
        return top == -1;
    }

    private boolean isFull(){
        return top == maxSize - 1;
    }

    public void peek(){
        if(!isEmpty()){
            System.out.println(array[top]);
        }
        else{
            System.out.println("Stack Empty.");
        }
    }

    public int size(){
        return top + 1;
    }
}


public class StackUsingArray_1 {


    public static void main(String[] args) {
        Stack theStack = new Stack(10);
        theStack.peek();
        theStack.push(1);
        theStack.push(2);
        theStack.push(3);
        theStack.push(4);
        theStack.push(5);
        theStack.push(6);
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.pop());
        System.out.println(theStack.size());

    }

}


