package com.test;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// Definición de la clase MiListaSecuencial que extiende AbstractSequentialList
public class MiListaSecuencial<E> extends AbstractSequentialList<E> {

    private Node<E> head; // Nodo inicial de la lista
    private int size;     // Tamaño de la lista

    // Constructor de la lista
    public MiListaSecuencial() {
        head = null; // Inicialmente la lista está vacía
        size = 0;
    }

    // Método para obtener el tamaño de la lista
    @Override
    public int size() {
        return size;
    }

    // Método para obtener un iterador sobre la lista, comenzando en la posición index
    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return new ListItr(index);
    }

    // Clase interna que representa un nodo en la lista
    private static class Node<E> {
        E data;           // Datos almacenados en el nodo
        Node<E> next;     // Referencia al siguiente nodo
        Node<E> prev;     // Referencia al nodo anterior

        // Constructor de un nodo con datos element
        Node(E element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }
    }

    // Clase interna que implementa el iterador de la lista
    private class ListItr implements ListIterator<E> {
        private Node<E> nextNode;      // Nodo siguiente al actual
        private Node<E> lastReturned;  // Último nodo retornado
        private int nextIndex;         // Índice del nodo siguiente

        // Constructor del iterador
        ListItr(int index) {
            if (index == size) {
                nextNode = null;
                nextIndex = size;
            } else {
                nextNode = getNode(index);
                nextIndex = index;
            }
        }

        // Método para verificar si hay un elemento siguiente
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        // Método para obtener el siguiente elemento
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return lastReturned.data;
        }

        // Métodos para trabajar con el elemento anterior
        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextNode == null) {
                nextNode = head;
            } else {
                nextNode = nextNode.prev;
            }
            lastReturned = nextNode;
            nextIndex--;
            return lastReturned.data;
        }

        // Métodos para obtener los índices
        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        // Método para eliminar el último nodo retornado
        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (nextNode == lastReturned) {
                nextNode = lastNext;
            } else {
                nextIndex--;
            }
            lastReturned = null;
        }

        // Método para establecer un nuevo elemento
        @Override
        public void set(E e) {
            if (lastReturned == null) {
                throw new IllegalStateException();
            }
            lastReturned.data = e;
        }

        // Método para agregar un nuevo elemento
        @Override
        public void add(E e) {
            if (nextNode == null) {
                linkLast(e);
            } else {
                linkBefore(e, nextNode);
            }
            nextIndex++;
            lastReturned = null;
        }
    }

    // Método para agregar un elemento al final de la lista
    private void linkLast(E e) {
        final Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = newNode;
        } else {
            Node<E> lastNode = getNode(size - 1);
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
        size++;
    }

    // Método para agregar un elemento antes de un nodo dado
    private void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(e);
        newNode.next = succ;
        succ.prev = newNode;
        if (pred == null) {
            head = newNode;
        } else {
            pred.next = newNode;
            newNode.prev = pred;
        }
        size++;
    }

    // Método para eliminar un nodo dado
    private E unlink(Node<E> x) {
        final E element = x.data;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            // x was last node
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
        return element;
    }

    // Método para obtener el nodo en la posición index
    private Node<E> getNode(int index) {
        Node<E> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }
}
