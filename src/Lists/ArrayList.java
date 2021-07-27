package Lists;

import java.util.Iterator;

public class ArrayList <T> implements Iterable<T> {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
        size = 0;
    }


    public ArrayList(int initialCapacity) {
        array = new Object[initialCapacity];
        size = 0;
    }

    public int size() {
        return size;
    }
    public void add(int index, T e) {
        if (index >= size) {
            return;
        }
        assureCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = e;
        size++;
    }
    public void addLast(T e) {
        assureCapacity();
        array[size] = e;
        size++;
    }
    public int getIndex(T s) {
        for (int i = 0; i < size ; i++) {
            if (array[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }


    public void removeAt(int index) {
        if (index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i+1];
        }
        size--;

    }
    public T get(int index){
        return elementAt(index);
    }


    public void insertAt(T s, int index) {
        if (index >= size) {
            return;
        }
        assureCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = s;
        size++;

    }
    private void assureCapacity() {
        if (array.length == size) {
            resize();
        }
    }
    private void resize() {
        System.out.println("calling resize for the array list");
        if (size == array.length) {
            T[] newShapes = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newShapes[i] = (T) array[i];
            }
            array = newShapes;
        } else {
            //through exception
        }
    }
    public void swap(T x, T y){
        if(x.equals(y))
            return;
        //through exception
        if(x==null||y==null)
            return;
        //through exception
        int indexx=getIndex(x);
        int indexy=getIndex(y);

        array[indexy]=x;
        array[indexx]=y;
    }


    public void remove(T s) {

        int index = getIndex(s);
        if (index > -1) {
            removeAt(index);
        }

    }
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }
    public class ArrayListIterator implements Iterator<T> {
        int index = 0;
        boolean isElementVisited = false;


        public boolean hasNext() {
            return index < size;
        }


        public T next() {
            if (index >= size) {
                return null;
            }
            T tmp = (T) array[index];
            isElementVisited = true;
            index++;
            return tmp;
        }

        public void remove() {
            if (!isElementVisited) {
                return;
                // through an exception
            }

            int lastIndex = index - 1;
            ArrayList.this.remove(elementAt(lastIndex));
            index--;
            isElementVisited = false;
        }
    }
    public T elementAt(int index) {
        if (index >= size) {
            return null;
        }
        return (T) array[index];
    }
    public boolean contains(T o) {
        return indexOf(o) >= 0;
    }
    public int indexOf(T e) {
        for (int i = 0; i < size ; i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    public void clear() {
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }

}
