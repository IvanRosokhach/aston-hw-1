package ru.aston.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class CustomLinkedListTest {

    @Test
    void testAdd() {
        CustomList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Banana", list.get(1));
        Assertions.assertEquals("Orange", list.get(2));
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void testAddAtIndex() {
        CustomList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.add(1, "Mango");

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Mango", list.get(1));
        Assertions.assertEquals("Banana", list.get(2));
        Assertions.assertEquals("Orange", list.get(3));
        Assertions.assertEquals(4, list.size());
    }

    @Test
    void testGet() {
        CustomList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Banana", list.get(1));
        Assertions.assertEquals("Orange", list.get(2));
    }

    @Test
    void testRemove() {
        CustomList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.remove("Banana");

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Orange", list.get(1));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testRemoveWithIndex() {
        CustomList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.remove(1);

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Orange", list.get(1));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testClear() {
        CustomList<String> list = new CustomLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.clear();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testSort() {
        CustomList<Integer> list = new CustomLinkedList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        list.sort(Comparator.naturalOrder());

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(2, list.get(1));
        Assertions.assertEquals(5, list.get(2));
        Assertions.assertEquals(8, list.get(3));
    }

}