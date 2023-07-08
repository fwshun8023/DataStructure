public class CircularQueue{
    private String items[];
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int capacity){
        this.size = capacity;
        items = new String[capacity];
    }

    public boolean enqueue(String item){
        // 浪费一个位置，区分队满和队空
        if((tail + 1)%size == head) return false;

        // 会导致实际tail不对
        // tail = tail%size;
        // items[tail++] = item;
        items[tail] = item;
        tail = (tail + 1)%size;
        return true;
    }

    public String dequeue(){
        if(tail == head) return null;

        // 会导致实际head不对
        // head = head%size;
        // return items[head++];
        String ret = items[head];
        head = (head + 1)%size;
        return ret;
    }
    
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("1"));
        System.out.println(queue.enqueue("2"));
        System.out.println(queue.enqueue("3"));
        System.out.println(queue.enqueue("4"));
        System.out.println(queue.dequeue());
        System.out.println(queue.enqueue("4"));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}