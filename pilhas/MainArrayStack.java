public class MainArrayStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println("Popped: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println(stack);
    }
}
