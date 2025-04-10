import java.util.*;

public class ZigZag {


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int key) {
            this.data = key;
            this.left = null;
            this.right = null;
        }
    }

    static List<List<Integer>> zigzag(Node root)
    {
        if(root == null)
        {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        Deque<Node> q = new ArrayDeque<>();
        boolean left = false;
        q.offer(root);

        while (!q.isEmpty())
        {
            List<Integer> t = new ArrayList<>();
            int n = q.size();

            for( int i = 0; i < n ; i++)
            {

                Node node = q.poll();
                t.add(node.data);
                if(node.left != null)
                {
                    q.offer(node.left);
                }

                if(node.right != null)
                {
                    q.offer(node.right);
                }
            }

            if(left)
            {
                Collections.reverse(t);
            }
            res.add(t);
            left = !left;
        }
return res;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);


        List<List<Integer>> sol = zigzag(root);

        for (List ans : sol)
        {
            for (Object data : ans)
            {
                System.out.println(data);
            }
        }

    }
}
