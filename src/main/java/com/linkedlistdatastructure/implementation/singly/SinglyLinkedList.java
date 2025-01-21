package com.linkedlistdatastructure.implementation.singly;

import com.linkedlistdatastructure.implementation.LinkedListOperations;
import com.linkedlistdatastructure.implementation.LinkedListStructure;
import com.linkedlistdatastructure.implementation.Node;

public class SinglyLinkedList extends LinkedListStructure implements LinkedListOperations {

  @Override
  public Node addAtTheEnd(int value) {
    System.out.println("Adding at the end of the list: " + value);
    var currentNode = this.head;

    if (currentNode == null) {
      this.head = new Node(value);
      return this.head;
    }

    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }

    var nodeToInsert = new Node(value);
    currentNode.setNext(nodeToInsert);

    return nodeToInsert;
  }

  @Override
  public Node addAtTheBeginning(int value) {
    System.out.println("Adding at the beginning of the list: " + value);

    if (this.head == null) {
      this.head = new Node(value);
      return this.head;
    }

    var nodeToAdd = new Node(value);
    nodeToAdd.setNext(this.head);

    this.head = nodeToAdd;

    return this.head;
  }

  @Override
  public Node insertAtPosition(int position, int value) {
    var listLength = this.length();

    if (position < 0 || position > listLength) {
      System.out.println("Index out of range!");
      return null;
    }

    if (position == 0) {
      return this.addAtTheBeginning(value);
    }

    if (position == listLength - 1) {
      return this.addAtTheEnd(value);
    }

    var currentPosition = 0;

    var newNode = new Node(value);
    var currentNode = this.head;
    var previousNode = this.head;

    while (currentPosition < position) {
      previousNode = currentNode;
      currentNode = currentNode.getNext();
      currentPosition++;
    }

    newNode.setNext(currentNode);
    previousNode.setNext(newNode);

    return currentNode;
  }

  @Override
  public Node deleteByValue(int value) {
    if (length() > 0) {
      // if it is the head node
      if (this.head.getValue() == value) {
        var deletedNode = this.head;

        this.head = this.head.getNext();
        return deletedNode;
      }

      var currentNode = this.head;
      var previousNode = this.head;

      while (currentNode != null) {
        if (currentNode.getValue() == value) {
          System.out.println(value + " Deleted from the list!");

          previousNode.setNext(currentNode.getNext());
          return currentNode;
        }
        previousNode = currentNode;
        currentNode = currentNode.getNext();
      }

      System.out.println("Value: " + value + " not found on list!");
      return null;
    } else {
      System.out.println("Empty List!");
      return null;
    }
  }

  @Override
  public Node deleteByPosition(int index) {
    var listLength = this.length();

    if (index == listLength || index < 0) {
      System.out.println("Invalid index!");
      return null;
    }

    if (index == 0) {
      var deletedNode = this.head;
      this.head = this.head.getNext();

      System.out.println("Deleting the value: " + deletedNode.getValue() + " at index " + index);
      return deletedNode;
    }

    var currentNode = this.head;
    var previousNode = this.head;
    var currentIndex = 0;

    while (currentIndex != index) {
      previousNode = currentNode;
      currentNode = currentNode.getNext();

      currentIndex++;
    }

    System.out.println("Deleting the value: " + currentNode.getValue() + " at index " + index);
    previousNode.setNext(currentNode.getNext());
    return currentNode;
  }

  @Override
  public Node search(int value) {
    if (length() > 0) {
      var currentNode = this.head;

      while (currentNode != null) {
        if (currentNode.getValue() == value) {
          System.out.println(value + " found on the list!");
          return currentNode;
        }
        currentNode = currentNode.getNext();
      }

      System.out.println("Value: " + value + " not found on list!");
      return null;
    } else {
      System.out.println("Empty List!");
      return null;
    }
  }

  @Override
  public Node searchByIndex(int index) {
    var listLength = this.length();

    if (listLength == 0) {
      System.out.println("Empty list!");
      return null;
    }

    if (index < 0 || index >= listLength) {
      System.out.println("Invalid index !");
      return null;
    }

    var currentNode = this.head;
    var currentIndex = 0;

    while (currentIndex <= index) {
      if (currentIndex == index) {
        return currentNode;
      }
      currentNode = currentNode.getNext();
      currentIndex++;
    }

    return null;
  }

  @Override
  public void printList() {
    var currentNode = this.head;

    if (currentNode == null) {
      System.out.println("Empty List!");
      return;
    }

    var result = new StringBuilder();
    while (currentNode != null) {
      result.append(currentNode.getValue()).append(" -> ");
      currentNode = currentNode.getNext();
    }
    result.append("null");
    System.out.println(result);
  }

  @Override
  public int length() {
    var length = 0;
    var currentNode = this.head;

    while (currentNode != null) {
      currentNode = currentNode.getNext();
      length++;
    }

    return length;
  }
}
