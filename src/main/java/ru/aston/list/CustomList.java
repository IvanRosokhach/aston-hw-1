package ru.aston.list;

import java.util.Comparator;

public interface CustomList<E> {

    boolean add(E e);

    boolean add(int index, E e);

    E get(int index);

    boolean remove(E e);

    void remove(int index);

    void clear();

    int size();

    void sort(Comparator<? super E> comparator);

}