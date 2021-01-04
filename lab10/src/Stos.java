public class Stos <T>{

    Node<T> head = null;

    private static class Node<T>{
        T x;
        Node<T> next;
    }

    public void push(T obj){
        Node<T> tmpNode = new Node<>();
        tmpNode.x = obj;
        tmpNode.next = head;
        head = tmpNode;
    }

    public void pop(){
        if(head != null)
            head = head.next;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        Node<T> tmpNode = head;
        while(tmpNode != null){
            out.append("{").append(tmpNode.x).append("} ");
            tmpNode = tmpNode.next;
        }
        return out.toString();
    }
}
