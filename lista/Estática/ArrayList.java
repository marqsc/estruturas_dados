public class ArrayList implements Listable{
    private Object[] data;
    private int head;
    private int tail;
    private int numberElements;

    public ArrayList() {
        this(10);
    }

    public ArrayList (int length){
        data = new Object[length];
        head = 0;
        tail = -1;
        numberElements = 0;
    }

    private int map(int logicalIndex) {
		return (head + logicalIndex) % data.length;
	}

    @Override
    public boolean isEmpty(){
        return numberElements == 0;
    }

    @Override
    public boolean isFull() {
        return numberElements == data.length;
    }

    @Override
    public String print() {
        String result = "";
        int aux = head;
        for(int i = 0; i <numberElements; i++){
            result += data[aux];
            if (i != numberElements -1) {
                result += ",";
            }
            aux = next(aux);
        }
        return "["+ result +"]";
    }

    @Override
    public Object select(int logicalIndex) {
        if (isEmpty()) {
            System.err.println("List is empty");
            return null;
        }
        if (logicalIndex < 0 || logicalIndex >= numberElements) {
            System.err.println("Invalid index");
            return null;
        }
        int physicalIndex = map(logicalIndex);
        return data[physicalIndex];
    }


    public Object[] selectAll() {
        Object[] result = new Object[numberElements];
        int aux = head;
        for (int i = 0; i < numberElements; i++) {
            result[i] = data[aux];
            aux = next(aux);
        }
        return result;
    }

    @Override
	public void append(Object dado) {
		if (isFull()) {
            System.err.println("Lista Cheia!");
		} else {
            tail = next(tail);
            this.data[tail] = dado;
            numberElements++;
		}			
	}

    @Override
    public void clear(){
        head = 0;
        tail = -1;
        numberElements = 0;
    }

    private int prior(int index){
        return (index - 1 + data.length) %data.length;
    }

    private int next (int index) {
        return (index + 1) %data.length;
    }
}
