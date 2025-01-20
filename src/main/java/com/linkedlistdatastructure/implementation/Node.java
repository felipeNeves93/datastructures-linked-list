package com.linkedlistdatastructure.implementation;

public class Node {

  public Node(Integer value) {
    this.value = value;
    previous = null;
    next = null;
  }

  private Integer value;
  private Node previous;
  private Node next;

  public void setValue(int value) {
    this.value = value;
  }

  public void setPrevious(Node previous) {
    this.previous = previous;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public int getValue() {
    return this.value;
  }

  public Node getPrevious() {
    return this.previous;
  }

  public Node getNext() {
    return this.next;
  }

  @Override
  public String toString() {
    return "" + this.value;
  }
}
