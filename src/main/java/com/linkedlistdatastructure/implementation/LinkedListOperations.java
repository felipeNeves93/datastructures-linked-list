package com.linkedlistdatastructure.implementation;

public interface LinkedListOperations {


  Node addAtTheEnd(int value);

  Node addAtTheBeginning(int value);

  Node insertAtPosition(int position, int value);

  Node deleteByValue(int value);

  Node deleteByPosition(int position);

  Node search(int value);

  void printList();

  int length();

}
