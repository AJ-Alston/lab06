
//stack class that creates an array, grows it when full, and implements stack push, pop, and peek methods
public class Stack {
    //define data
    int[] stack;
    int top;
    int capacity;

    //stack construcor
    Stack(int capacity){
        this.stack = new int[capacity];
        this.capacity= capacity;
        this.top =-1;
    }
    //Adds an integer to the stack
    public void push(int item){
        //if stack is full, grow it
        if(stack.length==capacity){
            growArray();
        }
        stack[++top]=item;
    }
    //resets stack top and returns the last added item
    public int pop(){
        if(top==-1){
            throw new RuntimeException("Empty stack");
        }
        return stack[top--];
    }
    //returns the last added item
    public int peek(){
        if(top==-1){
            throw new RuntimeException("Empty stack");
        }
        return stack[top];
    }
    //grows array times 2 and copy elements from original array into new array
    public void growArray(){
        int[] newStack = new int[capacity*2];
        for (int i = 0; i < stack.length; i++) {
            stack[i]=newStack[i];
        }
        stack=newStack;
    }

}
