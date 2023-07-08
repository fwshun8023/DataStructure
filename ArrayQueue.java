public class ArrayQueue {
    private String[] items;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        items = new String[capacity];
    }

    public boolean enqueue(String item){
        if(tail == capacity){
            if(head == 0)  return false; // 队列已满
            // 迁移数据
            // int index = 0;
            // for (int i=head;i<tail;i++) {
            //     items[index] = items[i];
            //     index ++;
            // }
            // head = 0;
            // tail = index + 1;
            for (int i=head;i<tail;i++) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if(head == tail) return null;
        return items[head++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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
