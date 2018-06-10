package com.inguarus;

public class IntArrayList extends BaseList implements IntList {

    private int[] arr = new int[10];
    private int resizeCounter;


    @Override
    public void add(int element) {
        if (size >= arr.length) {
            resize();
        }
        arr[size] = element;
        size++;
    }

    private void resize() {
        int newSize = arr.length * 3 / 2 + 1;
        int[] newArr = new int[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
        resizeCounter++;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        return arr[index];
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (size >= arr.length) {
            resize();
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean removeElement(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                System.arraycopy(arr, i + 1, arr, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;

    }

    @Override
    public void set(int index, int element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }


    public int[] makeArrayFromIntList(IntList list) {
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }


    public IntList makeIntListFromArray(int[] array) {
        IntList resultIntList = new IntArrayList();
        for (int anArray : array) {
            resultIntList.add(anArray);
        }
        return resultIntList;
    }

    int getResizeCounter() {
        return resizeCounter;
    }

}

