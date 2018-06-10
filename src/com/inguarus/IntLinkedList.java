package com.inguarus;

public class IntLinkedList extends BaseList implements IntList {

    private Node first;
    private Node last;

    private static class Node {
        int element;
        Node next;
        Node previous;

        private Node(int element) {
            this.element = element;
        }

        private Node() {
        }
    }

    @Override
    public void add(int element) {
        Node newNode = new Node(element);
        if (first == null) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
            size++;
            return;
        } else if (index == size - 1) {
            newNode.previous = last;
            last.next = newNode;
            last = newNode;
            size++;
            return;
        }
        Node oldNode = first;
        for (int i = 0; i < index; i++) {
            oldNode = oldNode.next;
        }
        Node oldPrevious = oldNode.previous;
        oldPrevious.next = newNode;
        oldNode.previous = newNode;
        newNode.previous = oldPrevious;
        newNode.next = oldNode;
        size++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (get(i) == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }

        return result.element;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;

    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            first = first.next;
        } else {
            Node node = findNodeBeforeByIndex(index);
            Node tmp = findByIndex(index);
            node.next = tmp.next;
        }
        size--;
        return false;
    }

    @Override
    public boolean removeElement(int element) {

        if (size == 0) {
            return false;
        } else if (size == 1) {
            first = null;
            last = null;
            size = 0;
            return true;
        }

        Node nodeBefore = findNodeBefore(element);

        if (nodeBefore.element == 0) {
            first = first.next;
            size--;
            return true;
        } else if (nodeBefore != null) {
            if (last.element == element) {
                nodeBefore.next = null;
                last = nodeBefore;
            } else {
                nodeBefore.next = nodeBefore.next.next;
            }
            size--;
            return true;
        }
        return false;
    }


    @Override
    public void set(int index, int element) {
        findByIndex(index).element = element;
    }

    @Override
    public int[] makeArrayFromIntList(IntList list) {
        int[] resultArray = new int[list.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = list.get(i);
        }
        return resultArray;
    }

    @Override
    public IntList makeIntListFromArray(int[] array) {
        IntList resultIntList = new IntArrayList();
        for (int anArray : array) {
            resultIntList.add(anArray);
        }
        return resultIntList;
    }


    private Node findByIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int tmpIndex = 0;
        if (first == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first;
        }

        Node node = first;
        while (node.next != null) {
            node = node.next;
            tmpIndex++;
            if (tmpIndex == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private Node findNodeBefore(int value) {
        if (first.element == value) {
            return new Node();
        }

        Node node = first;
        while (node.next != null) {
            if (node.next.element == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private Node findNodeBeforeByIndex(int index) {
        if (index <= 0 || index > size - 1) {
            return null;
        }

        int count = 0;
        Node node = first;
        while (node.next != null) {
            if (count == index - 1) {
                return node;
            }
            count++;
            node = node.next;
        }
        return null;
    }
}