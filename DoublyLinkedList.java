public class DoublyLinkedList{
    public static class Node{
        public Node pre;
        public Node next;
        public int data;
    }

    private Node head = null;

    // 在P之后插入x
    public void insert(Node p, Node x){
        if(p == null){
            if(head != null){
                head.pre = x;
                x.next = head;
            }
            head = x;
        } else {
            x.next = p.next;
            if(p.next != null){
                p.next.pre = x;
            }
            p.next = x;
            x.pre = p;
        }
    }

    public void remove(Node x){
        if(x.pre == null){
            head = x.next;
            head.pre = null;
        } else {
            if(x.next != null){
                x.pre.next = x.next;
                x.next.pre = x.pre;
            } else {
                x.pre.next = null;
            }
        }
    }

    @Override
    public String toString(){
        String s = "DoublyLinkedList: ";
        Node p = head;
        while(p != null){
            s += p.data + "->";
            p = p.next;
        }
        return s;
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        Node node = new Node();
        node.data = 1;
        list.insert(null, node);
        System.out.println(list.toString());

        Node node2 = new Node();
        node2.data = 2;
        list.insert(node, node2);
        System.out.println(node2.pre.data);
        System.out.println(node.next.data);
        System.out.println(list.toString());

        Node node3 = new Node();
        node3.data = 3;
        list.insert(node, node3);
        System.out.println(list.toString());

        Node node4 = new Node();
        node4.data = 4;
        list.insert(node3, node4);
        System.out.println(list.toString());

        list.remove(node3);
        System.out.println(list.toString());

        list.remove(node);
        System.out.println(list.toString());

        System.out.println(node2.next);
        System.out.println(node2.pre.data);
        list.remove(node2);
        System.out.println(list.toString());

    }
}