package com.linkedlistdatastructure.implementation.circular;

import com.linkedlistdatastructure.implementation.LinkedListOperations;
import com.linkedlistdatastructure.implementation.LinkedListStructure;
import com.linkedlistdatastructure.implementation.Node;

public class CircularLinkedList extends LinkedListStructure implements LinkedListOperations {

  @Override
  public Node addAtTheEnd(int value) {
    System.out.println("Adding " + value + " to the end of the list!");
    var nodeToAdd = new Node(value);
    if (this.head == null) {
      this.head = nodeToAdd;
      this.tail = nodeToAdd;

      this.head.setNext(this.tail);
      this.head.setPrevious(this.tail);

      printList();

      return nodeToAdd;
    }

    var currentNode = this.head;

    while (!currentNode.getNext().equals(this.head)) {
      currentNode = currentNode.getNext();
    }

    currentNode.setNext(nodeToAdd);
    nodeToAdd.setPrevious(currentNode);
    this.head.setPrevious(nodeToAdd);
    nodeToAdd.setNext(this.head);

    this.tail = nodeToAdd;

    printList();

    return nodeToAdd;
  }

  @Override
  public Node addAtTheBeginning(int value) {
    var nodeToAdd = new Node(value);
    if (head == null) {
      this.head = nodeToAdd;
      this.tail = nodeToAdd;

      this.head.setNext(this.tail);
      this.head.setPrevious(this.tail);

      this.printList();
      return nodeToAdd;
    }

    var currentNode = this.head;
    currentNode.setPrevious(nodeToAdd);
    nodeToAdd.setNext(currentNode);

    nodeToAdd.setPrevious(this.tail);
    this.tail.setNext(nodeToAdd);

    this.head = nodeToAdd;
    printList();

    return nodeToAdd;

  }

  @Override
  public Node insertAtPosition(int position, int value) {
    var listLength = length();

    if (position < 0 || position > listLength) {
      System.out.println("Invalid index!");
      return null;
    }

    if (position == 0) {
      return this.addAtTheBeginning(value);
    }

    if (position == listLength - 1) {
      return this.addAtTheEnd(value);
    }

    var nodeToAdd = new Node(value);
    var currentIndex = 0;
    var currentNode = this.head;

    while (currentIndex < position) {
      currentNode = currentNode.getNext();
      currentIndex++;
    }

    var previous = currentNode.getPrevious();

    nodeToAdd.setNext(currentNode);
    currentNode.setPrevious(nodeToAdd);

    previous.setNext(nodeToAdd);
    nodeToAdd.setPrevious(previous);

    System.out.println("Inserted " + value + " at position " + position);
    printList();
    return nodeToAdd;
  }

  @Override
  public Node deleteByValue(int value) {
    var listLength = length();

    if (listLength == 0) {
      System.out.println("Empty list!");
      return null;
    }

    System.out.println("Deleting value: " + value + " from the list");
    var currentNode = this.head;

    while (currentNode.getNext() != null) {
      if (currentNode.getValue() == value) {
        if (listLength == 1) {
          this.head = null;
          this.tail = null;

          printList();
          return currentNode;
        }

        var nextNode = currentNode.getNext();
        var previousNode = currentNode.getPrevious();

        // Means that it is the tail
        if (currentNode.getNext().equals(this.head)) {
          previousNode.setNext(currentNode.getNext());

          this.head.setPrevious(previousNode);
          this.tail = previousNode;

          printList();
          return currentNode;
        }

        // Means that it is the head
        if (currentNode.getPrevious().equals(this.tail)) {
          nextNode.setPrevious(currentNode.getPrevious());
          previousNode.setNext(nextNode);

          this.head = nextNode;

          printList();
          return currentNode;
        }

        previousNode.setNext(currentNode.getNext());
        nextNode.setPrevious(previousNode);

        printList();
        return currentNode;
      }

      currentNode = currentNode.getNext();
      if (currentNode.equals(this.head)) {
        break;

      }
    }

    System.out.println("Value " + value + " not found on the list!");
    return null;
  }

  @Override
  public Node deleteByPosition(int position) {

    var listLength = length();

    if (listLength == 0) {
      System.out.println("Empty list!");
      return null;
    }

    if (position < 0 || position > listLength - 1) {
      System.out.println("Invalid index!");
      return null;
    }

    System.out.println("Deleting value at index: " + position + " from the list");

    var currentIndex = 0;
    var currentNode = this.head;

    while (currentIndex <= position) {
      if (currentIndex == position) {
        if (listLength == 1) {
          this.head = null;
          this.tail = null;

          printList();
          return currentNode;
        }

        var nextNode = currentNode.getNext();
        var previousNode = currentNode.getPrevious();

        // Means that it is the tail
        if (currentNode.getNext().equals(this.head)) {
          previousNode.setNext(currentNode.getNext());

          this.head.setPrevious(previousNode);
          this.tail = previousNode;

          printList();
          return currentNode;
        }

        // Means that it is the head
        if (currentNode.getPrevious().equals(this.tail)) {
          nextNode.setPrevious(currentNode.getPrevious());
          previousNode.setNext(nextNode);

          this.head = nextNode;

          printList();
          return currentNode;
        }

        previousNode.setNext(currentNode.getNext());
        nextNode.setPrevious(previousNode);

        printList();
        return currentNode;

      }

      currentNode = currentNode.getNext();
      currentIndex++;
    }
    return null;
  }

  @Override
  public Node search(int value) {
    var currentNode = this.head;

    while (currentNode.getNext() != null) {
      if (currentNode.getValue() == value) {
        return currentNode;
      }
      currentNode = currentNode.getNext();
      if (currentNode.getNext().equals(this.head)) {
        break;
      }
    }

    System.out.println("Value " + value + " Not found at the list!");
    return null;
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
    if (this.head == null) {
      System.out.println("Empty List!");
    }

    this.printForwardTraversal();
    this.printBackwardTraversal();
  }

  private void printForwardTraversal() {
    var headNode = this.head;

    var forwardResults = new StringBuilder();

    while (headNode != null) {
      forwardResults.append(headNode.getValue()).append(" -> ");
      headNode = headNode.getNext();

      if (headNode.equals(this.head)) {
        break;
      }
    }

    System.out.println("Forward traversal: " + forwardResults);
  }

  private void printBackwardTraversal() {
    var tailNode = this.tail;

    var backwardResults = new StringBuilder();

    while (tailNode != null) {
      backwardResults.append(tailNode.getValue()).append(" <- ");
      tailNode = tailNode.getPrevious();

      if (tailNode.equals(this.tail)) {
        break;
      }
    }

    System.out.println("Backward traversal: " + backwardResults);
  }

  @Override
  public int length() {
    if (this.head == null) {
      return 0;
    }

    var currentIndex = 1;
    var currentNode = this.head;

    while (!currentNode.getNext().equals(this.head)) {
      currentIndex++;
      currentNode = currentNode.getNext();

      if (currentNode.equals(this.tail)) {
        break;
      }
    }

    return currentIndex;
  }
}
