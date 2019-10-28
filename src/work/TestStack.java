package work;

public class TestStack {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack();

        System.out.println(stack.push(1));
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
