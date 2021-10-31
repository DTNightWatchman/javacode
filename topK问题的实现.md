```
import javax.management.remote.SubjectDelegationPermission;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:21:07
 */
class Card implements Comparable<Card>{
    public int rank;
    public String suit;
    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }


    @Override
    public int compareTo(Card o) {
        return rank - o.rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit='" + suit + '\'' +
                '}';
    }
}
class AgeCompare implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.rank - o2.rank;
    }
}
class Student{
    public int age;
    public int score;

    public Student(int age, int score) {
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                '}';
    }
}
public class demo {
    public static Student[] topK2(Student[] array,int k){
        PriorityQueue<Student> minPriorityQueue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        });
        for(int i = 0; i < array.length; i++) {
            if(minPriorityQueue.size() < k) {
                minPriorityQueue.offer(array[i]);
            } else {
                Student top = minPriorityQueue.peek();
                if(array[i].age > top.age) {
                    minPriorityQueue.poll();
                    minPriorityQueue.offer(array[i]);
                }
            }
        }
        Student[] ret = new Student[k];
        for(int i = 0; i < k; i++) {
            ret[i] = minPriorityQueue.poll();
        }
        return ret;
    }
    public static int[] topK(int[] array,int k) {
        int len = array.length;
        if(k <= 0 || k > len) {
            return null;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < len; i++) {
            if(i < k){
                priorityQueue.offer(array[i]);
            } else {
                int val = priorityQueue.peek();
                if(array[i] < val){
                    priorityQueue.poll();
                    priorityQueue.offer(array[i]);
                }
            }
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        Student student1 = new Student(18,78);
        Student student2 = new Student(17,80);
        Student student3 = new Student(45,87);
        Student student4 = new Student(35,99);
        Student student5 = new Student(25,98);
        Student student6 = new Student(15,77);
        Student student7 = new Student(55,88);
        Student student8 = new Student(29,66);
        Student student9 = new Student(55,44);
        Student student10 = new Student(46,56);
        Student[] students = new Student[]{student1, student2, student3, student4,student5,student6,student7,student8,student9,student10};
        Student[] ret = topK2(students,3);
        for(int i = 0; i < 3; i++) {
            System.out.print(ret[i]);
        }
    }
}

```

