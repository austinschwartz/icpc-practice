import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      String[] line = sc.nextLine().split(" ");
      out.println(f(line[0], line[1]) ? "PASS" : "FAIL");
    }
    out.close();
  }

  public static boolean f(String a, String b) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length(); i++)
      map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);

    int i = 0, j = 0;
    while (i < a.length() && j < b.length()) {
      if (map.containsKey(b.charAt(j))) {
        if (a.charAt(i) == b.charAt(j)) {
          i++;
          if (i == a.length()) 
            return true;
        } else {
          return false;
        }
        if (map.get(b.charAt(j)) == 1)
          map.remove(b.charAt(j));
        else
          map.put(b.charAt(j), map.get(b.charAt(j)) - 1);
      }
      j++;
    }
    return false;
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
