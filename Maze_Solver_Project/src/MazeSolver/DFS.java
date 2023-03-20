package MazeSolver;

import java.util.List;

public class DFS {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if (maze[y][x] == 9) {
            path.add(x);
            path.add(y);
            return true;
        }

        if (maze[y][x] == 0) {
            maze[y][x] = 2;
            if (searchPath(maze, x - 1, y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            if (searchPath(maze, x + 1, y, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            if (searchPath(maze, x, y - 1, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            if (searchPath(maze, x, y + 1, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
            maze[y][x]=0;
        }
        return false;
    }
}

