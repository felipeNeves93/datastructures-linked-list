package implementation.singly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.linkedlistdatastructure.implementation.singly.SinglyLinkedList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestSinglyLinkedList {

  @DisplayName("Should add to the beginning")
  @Test
  void shouldAddToTheBeginning() {
    var singlyLinkedList = new SinglyLinkedList();

    singlyLinkedList.addAtTheBeginning(1);

    assertEquals(1, singlyLinkedList.length());

    var searchedNode = singlyLinkedList.search(1);

    assertEquals(1, searchedNode.getValue());
    assertNull(searchedNode.getNext());
  }

  @DisplayName("Should add to the end")
  @Test
  void shouldAddToTheEnd() {
    var singlyLinkedList = new SinglyLinkedList();

    singlyLinkedList.addAtTheEnd(1);

    assertEquals(1, singlyLinkedList.length());

    var searchedNode = singlyLinkedList.search(1);

    assertEquals(1, searchedNode.getValue());
    assertNull(searchedNode.getNext());
  }

  @DisplayName("Should insert at position")
  @Test
  void shouldInsertAtPosition() {
    var singlyLinkedList = new SinglyLinkedList();

    singlyLinkedList.addAtTheEnd(1);
    singlyLinkedList.addAtTheBeginning(4);
    singlyLinkedList.addAtTheBeginning(2);
    singlyLinkedList.insertAtPosition(1, 3);

    assertEquals(4, singlyLinkedList.length());

    singlyLinkedList.printList();

    var searchedNode = singlyLinkedList.search(3);

    assertEquals(3, searchedNode.getValue());
    assertEquals(4, searchedNode.getNext().getValue());
  }

  @DisplayName("Should delete by value")
  @Test
  void shouldDeleteByValue() {
    var singlyLinkedList = new SinglyLinkedList();

    singlyLinkedList.addAtTheBeginning(1);
    singlyLinkedList.addAtTheBeginning(2);
    singlyLinkedList.addAtTheBeginning(3);
    singlyLinkedList.addAtTheBeginning(4);

    assertEquals(4, singlyLinkedList.length());

    singlyLinkedList.deleteByValue(3);

    assertEquals(3, singlyLinkedList.length());
    assertNull(singlyLinkedList.search(3));
  }

  @DisplayName("Should delete the first element")
  @Test
  void shouldDeleteTheFirstElement() {
    var singlyLinkedList = new SinglyLinkedList();

    singlyLinkedList.addAtTheBeginning(1);
    singlyLinkedList.addAtTheEnd(2);
    singlyLinkedList.addAtTheEnd(3);
    singlyLinkedList.addAtTheEnd(4);

    assertEquals(4, singlyLinkedList.length());
    singlyLinkedList.printList();

    singlyLinkedList.deleteByValue(1);
    singlyLinkedList.printList();

    assertEquals(3, singlyLinkedList.length());
    assertNull(singlyLinkedList.search(1));

  }

  @DisplayName("Should delete by index")
  @Test
  void shouldDeleteByIndex() {
    var singlyLinkedList = new SinglyLinkedList();

    singlyLinkedList.addAtTheBeginning(1);
    singlyLinkedList.addAtTheEnd(2);
    singlyLinkedList.addAtTheEnd(3);
    singlyLinkedList.addAtTheEnd(4);

    assertEquals(4, singlyLinkedList.length());
    singlyLinkedList.printList();

    singlyLinkedList.deleteByPosition(0);
    singlyLinkedList.printList();

    assertEquals(3, singlyLinkedList.length());
    assertNull(singlyLinkedList.search(1));

    singlyLinkedList.deleteByPosition(2);
    singlyLinkedList.printList();

    assertNull(singlyLinkedList.search(4));
  }
}


