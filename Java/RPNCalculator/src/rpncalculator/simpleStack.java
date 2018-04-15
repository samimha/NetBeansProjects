package rpncalculator;

public class simpleStack<T extends Comparable<T>> {
    private static final int MAXN = 10;
    private int top;
    private T[] array;
    
    public simpleStack() {
        top = -1;
        array = (T[])new Comparable[MAXN];
    }

    public boolean push(T item) {
        if (top >= MAXN-1)
            return false;
        else
            array[++top] = item;
            return true;
    }

    public T pop() {
        if (top == -1)
            return null;
        else
            return array[top--];
    }

    public void print() {
        for (int i = top; i >= 0; i--)
            System.out.println(array[i] + " ");
    }
    
    public static void main(String[] args) {
        simpleStack<Integer> stack = new simpleStack();
        Character             item;

        System.out.println("This is a RPN calculator. Enter operands and operators: ");
        System.out.println("");
        System.out.println("    Input   Output");
        try {
            item = (char)System.in.read();
            while (item.compareTo('q') != 0) {
                
                if (item.compareTo('+') == 0){
                    int number = stack.pop();
                    number += stack.pop();
                    System.out.println("result: " + number);
                    stack.push(number); 
                }
                else if (item.compareTo('-') == 0){
                    int number = stack.pop();
                    number = stack.pop() - number;
                    System.out.println("result: " + number);
                    stack.push(number); 
                }
                else if (item.compareTo('*') == 0){
                    int number = stack.pop();
                    number *= stack.pop();
                    System.out.println("result: " + number);
                    stack.push(number); 
                }
                else if (item.compareTo('=') == 0){
                    int top = stack.pop();
                    System.out.println("top value is " + top);
                    stack.push(top);
                }
                else if (item.compareTo('\n') != 0){
                    stack.push(Character.getNumericValue(item));
                }
                item = (char)System.in.read();
            }
            
            stack.print();
            
        } catch(Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
