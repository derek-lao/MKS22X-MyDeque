import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
  }

  private void resize(){
    if(size == data.length)
    {
      @SuppressWarnings("unchecked")
      E[] thingie = (E[]) new Object[(data.length + 1) * 2];
      if(start == end + 1)
      {
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
        thingie[0] = data[start];
        data = thingie;
      }
      else if(start < end) // happens if you had added your numbers to your array in order from index 0 to index data.length - 1
      {
        for(int s = 0; s < end + 1; s ++)
        {
          thingie[s] = data[s];
          data = thingie;
        }
      }
    }
  }

  public int size(){
    return size;
  }
  public String toString(){
    String answer = "{";
    if(start < end)
    {
      for(int i = start; i < end; i ++)
      {
        if(data[i] != null)
        answer += data[i] + ",";
      }
      if(data[end] != null)
      {
        answer += data[end];
      }
    }
    else if(start > end)
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
      if(data[end] != null)
      {
        answer += data[end];
      }
    }
    else
    {
      if(data[start] != null)
      answer += data[start];
    }
    answer += "}";
    return answer;
  }


  public void addFirst(E element){
    System.out.println("Size is " + size);
    System.out.println("data.length is " + data.length);
    System.out.println("Attempted added element is " + element);
    if(element == null)
    throw new NullPointerException();
    else if(size == 0)
    {
      resize();
      data[start] = element;
      size ++;
    }
    else
    {
      System.out.println("My array before first resize is " + this.toString());
      resize();
      System.out.println("My array after the first resize but before adding first is " + this.toString());
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
      System.out.println("My array after the first resize and after adding first is " + this.toString());
      resize();
      System.out.println("My array after the second resize and after adding first is " + this.toString());
    }
  }

  public void addLast(E element){
    System.out.println("Size is " + size);
    System.out.println("data.length is " + data.length);
    System.out.println("Attempted added element is " + element);
    if(element == null)
    throw new NullPointerException();
    else if(size == 0)
    {
      resize();
      data[end] = element;
      size ++;
      resize();
    }
    else
    {
      System.out.println("My array before first resize is " + this.toString());
      resize();
      System.out.println("My array after the first resize but before adding last is " + this.toString());
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
      System.out.println("My array after the first resize and after adding last is " + this.toString());
      resize();
      System.out.println("My array after the second resize and after adding last is " + this.toString());
    }
  }
  public E removeFirst(){
    if(size > 0)
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
    if(size > 0)
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

  public static void main(String[] args){
    try
    {
      MyDeque<Integer> thing = new MyDeque<Integer>(3);
      for(int i = 0; i < 4; i ++)
      {
        thing.addLast(i);
        System.out.println();
      }
    }
    catch(Exception e)
    {
      System.out.println(e.toString());
    }
  }
}
