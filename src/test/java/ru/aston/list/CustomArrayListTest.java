package ru.aston.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class CustomArrayListTest {

    @Test
    void testAdd() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals(3, list.size());
    }

    @Test
    void testAddAtIndex() {
        CustomList<Integer> list = new CustomArrayList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 5);
        list.add(2, 4);
        list.add(2, 3);

        Assertions.assertEquals(3, list.get(2));
        Assertions.assertEquals(4, list.get(3));
        Assertions.assertEquals(5, list.get(4));
    }

    @Test
    void testGet() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Assertions.assertEquals("Apple", list.get(0));
        Assertions.assertEquals("Banana", list.get(1));
        Assertions.assertEquals("Orange", list.get(2));
    }

    @Test
    void testRemove() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.remove("Banana");

        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testRemoveWithIndex() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.remove(1);

        Assertions.assertEquals(2, list.size());
    }

    @Test
    void testClear() {
        CustomList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.clear();

        Assertions.assertEquals(0, list.size());
    }

    @Test
    void testSort() {
        CustomList<Integer> list = new CustomArrayList<>();
        list.add(5);
        list.add(1);
        list.add(8);
        list.add(10);

        list.sort(Comparator.naturalOrder());

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(5, list.get(1));
        Assertions.assertEquals(8, list.get(2));
        Assertions.assertEquals(10, list.get(3));
    }

}