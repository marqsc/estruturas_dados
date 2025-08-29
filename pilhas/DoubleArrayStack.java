public class DoubleArrayStack {
    private Object[] data;
    private int topPointer1;
    private int topPointer2;

    public DoubleArrayStack() {
        this(10);
    }

    public DoubleArrayStack(int length) {
        data = new Object[length];
        topPointer1 = -1;                  // Pilha 1 começa do início
        topPointer2 = data.length;         // Pilha 2 começa do fim
    }

    public boolean isEmpty1() {
        return topPointer1 == -1;
    }

    public boolean isEmpty2() {
        return topPointer2 == data.length;
    }

    public boolean isFull() {
        return topPointer1 + 1 == topPointer2;
    }

    public void push1(Object element) {
        if (isFull()) {
            System.out.println("Stack 1 is full!");
            return;
        }
        topPointer1++;
        data[topPointer1] = element;
    }

    public void push2(Object element) {
        if (isFull()) {
            System.out.println("Stack 2 is full!");
            return;
        }
        topPointer2--;
        data[topPointer2] = element;
    }

    public Object pop1() {
        if (isEmpty1()) {
            System.out.println("Stack 1 is empty!");
            return null;
        }
        Object temp = data[topPointer1];
        data[topPointer1] = null; // limpeza opcional
        topPointer1--;
        return temp;
    }

    public Object pop2() {
        if (isEmpty2()) {
            System.out.println("Stack 2 is empty!");
            return null;
        }
        Object temp = data[topPointer2];
        data[topPointer2] = null; // limpeza opcional
        topPointer2++;
        return temp;
    }

    public Object peek1() {
        if (isEmpty1()) {
            System.out.println("Stack 1 is empty!");
            return null;
        }
        return data[topPointer1];
    }

    public Object peek2() {
        if (isEmpty2()) {
            System.out.println("Stack 2 is empty!");
            return null;
        }
        return data[topPointer2];
    }

    public String toString1() {
        StringBuilder result = new StringBuilder("[\n");
        for (int i = topPointer1; i >= 0; i--) {
            result.append(data[i]);
            if (i != 0) result.append(",\n");
        }
        result.append("\n]");
        return result.toString();
    }

    public String toString2() {
        StringBuilder result = new StringBuilder("[\n");
        for (int i = topPointer2; i < data.length; i++) {
            result.append(data[i]);
            if (i != data.length - 1) result.append(",\n");
        }
        result.append("\n]");
        return result.toString();
    }
}
