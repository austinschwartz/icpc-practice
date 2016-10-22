import java.io.*;
import java.util.*;

public class Main {
  public static class TreeNode {
    public TreeNode left, right;
    public int val;
    public TreeNode(int val) {this.val = val;}
  }

  public static void preorder(TreeNode node) {
    if (node == null) return;
    preorder(node.left);
    System.out.println("- " + node.val);
    preorder(node.right);
  }

  public static PrintWriter out;
  public static void main(String[] args) {
    MyScanner sc = new MyScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    while (sc.hasNext()) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      List<TreeNode> trees = new ArrayList<>();
      int count = 0;
      for (int i = 0; i < n; i++) {
        int[] nums = new int[k];
        for (int j = 0; j < k; j++)
          nums[j] = sc.nextInt();
        TreeNode tree = makeTree(nums, k);
        if (treeNotInList(tree, trees))
          trees.add(tree);
      }
      out.println(trees.size());
    }
    out.close();
  }

  public static boolean treeNotInList(
      TreeNode tree, 
      List<TreeNode> trees
    ) {
    for (int i = 0; i < trees.size(); i++) {
      if (isSame(trees.get(i), tree)) {
        /*
        System.out.println("these two trees are equal");
        System.out.println("root - " + tree.val);
        preorder(tree);
        System.out.println("root - " + trees.get(i).val);
        preorder(trees.get(i));
        */
        return false;
      }
    }
 /*   System.out.println("adding tree");
    System.out.println(" ");
    preorder(tree); */
    return true;
  }

  public static boolean isSame(TreeNode a, TreeNode b) {
    if (a == null) {
      if (b == null) 
        return true;
      else 
        return false;
    }

    if (a.left == null && a.right == null) {
      if (b.left == null && b.right == null) {
        return true;
      } else {
        return false;
      }
    }

    if (a.left == null && b.left != null)
      return false;

    if (a.right == null && b.right != null)
      return false;

    if (a.left != null && b.left == null)
      return false;

    if (a.right != null && b.right == null)
      return false;

    if (isSame(a.left, b.left) && isSame(a.right, b.right))
      return true;

    return false;
  }

  public static TreeNode makeTree(
      int[] nums, 
      int n
    ) {
    TreeNode root = new TreeNode(nums[0]);
    for (int i = 1; i < n; i++)
      insert(root, nums[i]);
    return root;
  }
  
  public static void insert(TreeNode root, int val) {
    if (val < root.val) {
      if (root.left == null) {
        root.left = new TreeNode(val);
      } else {
        insert(root.left, val);
      }
    } else if (val > root.val) {
      if (root.right == null) {
        root.right = new TreeNode(val);
      } else {
        insert(root.right, val);
      }
    }
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
