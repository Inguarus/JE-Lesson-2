package com.inguarus;

public abstract class BaseList implements com.inguarus.IntList {

    protected int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(get(i)).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

}
