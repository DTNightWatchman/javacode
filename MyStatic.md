```java
import java.util.ArrayList;
import java.util.Arrays;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-10-02
 * Time:17:27
 */
public class MyStack {
    public int[] elem;
    public int usedSize;
    public MyStack() {
        this.elem = new int[10];
    }
    public void push(int item) {
        if(isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        //存放到数组的最后位置
        this.elem[this.usedSize] = item;
        this.usedSize++;
    }
    public int pop() throws RuntimeException {
        if(empty()) {
            throw new RuntimeException("栈空了！");
        }
        int val = this.elem[this.usedSize - 1];
        this.usedSize--;
        return val;
    }
    public int peek() throws RuntimeException {
        if (empty()) {
            throw new RuntimeException("栈空了！");
        }
        return this.elem[this.usedSize - 1];
    }
    public boolean empty() {
        if (this.usedSize == 0) {
            return true;
        }
        //数据个数等于0的时候
        return false;
    }
    public boolean isFull() {
        //数据个数等于长度
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
}

```

