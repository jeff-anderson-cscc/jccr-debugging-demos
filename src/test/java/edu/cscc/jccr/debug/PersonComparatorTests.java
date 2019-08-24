package edu.cscc.jccr.debug;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Jeff Anderson
 * @since 2019-08-24
 */
public class PersonComparatorTests {

  /*
  DESIRED BEHAVIOR:
  | person1.lastName  | person1.firstName | person2.lastName  | person1.firstName | returns
  | Anderson          | Jeff              | Anderson          | Jeff              | = 0
  | Anderson          | Jeff              | Smith             | Jeff              | < 0
  | Smith             | Jeff              | Anderson          | Jeff              | > 0
  | Anderson          | Andy              | Anderson          | Jeff              | < 0
  | Anderson          | Jeff              | Anderson          | Andy              | > 0
   */

  @Test
  @DisplayName("T01: Jeff Anderson vs. Jeff Anderson = 0")
  public void test01 () {
    Person person1 = new Person("Jeff", "Anderson");
    Person person2 = new Person("Jeff", "Anderson");
    PersonComparator personComparator = new PersonComparator();
    assertEquals(0, personComparator.compare(person1, person2),
      "Should have returned 0");
  }

  @Test
  @DisplayName("T02: Jeff Anderson vs. Jeff Smith < 0")
  public void test02 () {
    Person person1 = new Person("Jeff", "Anderson");
    Person person2 = new Person("Jeff", "Smith");
    PersonComparator personComparator = new PersonComparator();
    assertTrue(personComparator.compare(person1, person2) < 0,
      String.format("%s, %s vs. %s, %s should have returned < 0",
        person1.getLastName(), person1.getFirstName(),
        person2.getLastName(), person2.getFirstName()));
  }

  @Test
  @DisplayName("T03: Jeff Smith vs. Jeff Anderson > 0")
  public void test03 () {
    Person person1 = new Person("Jeff", "Smith");
    Person person2 = new Person("Jeff", "Anderson");
    PersonComparator personComparator = new PersonComparator();
    assertTrue(personComparator.compare(person1, person2) > 0,
      String.format("%s, %s vs. %s, %s should have returned > 0",
        person1.getLastName(), person1.getFirstName(),
        person2.getLastName(), person2.getFirstName()));
  }

  @Test
  @DisplayName("T04: Andy Anderson vs. Jeff Anderson < 0")
  public void test04 () {
    Person person1 = new Person("Andy", "Anderson");
    Person person2 = new Person("Jeff", "Anderson");
    PersonComparator personComparator = new PersonComparator();
    assertTrue(personComparator.compare(person1, person2) < 0,
      String.format("%s, %s vs. %s, %s should have returned < 0",
        person1.getLastName(), person1.getFirstName(),
        person2.getLastName(), person2.getFirstName()));
  }

  @Test
  @DisplayName("T04: Jeff Anderson vs. Andy Anderson > 0")
  public void test05 () {
    Person person1 = new Person("Jeff", "Anderson");
    Person person2 = new Person("Andy", "Anderson");
    PersonComparator personComparator = new PersonComparator();
    assertTrue(personComparator.compare(person1, person2) > 0,
      String.format("%s, %s vs. %s, %s should have returned > 0",
        person1.getLastName(), person1.getFirstName(),
        person2.getLastName(), person2.getFirstName()));
  }

}
