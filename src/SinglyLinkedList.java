public class SinglyLinkedList {

    static class LinkedList<T>{

        public Node<T> head = null;
        public Node<T> tail = null;
        int size = 0 ;
        static class Node<T>{
            T data;
            Node<T> next;
            public Node(T data,Node<T> next){

                this.data = data;
                this.next = next;

            }
        }
        public boolean isEmpty(){
            return size == 0 ;
        }
        public void add(T elem){
            if(isEmpty()){
                head = tail = new Node<>(elem,null);
            }
            else {
                tail.next = new Node<>(elem,null);
                tail = tail.next;
            }
            size++;

        }
        public void remove(){

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[ ");
            LinkedList.Node<T> trav = head;
            while (trav != null) {
                sb.append(trav.data).append(", ");
                trav = trav.next;
            }
            sb.append(" ]");
            return sb.toString();
        }
    }
    public static void main(String... args){
        LinkedList<Integer> node = new LinkedList<Integer>();
        node.add(5);
        node.add(6);
        System.out.println(node.toString());
    }
}
