public class ArrayStack {
    private int n;
    private int count;
    private String[] data;
    
    public ArrayStack(int n){
        this.n = n;
        data = new String[n];
    }

    public boolean push(String item){
        if(count < n){
            data[count] = item;
            count ++;
            return true;
        }
        return false;
    }

    public String pop(){
        if(count > 0){
            return data[--count];
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push("1");
        stack.push("2");
        System.out.println(stack.push("3"));
        System.out.println(stack.push("4"));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
