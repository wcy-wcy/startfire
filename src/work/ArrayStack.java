package work;

import java.util.ArrayList;

public class ArrayStack<E> {
    public static void main(String[] args) {
        System.out.println("测试");
        System.out.println("第二次测试");
    }
    private ArrayList arrayList = new ArrayList();

    public E push(E e){
        arrayList.add(e);
        return e;
    }

    public E pop(){
        int index = arrayList.size()-1;
        return (E) arrayList.remove(index);
    }

    public E peek(){
        int index = arrayList.size()-1;
        return (E) arrayList.get(index);
    }

    public int size(){
        return arrayList.size();
    }

    public boolean isEmpty(){
        return arrayList.size()==0?true:false;
    }
}
