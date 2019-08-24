package edu.cscc.jccr.debug;

/**
 * @author Jeff Anderson
 * @since 2019-08-24
 */
public class Person {

  private String firstName;
  private String lastName;


  public Person () {

  }


  public Person (String firstName, String lastName) {

    this.firstName = firstName;
    this.lastName = lastName;
  }


  public String getFirstName () {

    return firstName;
  }


  public void setFirstName (String firstName) {

    this.firstName = firstName;
  }


  public String getLastName () {

    return lastName;
  }


  public void setLastName (String lastName) {

    this.lastName = lastName;
  }

}
