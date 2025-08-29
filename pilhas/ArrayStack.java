// LIFO - Last In First Out
public class ArrayStack implements Stackable{
    private Object[] pilha;
    private int topPointer;

    public ArrayStack(int tamanho) {
        pilha = new Object[tamanho];
        topPointer = -1;
    }

    public ArrayStack() {
        this(10); // tamanho padrão
    }

    public void push(Object data) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return;
        }
        topPointer++;
        pilha[topPointer] = data;
    }

    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        Object temp = pilha[topPointer];
        topPointer--;
        return temp;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return pilha[topPointer];
    }

    private boolean isEmpty() {
        return topPointer == -1;
    }

    private boolean isFull() {
        return topPointer == pilha.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[\n");
        for (int i = topPointer; i >= 0; i--) {
            result.append(pilha[i]);
            if (i != 0) result.append(",\n");
        }
        result.append("\n]");
        return result.toString();
    }
}