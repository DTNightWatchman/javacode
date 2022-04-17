package demo13;

import java.util.Scanner;

public class Main {
    public static int[][] direction = {{0,-1}, {-1,0}, {0,1}, {1,0}};
    public static void dfs(int x, int y, char[][] maze, int[][] map) {
        for (int i = 0; i < 4; i++) {
            int xx = x + direction[i][0];
            int yy = y + direction[i][1];
            if (xx >= 0 && xx < 10 && yy >= 0 && yy < 10
                    && maze[xx][yy] == '.' && map[xx][yy] > map[x][y]+1) {
                map[xx][yy] = map[x][y] + 1;
                dfs(xx,yy,maze,map);
            }

        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[10][10];
        char[][] chars =  new char[10][10];

        for (int i = 0; i < 10; i++) {
            String str = scanner.next();
            for (int i1 = 0; i1 < 10; i1++) {
                chars[i][i1] = str.charAt(i1);
                map[i][i1] = Integer.MAX_VALUE;
            }
        }
        map[0][1] = 0;
        dfs(0,1,chars,map);
        System.out.println(map[9][8]);
    }
}

//        #.########
//        #1  2  3  4  5  6  7  8#
//        #2  3  4  5  6  7  8  9#
//        #3  4  5  6  7  8  9  10#
//        #4  5  6  7  8  9  10 11#
//        #5  6  7  8  9  10 11 12#
//        #6  7  8  9  10 11 12 13#
//        #7  8  9  10 11 12 13 14#
//        #8  9  10 11 12 13 14 15#
//        ########.#


//        #.########
//        #........#
//        ########.#
//        #........#
//        #.########
//        #........#
//        ########.#
//        #........#
//        #.######.#
//        ########.#
