package Lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList <T> implements Iterable<T>{
    public class Node {
        public T value;
        public Node prev;
        public Node next;

        public Node(T e) {
            value = e;
            prev = next = null;
        }
        public String toString(){
            return value.toString();
        }
    }

    public Node first;
    public Node last;
    private int size;

    public void TsLinkedList( ) {
        first = last = null;
    }
    public T getFirst() {
        final Node f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.value;
    }
    public T getLast() {
        final Node l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.value;
    }

    public int addLast(T s) {
        Node e = new Node(s);
        if (null == last) {
            last = first = e;
        } else {
            e.prev = last;
            last.next = e;
            last = e;
        }
        return size++;
    }

    public void addFirst(T s) {
        Node e = new Node(s);
        if (null == last) {
            last = first = e;
        } else {
            e.next = first;
            first.prev = e;
            e.prev = null;
            first = e;
        }
        size++;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public int getIndex(T s) {
        Node cur = first;
        for (int i = 0; i < size; i++) {
            if (cur.value.equals(s)) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    public T elementAt(int index) {
        Node cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.value;
    }

    public void remove(T e) {
        Node current = first;
        while (current != null) {
            if (current.value.equals(e)) {
                Node tmp = current;
                current = current.next;
                if (tmp.equals(first)) {
                    removeFirst();
                } else if (tmp.equals(last)) {
                    removeLast();
                } else {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                    size--;
                }
                break;
            } else {
                current = current.next;
            }
        }
    }

    public void removeFirst() {
        if (size == 1) {
            first = last = null;
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            first = last = null;
        } else {
            last = last.prev;
            last.next = null;
        }
        size--;
    }


    public void removeAt(int index) {
        Node current = first;
        while (current != null) {
            if (getIndex(current.value)==index) {
                Node tmp = current;
                current = current.next;
                if (tmp.equals(first)) {
                    removeFirst();
                } else if (tmp.equals(last)) {
                    removeLast();
                } else {
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                    size--;
                }
                break;
            } else {
                current = current.next;
            }
        }

    }


    public void insertAt(T s, int index) {
        if (index > size || index < 0) {
            return;
        }
        if (size == 0 || index == 0) {
            addFirst(s);
        } else if (index == size) {
            addLast(s);
        } else {
            Node tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            Node e = new Node(s);
            tmp.prev.next = e;
            e.prev = tmp.prev;
            e.next = tmp;
            tmp.prev = e;
            size++;
        }
    }


    public int size() {
        return size;
    }
    public void swap(T x, T y)
    {
        Node head=first;
        // Nothing to do if x and y are same
        if (x == y)
            return ;

        Node a = null, b = null;

        // search for x and y in the linked list
        // and store therir pointer in a and b
        while (head.next.value!=null) {

            if (head.next.value.equals(x)) {
                a = head;
            }

            else if ((head.next).value.equals(y)) {
                b = head;
            }

            head = ((head).next);
        }

        // if we have found both a and b
        // in the linked list swap current
        // pointer and next pointer of these
        if (a!=null&&  b!=null) {
            Node temp = a.next;
            a.next = b.next;
            b.next = temp;
            temp = a.next.next;
            a.next.next = b.next.next;
            b.next.next = temp;
        }

    }

    public class LinkedListIterator implements Iterator<T> {
        private Node current;
        public LinkedListIterator(){
            current=LinkedList.this.first;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            if(!hasNext()){
                return null;
            }
            Node tempo = current;
            current = current.next;
            return tempo.value;
        }

        @Override
        public void remove() {
            if(current!=null){
                if(current.prev!=null){
                    current.prev.next=current.next;
                }else{
                    first=current.next;
                }
            }

        }
    }
    public void clear() {
        last = first = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size==0;
    }
    public boolean contains(T o){
        return this.getIndex(o)>=0;
    }


}
