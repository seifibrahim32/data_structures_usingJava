import java.util.Iterator;
import java.util.LinkedList;

public class Queue {

    public static class QueueLinkedList<T> implements Iterable<T> {

        public static LinkedList list;
        public volatile static QueueLinkedList<Object> _instance = null;
        private QueueLinkedList(){

        }

        public static QueueLinkedList<Object> getInstance(){

             if(_instance == null){
                 synchronized (QueueLinkedList.class) {
                     _instance = new QueueLinkedList<>();
                     list = new LinkedList<>();
                 }
             }
             return _instance;
        }

        public void add(T elem) {
            list.add(elem);
        }
        @Override
        public Iterator<T> iterator() {
            Iterator<T> it = list.iterator();
            return new Iterator<T>() {

                @Override
                public void remove() {
                    list.removeFirst();
                }

                @Override
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override
                public T next() {
                    return it.next();
                }
            };
        }

    }
    public static void main(String... args){
        QueueLinkedList<Object> queueLinkedList = QueueLinkedList.getInstance();
        queueLinkedList.add("Seif");
        queueLinkedList.add(21331);
        queueLinkedList.add("I just try ...");
        Iterator<Object> iterator = queueLinkedList.iterator();
        // @param iterator used to iterate over the queue
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        iterator.remove();
        iterator = queueLinkedList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}