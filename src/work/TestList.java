package work;

import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list.size());
        System.out.println(list.get(3));
        System.out.println(list.set(5,7));
        System.out.println(list.remove(1));

        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
