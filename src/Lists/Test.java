package Lists;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> test1=new ArrayList<>();
        test1.addLast(3);
        test1.addLast(4);
        test1.add(0,8);
        Iterator<Integer> it= test1.iterator();
        while(it.hasNext())
            System.out.println(it.next());
        System.out.println(test1.contains(3));
        LinkedList<String> test2=new LinkedList<>();
        test2.addLast("hey");
        test2.addLast("hi");
        test2.addLast("hello");
        test2.addFirst("ola");
        System.out.println(test2.getFirst());
        System.out.println(test2.getLast());
        System.out.println(test2.elementAt(0));

    }

}
