/**
* Implementação de pilha dinâmica utilizando Generics
* @author Yuri Nascimento
* @version 1.0
* @since 06/10/2025
* @param T, tipo de dado que será armazenado na pilha
 */
public class LinkedStack<T> implements Stackable{
    /** objeto do topo da pilha */
    private DoubleNode<T> topPointer; 
    /** número de elementos atualmente */
    private int numberElements;
    /** número máximo de elementos permitidos */
    private int maxElements;

    /**
    * Construtor sem parâmetro
    * Cria uma pilha com tamanho padrão de 10 elementos
    */
    public LinkedStack(){
        this(10);
    }

    /**
    * Construtor que recebe um inteiro
    *@param maxElements é o número máximo de elementos que podem ser armazenados
    */
    public LinkedStack(int maxElements){
        topPointer = null;
        this.numberElements = 0;
        this.maxElements = maxElements;
    }


    /**
    * Verifica se a pilha está vazia
    *@return retorna true se a pilha está vazia e false se não estiver
    */
    @Override
    boolean isEmpty(){
        return numberElements == 0;
    }

    /**
    * Verifica se a pilha está cheia
    *@return retorna true se a pilha está cheia e false se não estiver
    */
    @Override
    boolean isFull(){
        return numberElements == maxElements;
    }

    /**
    *@return retorna o valor do nó do topo se a pilha não estiver vazia
    */
    @Override
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("A pilha está vazia.");
        }
        return topPointer.getData();
    }

    /**
    *@return Remove da pilha e retorna o valor do nó do topo se a pilha não estiver vazia
    *@throws NoSuchElementException se a pilha estiver vazia
    */
    @Override
    public T pop(){
        if(isEmpty()){
            throw new NoSuchElementException("A pilha está vazia.");
        }
        T auxData = topPointer.getData;
        topPointer = topPointer.getPrevious();
        topPointer.setNext(null);
        return auxData;
    }

    /**
    *adiciona elemento a pilha caso não esteja cheia
    *@param data é o elemento a ser empilhado
    *@throws NoSuchElementException se a pilha estiver cheia
    */
    @Override
    public void push(T data){
        if(isFull()){
            throw new NoSuchElementException("A pilha está cheia.");
        }
        DoubleNode<T> newNode = new DoubleNode<T>;
        newNode.setData(data);
        topPointer.setNext(newNode);
        newNode.setPrevious(topPointer);
        newNode.setNext(null);
        topPointer = newNode;
        numberElements++;
    }

    /**
    * substitui o último elemento
    *@param data é o elemento a ser empilhado
    */
    @Override
    public void update(T data){
        pop();
        push(data);
    }

    /**
    * passa por toda pilha concatenando os elementos para printar
    *@return os elementos da pilha em uma String
    */
    @Override
    public String print(){
        String result = "";

        DoubleNode<T> auxPointer = topPointer;
        for(int i = 0; i < numberElements; i++){
            result += auxPointer.getData()
            auxPointer = auxPointer.getPrevious();
            //para acrescentar a virgula e impedi-la na última linha
            if(i != numberElements-1){
                resul+=",";
            }
        }

       return "[" + result + "]";
    }

}