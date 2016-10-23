import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int P = sc.nextInt();
    for (int p = 1; p <= P; p++) {
      int K = sc.nextInt();
      int[] arr = new int[12];
      for (int i = 0; i < 12; i++) {
        arr[i] = sc.nextInt();
      }
      out.println(String.format("%d %d", K, f(arr)));
    }
    out.close();
  }

  public static int f(int[] nums) {
    int islands = 0, level = 0, prev = 0;
    int[] levels = new int[12];
    levels[0] = 0;

    for (int i = 1; i < 12; i++) {
      int curr = nums[i];
      if (curr > prev) {
        level++;
        islands++;
        levels[level] = curr;
      } else if(curr < prev) {
        while (level > 0 && curr < levels[level]) {
          level--;
        }
        if (curr > levels[level]) {
          level++;
          islands++;
          levels[level] = curr;
        }
      }
      prev = curr;
    }

    return islands;
  }


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
