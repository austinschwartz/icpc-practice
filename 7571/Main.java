import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static long A, B;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int T = sc.nextInt();
    for (int t = 1; t <= T; t++) {
      A = sc.nextInt();
      B = sc.nextInt();
      long N = sc.nextInt();
      out.println(f2(N));
    }
    out.close();
  }

  public static long con = Long.valueOf((long)1e9) + 7L;

  public static long f2(long N) {
    if (N == 1) return A;
    if (N == 2) return B;
    if (N == 3) return Math.floorMod(B - A, con);
    if (N % 3 == 0) {
      if (N % 2 == 0)
        return Math.floorMod(A - B, con);
      else
        return Math.floorMod(B - A, con);
    }
    if ((N - 2) % 3 == 0) {
      if ((N - 2) % 2 == 0)
        return Math.floorMod(B, con);
      else
        return Math.floorMod(-B, con);
    }
    return Math.floorMod(f2(N - 1) - f2(N - 2), con);
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
