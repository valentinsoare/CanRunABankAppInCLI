package org.clibankinjava.customdatastructures.newkindoflinkedlist;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

@Getter
@Setter
public class OptimizedDoubleLinkedList<E> implements Iterable<E>, Serializable {

    @Serial
    private static final long serialVersionUID = 4608999335861267316L;

    private Node<E> head;
    private Node<E> tail;

    private int size;

    public OptimizedDoubleLinkedList() {}

    public OptimizedDoubleLinkedList(Node<E> node) {
        this();

        this.head = node;
        this.tail = node;
        this.size++;
    }

    public OptimizedDoubleLinkedList(Collection <? extends E> collection) {
        this();
        addCollection(collection);
    }

    private class OptimizedLinkedListIterator<E> implements Iterator<E> {

        private TypeOfIterator typeOfIterator;
        private Node<E> currentNode;

        public OptimizedLinkedListIterator(TypeOfIterator typeOfIterator) {
            this.typeOfIterator = typeOfIterator;
        }

        public OptimizedLinkedListIterator() {
            this(TypeOfIterator.ASCENDING);
        }

        public void setTypeOfIterator(TypeOfIterator typeOfIterator) {
            this.typeOfIterator = typeOfIterator;
        }

        public void setCurrentNode(Node<E> currentNode) {
            this.currentNode = currentNode;
        }

        public TypeOfIterator getTypeOfIterator() {
            return typeOfIterator;
        }

        public Node<E> getCurrentNode() {
            return currentNode;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Iterator.super.forEachRemaining(action);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isIndexValid(int index) {
        return true;
    }

    public boolean contains(E e) {
        return false;
    }

    public void clear() {

    }

    public int indexOf(E e) {
        return 0;
    }

    public void addFirst(E e) {

    }

    public void addLast(E e) {

    }

    public boolean addElementBefore(E e, E elementAlreadyPresent) {
        return true;
    }

    public boolean addElementAfter(E e, E elementAlreadyPresent) {
        return true;
    }

    public boolean removeFirst() {
        return true;
    }

    public boolean removeLast() {
        return true;
    }

    public boolean addCollection(Collection<? extends E> collection) {
        return true;
    }

    public boolean addCollectionBeforeElement(Collection<? extends E> collection, E elementAlreadyInTheList) {
        return true;
    }

    public boolean addCollectionAfterElement(Collection<? extends E> collection, E elementAlreadyInTheList) {
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new OptimizedLinkedListIterator<>();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    public boolean sort(boolean ascendingOrder) {
        return true;
    }

    public boolean reverse() {
        return true;
    }

    public String convertToString(boolean fromHead) {
        return "";
    }
}
