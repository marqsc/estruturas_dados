//DEQue = Double Ended Queue

import java.util.NoSuchElementException;

import Stack_Dinamica.DoubleNode;

/**
 * @author Cláudio Augusto Marques
 * @version 1.0.0
 * @since 2025-10-20
 */
public class LinkedDEQue <T> implements Queueable <T>{
    //Variáveis de instância
    private int amount;
    private int capacity;
    private DoubleNode <T> head;
    private DoubleNode <T> tail;

    public LinkedDEQue(){
        this(10);
    }

    public LinkedDEQue (int capacity){
        amount = 0;
        this.capacity = capacity;
        head = null;
        tail = null;
    }


    public boolean isFull(){
        return amount == capacity;
    }
    /*
     * Verifica se a fila estiver vazia
     * @return true se a fila estiver vazia, e false se não
     */

    public boolean isEmpty(){
        return amount == 0;
    }

    public T front(){
       if(isEmpty()){
         throw new NoSuchElementException("Fila vazia!");
       }
       return head.getData();
    }
    public int getAmount() {
        return amount;
    }

     public T rear(){
       if(isEmpty()){
            throw new NoSuchElementException("Fila vazia!");
       }
       return tail.getData();
    }

    public void beginEnqueue(T data){
         if(isFull()){
            throw new NoSuchElementException("Fila vazia!");

        }
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.setData(data); 
         if(isEmpty()){
            tail = newNode;
            head = newNode;
        } else  {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = head.getPrevious();
        }
    }

    public void endEnqueue(T data){
        if(isFull()){
            throw new NoSuchElementException("Fila vazia!");

        }
        DoubleNode<T> newNode = new DoubleNode<>();
        newNode.setData(data); 
        if(isEmpty()){
            tail = newNode;
            head = newNode;
        } else {    
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        amount++;


    }


    public T endDequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Fila vazia!");

        }
        amount--;
        T auxData =  tail.getData();
        tail = tail.getPrevious();
        if(isEmpty()){
             tail.setNext(null);
        } else {
            head = null;
        }
        return auxData;

    }
    
    public T beginDequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Fila vazia!");

        }
        amount--;
        T auxData =  head.getData();
        head = head.getNext();
        if(!isEmpty()){
            head.setPrevious(null);
        } else{
            tail = null;
        }
        return auxData;
    }

}