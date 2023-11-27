package ru.aston.list;

import java.util.Comparator;

public class CustomLinkedList<E> implements CustomList<E> {
    /**
     * Represents the first node in the linked list.
     */
    private Node<E> first;
    /**
     * Represents the last node in the linked list.
     */
    private Node<E> last;
    /**
     * The current size of list
     */
    private int size;

    /**
     * Adds the specified element to the end of this list.
     *
     * @param e the element to be added to the list
     */
    @Override
    public boolean add(E e) {
        if (size == 0) {
            first = new Node<>(e);
            last = first;
        } else {
            Node<E> newNode = new Node<>(e);
            newNode.previousNode = last;
            last.nextNode = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index the index at which the specified element is to be inserted
     * @param e     the element to be added to the list
     */
    @Override
    public boolean add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> node = findNodeByIndex(index);
        newNode.previousNode = node.previousNode;
        newNode.nextNode = node;
        node.previousNode.nextNode = newNode;
        node.previousNode = newNode;
        size++;
        return true;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public E get(int index) {
        Node<E> node = findNodeByIndex(index);
        return node.element;
    }

    /**
     * Returns the node at the specified index in the linked list.
     *
     * @param index the index of the node to find
     * @return the node at the specified index
     */
    private Node<E> findNodeByIndex(int index) {
        checkIndex(index);
        Node<E> node;
        int currentIndex;

        if (size / 2 > index) {
            currentIndex = 0;
            node = first;
            while (currentIndex != index) {
                node = node.nextNode;
                currentIndex++;
            }
        } else {
            currentIndex = size - 1;
            node = last;
            while (currentIndex != index) {
                node = node.previousNode;
                currentIndex--;
            }
        }

        return node;
    }

    /**
     * Removes the first occurrence of the specified element from this list.
     *
     * @param e the element to be removed
     */
    @Override
    public boolean remove(E e) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (node.element.equals(e)) {
                remove(i);
                return true;
            }
            node = node.nextNode;
        }
        return false;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     */
    @Override
    public void remove(int index) {
        Node<E> node = findNodeByIndex(index);
        if (index != size - 1) {
            node.nextNode.previousNode = node.previousNode;
        } else {
            node.previousNode.nextNode = null;
        }
        if (index != 0) {
            node.previousNode.nextNode = node.nextNode;
        } else {
            node.nextNode.previousNode = null;
        }
        node.element = null;
        node.previousNode = null;
        node.nextNode = null;
        size--;
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            Node<E> nextNode = node.nextNode;
            node.element = null;
            node.previousNode = null;
            node.nextNode = null;
            node = nextNode;
        }
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Sorts the elements of the list using the specified comparator.
     *
     * @param comparator the comparator to use for sorting
     */
    @Override
    public void sort(Comparator<? super E> comparator) {
        for (Node<E> i = first; i != null; i = i.nextNode) {
            Node<E> min = i;
            for (Node<E> j = i.nextNode; j != null; j = j.nextNode) {
                if (comparator.compare(j.element, min.element) < 0) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    /**
     * Swaps two elements in the list.
     *
     * @param a the first element to be swapped
     * @param b the second element to be swapped
     */
    private void swap(Node<E> a, Node<E> b) {
        if (a != b) {
            E temp = a.element;
            a.element = b.element;
            b.element = temp;
        }
    }

    /**
     * Checks if the specified index is within the bounds of the list.
     *
     * @param index the index to be checked
     * @throws ArrayIndexOutOfBoundsException if the index is out of bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of range!");
        }
    }

    private static class Node<T> {
        /**
         * Represents the value stored in the node.
         */
        T element;
        /**
         * Represents the next node.
         */
        Node<T> nextNode;
        /**
         * Represents the previous node.
         */
        Node<T> previousNode;

        /**
         * Constructs a node with the specified value.
         *
         * @param element the value to be stored in the node
         */
        Node(T element) {
            this.element = element;
            this.nextNode = null;
            this.previousNode = null;
        }
    }

}