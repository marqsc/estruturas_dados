public class ArrayQueue implements Queueble {

    private Object[] data;
    private int head;
    private int tail;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int length){
        Object[] data = new Object[length];
        head = 0;
        tail = -1;
    }

    @Override
    public void enqueue(Object data){
        if (isFull()) {
            System.err.println("Queue is full!");
        }else{
            tail++;
            this.data[tail] = data;
        }
    }

    @Override
    public Object dequeue(){
        Object aux = null;
        if (isEmpty()) {
            System.err.println("Queue is empty!");
        }else{
            aux = data[head];
            head ++;
        }
    }

    @Override
    public Object front(){
        Object aux = null;
        if(isEmpty()){
            System.err.println("Queue is empty");
        }else{
            aux = data[head];
        }
        return aux;
    }

    @Override
    boolean isEmpty(){
        return (head -1 == tail);
    }
    @Override
    boolean isFull(){
        return (tail == data.length -1);
    }

    @Override
    String print(){
        for(int i = head; i <= tail; i++){
            result += data[i];
            if (i != tail) {
                result += data[i];
            }else {result+= data  [i] + ",";
        }
        }
        return "["+ result + "]";
    }
}