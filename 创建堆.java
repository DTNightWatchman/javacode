import java.util.Arrays;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-10-24
 * Time:0:36
 */
class TestHeap{
    public int[] elem;
    public int usedSize;
    public TestHeap() {
        this.elem = new int[10];
    }
    public void shiftDown(int parent) {
        int child = parent * 2 + 1;
        while(child < this.usedSize) {
            if(child+1 < this.usedSize && this.elem[child] < this.elem[child+1]) {
                child++;
            }
            if(this.elem[parent] < this.elem[child]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }
    public int[] creatTestHeap(int[] array) {
        if(array.length > 10) {
            this.elem = Arrays.copyOf(array, array.length);
            this.usedSize = array.length;
        } else {
            for(int i = 0; i < array.length; i++) {
                this.elem[i] = array[i];
                this.usedSize++;
            }
        }
        for(int parent = this.usedSize - 1; parent >= 0; parent--) {
            shiftDown(parent);
        }
        return this.elem;
    }
    public int[] push(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,2 * this.usedSize);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
        shiftUp(this.usedSize - 1);
        return this.elem;
    }
    public void shiftUp(int child){
        int parent = (child - 1) / 2;
        while(parent >= 0) {
            if(this.elem[parent] < this.elem[child]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (parent - 1) / 2;
            } else {
                break;
            }
        }
    }
    public boolean isFull() {
        if(this.usedSize >= this.elem.length) {
            return true;
        } else {
            return false;
        }
    }
}
public class demo {
    public static void main(String[] args) {
        TestHeap testHeap = new TestHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        int[] ret = testHeap.creatTestHeap(array);
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < array.length; i++) {
            System.out.print(ret[i] + " ");
        }
        System.out.println();
        ret = testHeap.push(80);
        for(int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }
}