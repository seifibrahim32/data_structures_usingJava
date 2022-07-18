import java.util.Iterator;
import java.util.LinkedList;

public class Stack {
    public static class StackLL<T> implements Iterable<T> {
        LinkedList<T> list ;
        public StackLL(){
            this.list  = new LinkedList<>();
        }
        void push(T elem){
            list.add(elem);
        }
        void remove(){
            list.removeLast();
        }
        @Override
        public Iterator<T> iterator() {
            return list.iterator();
        }
    }
    public static void main(String... args){

        StackLL<Object> stack = new StackLL<>();

        stack.push(5);
        stack.push(3.2);
        stack.push(3.2);
        Iterator<Object> it = stack.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
