import java.util.*;

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

  boolean isEmpty = (size == 0);

  private void resize(){
    if(size == data.length)
    {
      if(start == end + 1)
      {
        @SuppressWarnings("unchecked")
        E[] thingie = (E[]) new Object[(data.length + 1) * 2];
        int increment = 0;
        for(int s = start; s < data.length; s ++, increment ++)
        {
          thingie[increment] = data[s];
        }
        for(int e = 0; e < end + 1; e ++, increment ++)
        {
          thingie[increment] = data[e];
        }
        data = thingie;
        start = 0;
        end = increment;
      }
      else if(start == end) // should only happen if initial array had only one element;
      {
        @SuppressWarnings("unchecked")
        E[] thingie = (E[]) new Object[(data.length + 1) * 2];
        data[0] = data[start];
      }
    }
  }
  public int size(){
    return size;
  }
  public String toString(){
    String answer = "{";
    if(start > end)
    {
      for(int i = start; i < end; i ++)
      {
        if(data[i] != null)
        answer += data[i] + ",";
      }
    }
    else
    {
      for(int i = start; i < data.length; i ++)
      {
        if(data[i] != null)
        answer += data[i] + ",";
      }
      for(int i = 0; i < end; i ++)
      {
        if(data[i] != null)
        answer += data[i] + ",";
      }
    }
    if(data[data.length - 1] != null)
    {
      answer += data[end];
    }
    answer += "}";
    return answer;
  }


  public void addFirst(E element){
    if(element == null)
    throw new NullPointerException();
    else
    {
      resize();
      if(start != 0)
      {
        start --;
        data[start] = element;
        size ++;
      }
      else
      {
        start = data.length - 1;
        data[start] = element;
        size ++;
      }
      resize();
    }
  }
  public void addLast(E element){
    if(element == null)
    throw new NullPointerException();
    else
    {
      resize();
      if(end != data.length - 1)
      {
        end ++;
        data[end] = element;
        size ++;
      }
      else
      {
        end = 0;
        data[end] = element;
        size ++;
      }
      resize();
    }
  }
  public E removeFirst(){
    if(!isEmpty)
    {
      int holder = start;
      if(start == data.length - 1)
      {
        start = 0;
        size --;
      }
      else
      {
        start ++;
        size --;
      }
      return data[holder];
    }
    // return null; // if no elements in list
    else
    {
      throw new NoSuchElementException();
    }

  }
  public E removeLast(){
    if(!isEmpty)
    {
      int holder = end;
      if(end == 0)
      {
        end = data.length - 1;
        size --;
      }
      else
      {
        end --;
        size --;
      }
      return data[holder];
    }
    // return null; // if list is empty
    else
    {
      throw new NoSuchElementException();
    }
  }
  public E getFirst(){
    if(data[start] != null)
    return data[start];
    else
    throw new NoSuchElementException();
  }
  public E getLast(){
    if(data[end] != null)
    return data[end];
    else
    throw new NoSuchElementException();
  }
}
