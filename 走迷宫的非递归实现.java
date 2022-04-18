package demo13;

import java.util.*;

public class Main1 {
    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public void func(int x, int y, char[][] chars, int[][] map) {
        Node begin = new Node(x,y);
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(begin);
        boolean[][] visited = new boolean[10][10];
        visited[x][y] = true;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int xx = node.x;
            int yy = node.y;

            for (int i = 0; i < 4; i++) {
                int xxx = xx + dir[i][0];
                int yyy = xx + dir[i][0];
                if (xxx >= 0 && yyy >= 0 && xxx < 10 && yyy < 10 && chars[xxx][yyy] == '.' && !visited[xxx][yyy]) {
                    Node newNode = new Node(xxx,yyy);
                    nodes.add(newNode);
                    map[xxx][yyy] = map[xx][yy] + 1;
                    visited[xxx][yyy] = true;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chars = new char[10][10];
        int[][] map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            String str = scanner.next();
            for (int j = 0; j < 10; j++) {
                chars[i][j] = str.charAt(j);
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        map[0][1] = 0;
        Main1 main1 = new Main1();
        main1.func(0,1,chars,map);
    }
}

//#.########
//#........#
//########.#
//#........#
//#.########
//#........#
//########.#
//#........#
//#.######.#
//########.#