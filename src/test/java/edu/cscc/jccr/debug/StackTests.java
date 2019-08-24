package edu.cscc.jccr.debug;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Jeff Anderson
 * @since 2019-08-24
 */
public class StackTests {

  @Test
  @DisplayName("T01: Stack is empty on create")
  public void test01 () {
    Stack<String> stack = new Stack<>();
    assertEquals(0,stack.size);
  }

  @Test
  @DisplayName("T02: Size is one after one item pushed")
  public void test02 () {
    Stack<String> stack = new Stack<>();
    stack.push("Stacks");
    assertEquals(1,stack.size);
  }

  @Test
  @DisplayName("T03: Size goes back to zero after push and pop")
  public void test03 () {
    Stack<String> stack = new Stack<>();
    stack.push("Stacks");
    assertEquals(1,stack.size);
    assertEquals("Stacks",stack.pop());
    assertEquals(0,stack.size);
  }

  @Test
  @DisplayName("T04: pop returns last item pushed")
  public void test04 () {
    Stack<String> stack = new Stack<>();
    String[] strings = { "Stacks", "Are", "Fun!" };
    stack.push(strings[0]);
    assertEquals(1,stack.size);
    stack.push(strings[1]);
    assertEquals(2,stack.size);
    stack.push(strings[2]);
    assertEquals(3,stack.size);
    assertEquals(strings[2],stack.pop());
    assertEquals(2,stack.size);
    assertEquals(strings[1],stack.pop());
    assertEquals(1,stack.size);
    assertEquals(strings[0],stack.pop());
    assertEquals(0,stack.size);
  }

  @Test
  @DisplayName("T05: Cannot pop off an empty stack")
  public void test05 () {
    Stack<Integer> stack = new Stack<>();
    assertThrows(EmptyStackException.class, () -> stack.pop(),
      "Expected EmptyStackException to be thrown");
  }

}
