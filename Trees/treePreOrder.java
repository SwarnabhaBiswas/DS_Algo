import java.util.*;
class Main {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void preOrderRec(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }
    
    public static void preOrderSt(Node root){
        if(root==null){
            return;
        }
        Stack<Node> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr=st.pop();
            System.out.print(curr.data+" ");
            if(curr.right!=null){
                st.push(curr.right);
            }
            if(curr.left!=null){
                st.push(curr.left);
            }
        }
    }
    
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        preOrderSt(root);
    }
}