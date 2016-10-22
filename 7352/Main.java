import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int n = sc.nextInt();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int set = 0;
        for (char c : sc.nextLine().toCharArray())
          set |= (1 << (c - 'A'));
        list.add(set);
      }
      minc = changes(list);
      minChanges(list);
      out.println(minc);
    }
    out.close();
  }

  public static int minc = 0;
  public static int minChanges(List<Integer> list) {
    permute(list, 0, list.size() - 1);
    return 0;
  }

  public static void permute(List<Integer> list, int l, int r) {
    if (l == r) {
      minc = Math.min(minc, changes(list));
     } else {
      for (int i = l; i <= r; i++) {
        swap(list, l, i);
        permute(list, l + 1, r);
        swap(list, l, i);
      }
    }
  }

  public static void swap(List<Integer> list, int i, int j) {
    int temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
  }


  public static int changes(List<Integer> list) {
    int ret = 0;
    if (list.size() <= 1)
      return 0;
    for (int i = 0; i < list.size() - 1; i++) {
      int a = list.get(i);
      int b = list.get(i + 1);

      ret += Integer.bitCount(a & b);
    }
    return ret;
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
