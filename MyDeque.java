public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
  }


  public int size(){
    return size;
  }
  public String toString(){
    String answer = "[";
    if(start > end)
    {
      for(int i = start; i < end; i ++)
      {
        answer += data[i] + ",";
      }
    }
    else
    {
      for(int i = start; i < data.length; i ++)
      {
        answer += data[i] + ",";
      }
      for(int i = 0; i < e; i ++)
      {
        answer += data[i] + ",";
      }
    }
    answer += data[end] + "]";
  }


  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(E element){ }
  public E removeLast(E element){ }
  public E getFirst(E element){ }
  public E getLast(E element){ }
}
