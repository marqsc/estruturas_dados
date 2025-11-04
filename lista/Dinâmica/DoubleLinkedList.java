/**
 * Classe que implementa uma lista dupla;
 *
 * @param <T> o tipo dos elementos armazenados na lista
 * @author Yuri Kevin Nascimento de Araujo
 * @version 1.0
 * @since 2025-11-03
 */
public class DoubleLinkedList<T> implements Listable<T> {

    /** Quantidade atual de elementos na lista */
    private int size;

    /** Tamanho máximo da lista */
    private int capacity;

    /** Ponteiro para o primeiro nó da lista */
    private DoubleNode<T> head;

    /** Ponteiro para o último nó da lista */
    private DoubleNode<T> tail;

    /**
     * Construtor padrão que cria uma lista com capacidade para 10 elementos.
     */
    public DoubleLinkedList() {
        this(10);
    }

    /**
     * Construtor que cria uma lista com capacidade personalizada.
     *
     * @param capacity a capacidade máxima da lista
     */
    public DoubleLinkedList(int capacity) {
        head = null;
        tail = null;
        size = 0;
        this.capacity = capacity;
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param element o elemento a ser adicionado
     * @throws OverflowException se a lista estiver cheia
     */
    @Override
    public void append(T element) {
        if (isFull()) {
            throw new OverflowException("Lista Cheia!");
        }
        DoubleNode<T> tempNode = new DoubleNode<>();
        tempNode.setData(element);
        if (!isEmpty()) {
            tail.setNext(tempNode);
            tempNode.setPrevious(tail);
        } else {
            head = tempNode;
        }
        tail = tempNode;
        size++;
    }

    /**
     * Insere um elemento em uma posição específica da lista.
     *
     * @param position a posição onde o elemento será inserido
     * @param element o elemento a ser inserido
     * @throws OverflowException se a lista estiver cheia
     * @throws IndexOutOfBoundsException se a posição for inválida
     */
    @Override
    public void insert(int position, T element) {
        if (isFull()) {
            throw new OverflowException("Lista Cheia!");
        }
        if (!(position >= 0 && position <= size)) {
            throw new IndexOutOfBoundsException("Indice Invalido!");
        }
        DoubleNode<T> tempNode = new DoubleNode<>();
        tempNode.setData(element);

        DoubleNode<T> previousPointer = null;
        DoubleNode<T> nextPointer = head;

        for (int i = 0; i < position; i++) {
            previousPointer = nextPointer;
            nextPointer = nextPointer.getNext();
        }

        if (previousPointer != null) {
            previousPointer.setNext(tempNode);
        } else {
            head = tempNode;
        }

        if (nextPointer != null) {
            nextPointer.setPrevious(tempNode);
        } else {
            tail = tempNode;
        }

        tempNode.setPrevious(previousPointer);
        tempNode.setNext(nextPointer);

        size++;
    }

    /**
     * Retorna o elemento em uma posição específica da lista.
     *
     * @param position a posição do elemento desejado
     * @return o elemento na posição especificada
     * @throws UnderflowException se a lista estiver vazia
     * @throws IndexOutOfBoundsException se a posição for inválida
     */
    @Override
    public T select(int position) {
        if (isEmpty()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (!(position >= 0 && position < size)) {
            throw new IndexOutOfBoundsException("Indice Invalido!");
        }

        DoubleNode<T> tempPointer = head;
        for (int i = 0; i < position; i++) {
            tempPointer = tempPointer.getNext();
        }
        return tempPointer.getData();
    }

    /**
     * Retorna um array contendo todos os elementos da lista.
     *
     * @return array com todos os elementos da lista
     * @throws UnderflowException se a lista estiver vazia
     */
    @SuppressWarnings("unchecked")
    @Override
    public T[] selectAll() {
        if (isEmpty()) {
            throw new UnderflowException("Lista Vazia!");
        }
        T[] tempData = (T[]) new Object[size];
        DoubleNode<T> tempPointer = head;
        for (int i = 0; i < size; i++) {
            tempData[i] = tempPointer.getData();
            tempPointer = tempPointer.getNext();
        }
        return tempData;
    }

    /**
     * Atualiza o elemento em uma posição específica da lista.
     *
     * @param position a posição do elemento a ser atualizado
     * @param newElement o novo elemento
     * @throws UnderflowException se a lista estiver vazia
     * @throws IndexOutOfBoundsException se a posição for inválida
     */
    @Override
    public void update(int position, T newElement) {
        if (isEmpty()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (!(position >= 0 && position < size)) {
            throw new IndexOutOfBoundsException("Indice Invalido!");
        }

        DoubleNode<T> tempPointer = head;
        for (int i = 0; i < position; i++) {
            tempPointer = tempPointer.getNext();
        }
        tempPointer.setData(newElement);
    }

    /**
     * Remove o elemento em uma posição específica da lista.
     *
     * @param position a posição do elemento a ser removido
     * @return o elemento removido
     * @throws UnderflowException se a lista estiver vazia
     * @throws IndexOutOfBoundsException se a posição for inválida
     */
    @Override
    public T delete(int position) {
        if (isEmpty()) {
            throw new UnderflowException("Lista Vazia!");
        }
        if (!(position >= 0 && position < size)) {
            throw new IndexOutOfBoundsException("Indice Invalido!");
        }

        DoubleNode<T> tempPointer = head;
        for (int i = 0; i < position; i++) {
            tempPointer = tempPointer.getNext();
        }

        DoubleNode<T> previousPointer = tempPointer.getPrevious();
        DoubleNode<T> nextPointer = tempPointer.getNext();

        if (previousPointer != null) {
            previousPointer.setNext(nextPointer);
        } else {
            head = head.getNext();
        }

        if (nextPointer != null) {
            nextPointer.setPrevious(previousPointer);
        } else {
            tail = tail.getPrevious();
        }

        size--;
        return tempPointer.getData();
    }

    /**
     * Verifica se a lista está cheia.
     *
     * @return true se a lista estiver cheia, false caso contrário
     */
    @Override
    public boolean isFull() {
        return (size == capacity);
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return true se a lista estiver vazia, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Retorna uma representação em string da lista.
     * Os elementos são separados por vírgula e delimitados por colchetes.
     *
     * @return string representando a lista
     */
    @Override
    public String print() {
        String result = "[";
        DoubleNode<T> tempPointer = head;
        for (int i = 0; i < size; i++) {
            result += tempPointer.getData();
            if (i != size - 1) {
                result += ",";
            }
            tempPointer = tempPointer.getNext();
        }
        return result + "]";
    }
}
