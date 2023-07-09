/*
 * 递归
 * 1、问题可分解为多个子问题，且子问题只是数据规模不同，求解思路完全相同
 * 2、存在递归终止条件
 * 递归问题：
 * 1、避免堆栈溢出。
 *      a、限制递归调用深度；
 *      b、重写为非递归代码；
 *      c、尾递归（递归调用出现在函数的最后一行，且没有任何局部变量参与最后一行代码的计算）？？？
 * 2、重复计算问题。检查递推公式
 */
public class Recursion {
    /*
     * f(n) = f(n-1) + f(n-2)
     * f(0) = 1
     * f(1) = 1
     */
    public static int f(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;

        return f(n-1) + f(n-2);
    }

    public static void main(String[] args) {
        System.out.println(f(40));
    }
}