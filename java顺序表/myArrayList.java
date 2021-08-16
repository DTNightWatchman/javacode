import java.util.Arrays;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-08-16
 * Time:12:48
 */
class myArrayList {
    public int[] elem;
    public int usedSize;
    public static int capacity = 10;
    public myArrayList() {
        elem = new int[capacity];
        usedSize = 0;
    }
    //打印数组
    public void disPlay() {
        for(int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
    //判断数组是否已经满了的情况
    public boolean isFull() {
        return this.usedSize == capacity;
    }
    //判断数组是不是空的
    public boolean isEmpty() {
        return this.usedSize == 0;
    }
    //在pos位置新增一个数组。
    public void add(int pos, int data) {
        //1、满的情况  2、pos是否合法的情况。
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("插入位置不合法");
            return;
        }
        if (isFull()) {
            System.out.println("需要扩容");
            this.elem = Arrays.copyOf(this.elem, capacity * 2);
            capacity = capacity * 2;
        }
        int i = 0;
        for(i = usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[i + 1] = data;
        this.usedSize++;
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        if(isEmpty()) {
            return false;
        } else {
            for(int i = 0; i < this.usedSize; i++) {
                if(this.elem[i] == toFind) {
                    return true;
                }
            }
        }
        return false;
    }
    //查找每个元素对应的位置
    public int search(int toFind) {
        if(isEmpty()) {
            return -1;
        } else {
            for(int i = 0; i < this.usedSize; i++) {
                if(this.elem[i] == toFind) {
                    return i;
                }
            }
        }
        return -1;
    }
    public int getPos(int pos) {
        if(pos < 0 || pos >= this.usedSize) {
            throw new RuntimeException("位置不合法：");
        }
        if(isEmpty()) {
            System.out.println("顺序表为空");
            return 0;
        } else {
            return this.elem[pos];
        }
    }
    //设置pos位置数据
    public void setpos(int pos,int value) {
        if(pos < 0 || pos > this.usedSize) {
            System.out.println("pos不合法");
            return;
        }
        this.elem[pos] = value;
    }
    //删除第一个出现的关键字key
    public void remove(int toRemove) {
        if(isEmpty()) {
            System.out.println("数组是空的");
        }
        int i = 0;
        for(i = 0; i < this.usedSize; i++){
            if(this.elem[i] == toRemove) {
                break;
            }
        }
        if(i == this.usedSize) {
            System.out.println("没有这个数据");
        } else {
            while(i < this.usedSize - 1) {
                this.elem[i] = this.elem[i + 1];
                i++;
            }
            this.usedSize--;
        }
    }
    public void clear() {
        for(int i = 0; i < usedSize; i++){
            this.elem[i] = 0;
        }
        this.usedSize = 0;
    }
}
