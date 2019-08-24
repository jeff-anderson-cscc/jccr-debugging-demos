package edu.cscc.jccr.debug;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * @author Jeff Anderson
 * @since 2019-08-24
 */
public class Stack<E> {

  ArrayList<E> arrayList = new ArrayList<>();
  int size = 0;

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(E element) {
    arrayList.add(size, element);
    size += 1;
  }

  public E pop() {
    E element = arrayList.remove(size);
    size -= 1;
    return element;
  }

}
