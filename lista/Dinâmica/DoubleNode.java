/**
 * Classe que define o nó duplo que será utilizado na lista dupla.
 *
 * @param <T> o tipo dos elementos armazenados no nó
 * @author Yuri Kevin Nascimento de Araujo
 * @version 1.0
 * @since 2025-11-03
 */
public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> previous;
    private DoubleNode<T> next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
