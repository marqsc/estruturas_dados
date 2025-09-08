//Lista Estática

/*
C = void insert (Object data, int LogicIndex) 
  = void append (Object data) 

R = Object select (int LogicIndex) 
  = Object[] selectAll()

U = void update (Objeto data, int LogicIndex)

D = Object delete(int LogicIndex)
  = void clear()

S = sort
*/

public interface Listable {

  void insert (Object data, int LogicIndex);
  void append (Object data) ;
  Object select (int LogicIndex); 
  Object[] selectAll();
  void update (Object data, int LogicIndex);
  Object delete(int LogicIndex);
  void clear();

  boolean isEmpty();
  boolean isFull();
  String print();
}
