package org.clibankinjava.customdatastructures.newkindoflinkedlist;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

@Getter
public class Node<T> implements Serializable, Comparable<Node<T>> {

    @Serial
    private static final long serialVersionUID = -7591712451535041027L;

    private T element;
    private Node<T> next;
    private Node<T> previous;

    public Node() {}

    public Node(T element) {
        this.element = element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    private class NodeComparator<E> implements Comparator<E> {
        @Override
        public int compare(E o1, E o2) {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node<?> node)) return false;

        return (node.element.equals(element));
    }

    @Override
    public int hashCode() {
        int result = element.hashCode();

        result = 31 * result + next.hashCode();
        result = 31 * result + previous.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Node<T> o) {
        return 0;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
