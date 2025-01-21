package com.linkedlistdatastructure.implementation;

public interface LinkedListOperations {


  Node addAtTheEnd(int value);

  Node addAtTheBeginning(int value);

  /**
   * Will add a value at the determined index. Index starts at 0
   *
   * @param position The index to be added
   * @param value    The Value to be added
   * @return The added node
   */
  Node insertAtPosition(int position, int value);

  Node deleteByValue(int value);

  /**
   * Will delete a node at given position. Index starts at 0
   *
   * @param position The index to be deleted
   * @return The deleted node
   */
  Node deleteByPosition(int position);

  Node search(int value);

  Node searchByIndex(int index);

  void printList();

  int length();

}
