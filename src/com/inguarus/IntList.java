package com.inguarus;

public interface IntList {

    void add(int element);

    void add(int index, int element);

    void clear();

    boolean contains(int element);

    int get(int index);

    boolean isEmpty();

    boolean remove(int index);

    boolean removeElement(int element);

    void set(int index, int element);

    int size();

    int[] makeArrayFromIntList(IntList list);

    IntList makeIntListFromArray(int[] array);
}

