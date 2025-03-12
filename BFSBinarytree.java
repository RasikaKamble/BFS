import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSBinarytree {

    static class Node {
        int data;
        Node left, right;

        // Constructor to initialize a new node
        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    static LinkedList<LinkedList<Integer>> levelOrder(Node root) {

        if(root == null)
            return new LinkedList<>();

        Queue<Node> q = new LinkedList<>();
        LinkedList<LinkedList<Integer>> res = new LinkedList<>();

        q.offer(root);
        int curlevel = 0;
        while (!q.isEmpty())
        {
            int len = q.size();
            res.add(new LinkedList<>());

            for(int i=0;i<len;i++)
            {
                Node node = q.poll();
                res.get(curlevel).add(node.data);

                if(node.left != null)
                {
                    q.offer(node.left);
                }

                if(node.right != null)
                {
                    q.offer(node.right);
                }
            }
            curlevel++;

        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(5);

        LinkedList<LinkedList<Integer>> res = levelOrder(root);


        for( LinkedList<Integer> result : res)
        {
            for(Integer dt : result)
            {
                System.out.println(dt + " ");
            }
        }


    }
}
