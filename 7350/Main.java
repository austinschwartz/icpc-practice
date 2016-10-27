import java.io.*;
import java.util.*;

public class Main {
  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    int count = 0, time = 0;
    int[] penalties = new int[26];
    while (sc.hasNext()) {
      String line = sc.nextLine();
      if (line.equals("-1")) {
        System.out.println(count + " " + time);
        count = 0;
        time = 0;
        Arrays.fill(penalties, 0);
        continue;
      }
      String[] splitLine = line.split(" ");
      int m = Integer.parseInt(splitLine[0]);
      int c = splitLine[1].charAt(0) - 'A';
      boolean right = splitLine[2].equals("right");
      
      if (penalties[c] == -1)
        continue;

      if (right) {
        time += m + (20 * penalties[c]);
        penalties[c] = -1;
        count += 1;  
      } else {
        penalties[c] += 1;
      }
    }
    out.close();
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
