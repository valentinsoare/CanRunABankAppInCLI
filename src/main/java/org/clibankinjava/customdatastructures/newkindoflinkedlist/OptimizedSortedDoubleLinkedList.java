package org.clibankinjava.customdatastructures.newkindoflinkedlist;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Collection;

@Getter
@Setter
public class OptimizedSortedDoubleLinkedList<E> extends OptimizedDoubleLinkedList<E> {

    @Serial
    private static final long serialVersionUID = 8323394962733350939L;

    private boolean inAscendingOrder;

    public OptimizedSortedDoubleLinkedList(boolean inAscendingOrder) {
        super();
        this.inAscendingOrder = inAscendingOrder;
    }

    public OptimizedSortedDoubleLinkedList() {
        this(true);
    }

    public OptimizedSortedDoubleLinkedList(Node<E> node, boolean inAscendingOrder) {
        super(node);
        this.inAscendingOrder = inAscendingOrder;
    }

    public OptimizedSortedDoubleLinkedList(Node<E> node) {
        this(node, true);
    }

    public OptimizedSortedDoubleLinkedList(Collection<? extends E> collection, boolean inAscendingOrder) {
        super(collection);
        this.inAscendingOrder = inAscendingOrder;
    }

    public OptimizedSortedDoubleLinkedList(Collection<? extends E> collection) {
        this(collection, true);
    }

    public void addItemInSortedOrder(E e) {
        if (isEmpty()) {
            Node<E> newNode = new Node<>(e);
            setHead(newNode);
            setTail(newNode);
        } else if (inAscendingOrder) {
            addItemInAscendingOrder(e);
        } else {
            addItemInDescendingOrder(e);
        }

        setSize(size() + 1);
    }

    private void addItemInAscendingOrder(E e) {
        Node<E> newNode = new Node<>(e);

        if (newNode.compareTo(getHead()) < 0) {
            getHead().setPrevious(newNode);
            newNode.setNext(getHead());
            super.setHead(newNode);
        } else if (newNode.compareTo(getTail()) > 0) {
            getTail().setNext(newNode);
            newNode.setPrevious(getTail());
            setTail(newNode);
        } else {
            Node<E> currentNode = getHead().getNext();

            while (currentNode.compareTo(newNode) < 0) {
                currentNode = currentNode.getNext();
            }

            Node<E> previousNode = currentNode.getPrevious();

            previousNode.setNext(newNode);
            newNode.setPrevious(previousNode);

            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
        }
    }

    private void addItemInDescendingOrder(E e) {
        Node<E> newNode = new Node<>(e);

        if (newNode.compareTo(getHead()) > 0) {
            getHead().setPrevious(newNode);
            newNode.setNext(getHead());
            setHead(newNode);
        } else if (newNode.compareTo(getTail()) < 0) {
            getTail().setNext(newNode);
            newNode.setPrevious(getTail());
            setTail(newNode);
        } else {
            Node<E> currentNode = getHead().getNext();

            while (currentNode.compareTo(newNode) > 0) {
                currentNode = currentNode.getNext();
            }

            Node<E> previousNode = currentNode.getPrevious();

            previousNode.setNext(newNode);
            newNode.setPrevious(previousNode);

            newNode.setNext(currentNode);
            currentNode.setPrevious(newNode);
        }
    }

    public void addItemInSortedOrder(Collection<? extends E> collection) {
        collection.forEach(this::addItemInSortedOrder);
    }
}
