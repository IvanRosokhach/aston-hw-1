package ru.aston.list;

import java.util.Arrays;
import java.util.Comparator;

public class CustomArrayList<E> implements CustomList<E> {
    /**
     * The initial capacity of the data array.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * The current size of list
     */
    private int size;
    /**
     * The array to store elements
     */
    private Object[] dataArray;

    /**
     * Constructor without parameters with an initial capacity of 10
     */
    public CustomArrayList() {
        this.dataArray = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Constructor with initial capacity
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if capacity is negative
     */
    public CustomArrayList(int capacity) {
        if (capacity > 0) {
            this.dataArray = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        }
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param e the element to be added to the list
     */
    @Override
    public boolean add(E e) {
        if (size == dataArray.length) {
            increaseCapacity();
        }
        dataArray[size] = e;
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
        checkIndex(index);
        if (size == dataArray.length) {
            increaseCapacity();
        }
        System.arraycopy(dataArray, index, dataArray, index + 1, size - index);
        dataArray[index] = e;
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
        checkIndex(index);
        return (E) dataArray[index];

    }

    /**
     * Removes the first occurrence of the specified element from this list.
     *
     * @param e the element to be removed
     */
    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size - 1; i++) {
            if (dataArray[i].equals(e)) {
                remove(i);
                return true;
            }
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
        checkIndex(index);
        System.arraycopy(dataArray, index + 1, dataArray, index, size - index - 1);
        size--;
    }

    /**
     * Removes all elements from this list.
     */
    @Override
    public void clear() {
        dataArray = new Object[DEFAULT_CAPACITY];
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
        Arrays.sort((E[]) dataArray, 0, size, comparator);
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

    /**
     * Increases the capacity of the list.
     */
    private void increaseCapacity() {
        int newCapacity = dataArray.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(dataArray, 0, newArray, 0, dataArray.length);
        dataArray = newArray;
    }

}