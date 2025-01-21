package implementation.doubly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.linkedlistdatastructure.implementation.doubly.DoublyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDoublyLinkedList {

  @DisplayName("Should add to the beginning")
  @Test
  void shouldAddToTheBeginning() {
    var doublyLinkedList = new DoublyLinkedList();

    doublyLinkedList.addAtTheBeginning(1);
    doublyLinkedList.addAtTheBeginning(2);
    doublyLinkedList.addAtTheBeginning(3);
    doublyLinkedList.addAtTheBeginning(4);

    assertEquals(4, doublyLinkedList.getHead().getValue());
    assertEquals(1, doublyLinkedList.getTail().getValue());
  }

  @DisplayName("Should add to the end")
  @Test
  void shouldAddToTheEnd() {
    var doublyLinkedList = new DoublyLinkedList();

    doublyLinkedList.addAtTheEnd(1);
    doublyLinkedList.addAtTheEnd(2);
    doublyLinkedList.addAtTheEnd(3);
    doublyLinkedList.addAtTheEnd(4);

    assertEquals(4, doublyLinkedList.getTail().getValue());
    assertEquals(1, doublyLinkedList.getHead().getValue());
  }

  @DisplayName("Should insert at position")
  @Test
  void shouldInsertAtPosition() {
    var doublyLinkedList = new DoublyLinkedList();

    doublyLinkedList.insertAtPosition(0, 1);
    doublyLinkedList.insertAtPosition(0, 11);
    doublyLinkedList.insertAtPosition(0, 12);
    doublyLinkedList.insertAtPosition(1, 45);

    assertEquals(12, doublyLinkedList.getHead().getValue());
    assertEquals(1, doublyLinkedList.getTail().getValue());
    assertEquals(45, doublyLinkedList.searchByIndex(1).getValue());

  }

  @DisplayName("Should delete by value")
  @Test
  void shouldDeleteByValue() {
    var doublyLinkedList = new DoublyLinkedList();

    doublyLinkedList.addAtTheEnd(1);
    doublyLinkedList.addAtTheEnd(2);
    doublyLinkedList.addAtTheEnd(3);
    doublyLinkedList.addAtTheEnd(4);

    var deletedValue = doublyLinkedList.deleteByValue(45);

    assertNull(deletedValue);

    deletedValue = doublyLinkedList.deleteByValue(1);
    assertNotNull(deletedValue);

    assertEquals(2, doublyLinkedList.getHead().getValue());

    deletedValue = doublyLinkedList.deleteByValue(4);
    assertNotNull(deletedValue);

    assertEquals(3, doublyLinkedList.getTail().getValue());
  }

  @DisplayName("Should delete by position")
  @Test
  void shouldDeleteByPosition() {
    var doublyLinkedList = new DoublyLinkedList();

    doublyLinkedList.addAtTheEnd(1);
    doublyLinkedList.addAtTheEnd(2);
    doublyLinkedList.addAtTheEnd(3);
    doublyLinkedList.addAtTheEnd(4);

    var deletedValue = doublyLinkedList.deleteByPosition(6);

    assertNull(deletedValue);

    deletedValue = doublyLinkedList.deleteByPosition(0);
    assertNotNull(deletedValue);

    assertEquals(2, doublyLinkedList.getHead().getValue());

    deletedValue = doublyLinkedList.deleteByPosition(1);
    assertNotNull(deletedValue);
    assertEquals(2, doublyLinkedList.getHead().getValue());
  }
}


