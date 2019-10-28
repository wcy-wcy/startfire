package work;

import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList<E> {

    //内部存放数据的素组
    private Object[] baseArray;

    //默认容量
    private static final int  DEFAULT_CAP = 10;

    //存放元素的个数
    private int size;

    //容量最大值
    private static final int MAX_CAP = Integer.MAX_VALUE - 8;

    //有参的构造函数
    public MyArrayList(int cap){
        //如果容量大于0，数组容量为参数，等于0为默认容量
        if(cap > 0){
            this.baseArray = new Object[cap];
        }else if(cap==0){
            this.baseArray = new Object[DEFAULT_CAP];
        }else{
            throw new IllegalArgumentException("Illegal Capacity: "+
                    cap);
        }
    }

    //无参构造函数，数组为默认容量
    public MyArrayList(){
        this.baseArray = new Object[DEFAULT_CAP];
    }

    //添加元素
    public boolean add(E e){
        ensureIfGrow(size+1);
        baseArray[size++] = e;
        return true;
    }

    //删除指定位置的元素
    public E remove(int index){
        //判断下标是否越界
        if(index >= size ){
            throw new IndexOutOfBoundsException("下标为:"+index+", 最大为: "+size);
        }
        E oldValue = (E) baseArray[index];
        int numMove = size - index - 1;
        //把index之后的元素前移一位
        if(numMove > 0){
            System.arraycopy(baseArray,index+1,baseArray,index,numMove);
        }
        //最后一个元素删除
        baseArray[size--] = null;
        return oldValue;
    }

    //获取指定位置的元素
    public E get(int index){
        //判断下标是否越界
        if(index >= size ){
            throw new IndexOutOfBoundsException("下标为:"+index+", 最大为: "+size);
        }

        return (E) baseArray[index];
    }

    //替代指定位置的元素
    public E set(int index,E e){
        //判断下标是否越界
        if(index >= size ){
            throw new IndexOutOfBoundsException("下标为:"+index+", 最大为: "+size);
        }
        E oldValue = (E) baseArray[index];

        baseArray[index] = e;
        return oldValue;
    }

    //迭代器
    public Iterator<E> iterator(){
        return new MyItr();
    }

    private class MyItr implements Iterator<E>{
        int itrSize;

        @Override
        public boolean hasNext() {
            return itrSize != size;
        }

        @Override
        public E next() {
            int i = itrSize;
            if (i >= size){
                throw new NoSuchElementException();
            }
            Object[] baseArray = MyArrayList.this.baseArray;
            itrSize = i+1;
            return (E) baseArray[i];

        }
    }

    public int size(){
        return this.size;
    }

    //扩容
    private void ensureIfGrow(int cap){
        if(cap>baseArray.length){
            int oldCap = baseArray.length;
            int newCap = oldCap + (oldCap >> 1);
            if(newCap - oldCap < 0)
                newCap = oldCap;
            if(newCap - MAX_CAP > 0){
                newCap = (cap > MAX_CAP) ?
                        Integer.MAX_VALUE :
                        MAX_CAP;
            }

            baseArray = Arrays.copyOf(baseArray,newCap);
        }
    }
}
