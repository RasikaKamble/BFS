import java.util.*;

public class NTreeBFS {

    static class Node {
        int data;
        Vector<Node> children;

        Node(int data) {
            this.data = data;
            children = new Vector<Node>();
        }
    }

    static Node newNode(int key) {
        Node temp = new Node(key);
        return temp;
    }

    static List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            System.out.println("Nary tree is empty");

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                temp.add(node.data);
                for (Node child : node.children) {
                    q.offer(child);
                }
            }
            ans.add(temp);
        }
        return ans;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(newNode(2));
        root.children.add(newNode(3));
        root.children.add(newNode(4));
        root.children.get(0).children.add(newNode(5));
        root.children.get(0).children.add(newNode(6));
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> tree: res)
        {
             for(Integer data : tree)
             {
                 System.out.println(data +" ");
             }
        }


    }
}
