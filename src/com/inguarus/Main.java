package com.inguarus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        IntList arrayList = new IntArrayList();
        arrayList.add(7);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(145);
        arrayList.add(11);
        arrayList.add(75);
        arrayList.add(16);
        arrayList.add(38);
        arrayList.add(92);
        arrayList.add(9);
        System.out.println("IntArrayList before sorting:");
        System.out.println(arrayList);
        System.out.println("IntArrayList after sorting:");
        sort(arrayList);
        System.out.println("=======================================");

        IntList linkedList = new IntLinkedList();
        linkedList.add(4);
        linkedList.add(87);
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(12);
        linkedList.add(62);
        linkedList.add(31);
        linkedList.add(2);
        linkedList.add(89);
        linkedList.add(17);
        System.out.println("IntLinkedList before sorting:");
        System.out.println(linkedList);
        System.out.println("IntLinkedList after sorting:");
        sort(linkedList);
        System.out.println("=======================================");
        System.out.println();
        printResizeCounter(1000);
        printResizeCounter(1000000);
        //printResizeCounter(1000000000); //TODO implement Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        System.out.println();
        printComputerConfiguration();
        speedTest();

    }

    private static void sort(IntList list) {
        int[] array = list.makeArrayFromIntList(list);
        int temp, j;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
        System.out.println(list.makeIntListFromArray(array));
    }

    private static void printResizeCounter(int size) {
        IntArrayList arrayList = new IntArrayList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(10));
        }
        System.out.printf("The operation resize() in IntArrayList is causes %d times when %d elements additions to the end of the list.\n", arrayList.getResizeCounter(), size);
    }

    private static void printComputerConfiguration() {
        System.out.println();
        System.out.println("Computer configuration: ");
        System.out.println("Processor: Intel(R) Pentium(R) CPU N3540 @ 2.16GHz 2.16GHz");
        System.out.println("Installed memory (RAM): 4,00 GB");
        System.out.println("System type: 64-bit Operating System");
        System.out.println("Windows edition: Windows 8.1 with Bing");
        System.out.println();
    }

    private static void speedTest() {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        IntList arrayList = new IntArrayList();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        IntList linkedList = new IntLinkedList();

        final int COUNT = 100000;
        long timeBefore;
        long timeAfter;
        double currentTime;

        Random random = new Random();
        for (int i = 0; i < COUNT; i++) {
            arrayList.add(random.nextInt(100));
            integerArrayList.add(random.nextInt(100));
            linkedList.add(random.nextInt(100));
            integerLinkedList.add(random.nextInt(100));
        }

        System.out.println("Method 'get(int index)' from the middle of the list (10'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            integerArrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            integerLinkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.get(COUNT / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int element)' to the end of the list (2'000'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            integerArrayList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            arrayList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            integerLinkedList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            linkedList.add(50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int index, int element)' to the top of the list (10'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            integerArrayList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            integerLinkedList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(0, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'add(int index, int element)' to the middle of the list (5'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            integerArrayList.add(integerArrayList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.add(arrayList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            integerLinkedList.add(integerLinkedList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.add(linkedList.size() / 2, 50);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove(int index, int element)' from the top of the list (10'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            integerArrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            integerLinkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(0);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();

        System.out.println("Method 'remove(int index, int element)' from the middle of the list (5'000 times):");
        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            integerArrayList.remove(integerArrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("ArrayList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            arrayList.remove(arrayList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntArrayList: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            integerLinkedList.remove(integerLinkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("LinkedList<Integer>: %.1f sec.\n", currentTime);

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            linkedList.remove(linkedList.size() / 2);
        }
        timeAfter = System.currentTimeMillis();
        currentTime = (timeAfter - timeBefore) / 1000.0;
        System.out.printf("IntLinkedList: %.1f sec.\n", currentTime);
        System.out.println();
    }
}
