package implementation.circular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.linkedlistdatastructure.implementation.circular.CircularLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCircularLinkedList {

  @DisplayName("Should add to the beginning")
  @Test
  void shouldAddToTheBeginning() {
    var circularLinkedList = new CircularLinkedList();

    circularLinkedList.addAtTheBeginning(1);
    circularLinkedList.addAtTheBeginning(2);
    circularLinkedList.addAtTheBeginning(3);
    circularLinkedList.addAtTheBeginning(4);

    assertEquals(4, circularLinkedList.getHead().getValue());
    assertEquals(1, circularLinkedList.getTail().getValue());
    assertEquals(4, circularLinkedList.getTail().getNext().getValue());
    assertEquals(1, circularLinkedList.getHead().getPrevious().getValue());
  }

  @DisplayName("Should add to the end")
  @Test
  void shouldAddToTheEnd() {
    var circularLinkedList = new CircularLinkedList();

    circularLinkedList.addAtTheEnd(1);
    circularLinkedList.addAtTheEnd(2);
    circularLinkedList.addAtTheEnd(3);
    circularLinkedList.addAtTheEnd(4);

    assertEquals(4, circularLinkedList.getTail().getValue());
    assertEquals(1, circularLinkedList.getHead().getValue());
    assertEquals(1, circularLinkedList.getTail().getNext().getValue());
    assertEquals(4, circularLinkedList.getHead().getPrevious().getValue());
  }

  @DisplayName("Should insert at position")
  @Test
  void shouldInsertAtPosition() {
    var circularLinkedList = new CircularLinkedList();

    circularLinkedList.insertAtPosition(0, 1);
    circularLinkedList.insertAtPosition(0, 11);
    circularLinkedList.insertAtPosition(0, 12);
    circularLinkedList.insertAtPosition(1, 45);

    assertEquals(12, circularLinkedList.getHead().getValue());
    assertEquals(1, circularLinkedList.getHead().getPrevious().getValue());
    assertEquals(1, circularLinkedList.getTail().getValue());
    assertEquals(12, circularLinkedList.getTail().getNext().getValue());
    assertEquals(45, circularLinkedList.searchByIndex(1).getValue());

  }

  @DisplayName("Should delete by value")
  @Test
  void shouldDeleteByValue() {
    var circularLinkedList = new CircularLinkedList();

    circularLinkedList.addAtTheEnd(1);
    circularLinkedList.addAtTheEnd(2);
    circularLinkedList.addAtTheEnd(3);
    circularLinkedList.addAtTheEnd(4);

    var deletedValue = circularLinkedList.deleteByValue(45);

    assertNull(deletedValue);

    deletedValue = circularLinkedList.deleteByValue(1);
    assertNotNull(deletedValue);

    assertEquals(2, circularLinkedList.getHead().getValue());
    assertEquals(4, circularLinkedList.getHead().getPrevious().getValue());
    assertEquals(2, circularLinkedList.getTail().getNext().getValue());

    deletedValue = circularLinkedList.deleteByValue(4);
    assertNotNull(deletedValue);

    assertEquals(3, circularLinkedList.getTail().getValue());
  }

  @DisplayName("Should delete by position")
  @Test
  void shouldDeleteByPosition() {
    var circularLinkedList = new CircularLinkedList();

    circularLinkedList.addAtTheEnd(1);
    circularLinkedList.addAtTheEnd(2);
    circularLinkedList.addAtTheEnd(3);
    circularLinkedList.addAtTheEnd(4);

    var deletedValue = circularLinkedList.deleteByPosition(6);

    assertNull(deletedValue);

    deletedValue = circularLinkedList.deleteByPosition(0);
    assertNotNull(deletedValue);

    assertEquals(2, circularLinkedList.getHead().getValue());

    deletedValue = circularLinkedList.deleteByPosition(1);
    assertNotNull(deletedValue);
    
    assertEquals(2, circularLinkedList.getHead().getValue());
    assertEquals(4, circularLinkedList.getHead().getNext().getValue());
    assertEquals(2, circularLinkedList.getTail().getNext().getValue());
  }
}


