import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int house = 1;
    while (true) {
      int W = sc.nextInt();
      int L = sc.nextInt();
      if (W == 0 && L == 0)
        break;
      int[] entrance = new int[]{1, 1};

      char[][] maze = new char[L][W];
      for (int i = 0; i < L; i++) {
        String line = sc.nextLine();
        for (int j = 0; j < W; j++) {
          maze[i][j] = line.charAt(j);
          if (maze[i][j] == '*')
            entrance = new int[]{i, j};
        }
      }

      int i = entrance[0];
      int j = entrance[1];
      maze[i][j] = '.';
      Direction dir = Direction.UP;
      if (i == 0) dfs(maze, L, W, i + 1, j, Direction.DOWN); 
      else if (i == L - 1) dfs(maze, L, W, i - 1, j, Direction.UP); 
      else if (j == 0) dfs(maze, L, W, i, j + 1, Direction.RIGHT);
      else if (j == W - 1) dfs(maze, L, W, i, j - 1, Direction.LEFT);
     
      maze[entrance[0]][entrance[1]] = '*';

      out.println(String.format("HOUSE %d", house++));
      for (int ii = 0; ii < L; ii++) {
        StringBuilder sb = new StringBuilder();
        for (int jj = 0; jj < W; jj++) {
          sb.append(maze[ii][jj]);
        }
        out.println(sb.toString());
      }
    }
    out.close();
  }

  public static void dfs(char[][] maze, int L, int W, int i, int j, Direction dir) {
    if (i < 0 || j < 0 || i >= L || j >= W)
      return;

    if (maze[i][j] == 'x') {
      maze[i][j] = '&';
      return;
    }

    if (maze[i][j] == '/') {
      switch (dir) {
        case DOWN:
          dfs(maze, L, W, i, j - 1, Direction.LEFT);
          break;
        case UP:
          dfs(maze, L, W, i, j + 1, Direction.RIGHT);
          break;
        case LEFT:
          dfs(maze, L, W, i + 1, j, Direction.DOWN);
          break;
        case RIGHT:
          dfs(maze, L, W, i - 1, j, Direction.UP);
          break;
      }
      return;
    } else if (maze[i][j] == '\\') {
      switch (dir) {
        case DOWN:
          dfs(maze, L, W, i, j + 1, Direction.RIGHT);
          break;
        case UP:
          dfs(maze, L, W, i, j - 1, Direction.LEFT);
          break;
        case LEFT:
          dfs(maze, L, W, i - 1, j, Direction.UP);
          break;
        case RIGHT:
          dfs(maze, L, W, i + 1, j, Direction.DOWN);
          break;
      }
    } else  {
      switch (dir) {
        case DOWN:
          dfs(maze, L, W, i + 1, j, dir);
          break;
        case UP:
          dfs(maze, L, W, i - 1, j, dir);
          break;
        case LEFT:
          dfs(maze, L, W, i, j - 1, dir);
          break;
        case RIGHT:
          dfs(maze, L, W, i, j + 1, dir);
          break;
      }
    }



  }

  public enum Direction {RIGHT, LEFT, UP, DOWN};


  public static class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner() {
       br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public boolean hasNext() {
      try {
        boolean a = br.ready();
        return a;
      } catch (IOException e) {
        return false;
      }
    }

    public String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }
 
    public int nextInt() {
      return Integer.parseInt(next());
    }
 
    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char nextChar() {
      return next().charAt(0);
    }

    public String nextLine() {
      String str = "";
      try {
         str = br.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return str;
    }
  }
}
