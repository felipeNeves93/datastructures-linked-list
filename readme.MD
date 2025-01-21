# Linked Lists

* **What is a Linked List?**
    * A linear data structure composed by nodes that are linked together using
      pointers. Each node consists usually of two variables: **value**, which
      is the current value of the node, and **next** which is the next value pointed in the list
* **Main types of Linked lists**
    * **Singly Linked List:** Each value of the node points to the next one, forming a
      unidirectional chain
    * **Doubly Linked List:** Each node now in addition to pointing to the next node, also points to
      the previous node, allowing that the list be traversed in both directions.
    * **Circular Linked List:** Allows traversal in both directions and this time, the last node
      points to the first node, creating a circular structure.
* **Key Operations**
    * **Insertion:** Allows a node to be added at the beginning, end, or specific position.
    * **Deletion:** Removes a node based on its position or value
    * **Traversal:** Visit each node
    * **Search:** Check if a value exists in the list or not
* **Advantages**
    * Efficient deletion, as it does not require shifting the position of elements, only changing
      the pointers.
    * Dynamic memory allocation
* **Disavantages**
    * Higher memory usage because of the utilization of pointers
    * Sequential access, not allowing the access of a direct element
* **Implementations**
    * _Links_
        * [Singly](https://github.com/felipeNeves93/datastructures-linked-list/blob/master/src/main/java/com/linkedlistdatastructure/implementation/singly/SinglyLinkedList.java)
        * [Doubly](https://github.com/felipeNeves93/datastructures-linked-list/blob/master/src/main/java/com/linkedlistdatastructure/implementation/doubly/DoublyLinkedList.java)
        * [Circular](https://github.com/felipeNeves93/datastructures-linked-list/blob/master/src/main/java/com/linkedlistdatastructure/implementation/circular/CircularLinkedList.java)
    * **Details**
        * In the implementation folder i added all the implementations regarding the different types
          of linked lists.
        * I created a interface called _LinkedListOperations_ that will contain all the main
          operations
          from linked lists
        * Each type of linked list will implement this interface
        * I created an abstract class called _LinkedListStructure that will provide the head and
          tail variables for all the implementations_
        * The _Node_ class will be used in all implementations as well.
        * There are tests for each linked list type in the _src/test/java/implementation_ with the
          common
          operations
          implemented.