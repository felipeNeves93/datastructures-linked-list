package com.linkedlistdatastructure.implementation.singly;

import com.linkedlistdatastructure.implementation.LinkedListDataStructure;
import com.linkedlistdatastructure.implementation.Node;

public class SinglyLinkedList implements LinkedListDataStructure {

  private Node node;

  @Override
  public Node addAtTheEnd(int value) {
    System.out.println("Adding at the end of the list: " + value);
    var currentNode = this.node;

    if (currentNode == null) {
      this.node = new Node(value);
      return this.node;
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

    if (this.node == null) {
      this.node = new Node(value);
      return node;
    }

    var nodeToAdd = new Node(value);
    nodeToAdd.setNext(this.node);

    this.node = nodeToAdd;

    return this.node;
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
    var currentNode = this.node;
    var previousNode = this.node;

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
      if (this.node.getValue() == value) {
        var deletedNode = this.node;

        this.node = this.node.getNext();
        return deletedNode;
      }

      var currentNode = this.node;
      var previousNode = this.node;

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
      var deletedNode = this.node;
      this.node = this.node.getNext();

      System.out.println("Deleting the value: " + deletedNode.getValue() + " at index " + index);
      return deletedNode;
    }

    var currentNode = this.node;
    var previousNode = this.node;
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
      var currentNode = this.node;

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
  public void printList() {
    var currentNode = this.node;

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
    var currentNode = this.node;

    while (currentNode != null) {
      currentNode = currentNode.getNext();
      length++;
    }

    return length;
  }
}
