public class LinkedList {
    public static class Node {
        public int data;
        public Node next;

        public Node(){}

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;

    // 在P节点后添加X  O(1)
    public void inset(Node p, Node x){
        if(p == null){
            x.next = head;
            head = x;
        } else {
            x.next = p.next;
            p.next = x;
        }
    }

    // 已知前驱节点 O(1)
    public void remove(Node p, Node x){
        if(p == null){
            head = head.next;
        } else {
            p.next = x.next;
        }
    }

    // 未知前驱节点，O(n)
    public void remove(Node x){
        if(x == null) return;

        Node p = head;
        while(p !=null && p.next != x){
            p = p.next;
        }

        if(p == null){
            head = head.next;
        } else {
            p.next = x.next;
        }
    }

    // 值查找节点
    public Node find(int val){
        Node p = head;
        while(p != null && p.data != val){
            p = p.next;
        }
        return p;
    }

    // 翻转链表
    public void revert(){

    }



    @Override
    public String toString(){
        String s = "LinkedList: ";
        Node p = head;
        while(p != null){
            s += p.data + "->";
            p = p.next;
        }
        return s;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node node = new LinkedList.Node();
        node.data = 1;

        linkedList.inset(null, node);
        LinkedList.Node node2 = new LinkedList.Node();
        node2.data = 2;

        linkedList.inset(node, node2);
        LinkedList.Node node3 = new LinkedList.Node();
        node3.data = 3;

        linkedList.inset(node2, node3);
        System.out.println(linkedList.toString());

        LinkedList.Node node10 = new LinkedList.Node();
        node10.data = 10;
        linkedList.inset(node, node10);

        LinkedList.Node node99 = new LinkedList.Node();
        node99.data = 99;
        linkedList.inset(null, node99);

        System.out.println(linkedList.toString());

        linkedList.remove(node99);
        System.out.println(linkedList.toString());

        linkedList.remove(node10);
        System.out.println(linkedList.toString());

        Node n = linkedList.find(3);
        System.out.println(n);

        Node n2 = linkedList.find(9);
        System.out.println(n2);
    }
}