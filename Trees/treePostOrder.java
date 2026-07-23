import java.util.*;
class treePostOrder {
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
    public static void postOrderRec(Node root){
        if(root==null){
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.data+" ");
    }
    public static void postOrderTwoSt(Node root){
        if(root==null){
            return;
        }
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();
        
        st1.push(root);
        while(!st1.isEmpty()){
            Node curr=st1.pop();
            st2.push(curr);
            
            if(curr.left!=null){
                st1.push(curr.left);
            }
            
            if(curr.right!=null){
                st1.push(curr.right);
            }
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().data+" ");
        }
    }
    
    public static void postOrderOneSt(Node root){
        if(root==null){
            return;
        }
        Stack<Node> st=new Stack<>();
        Node current=root;
        Node lastVisited=null;
        
        while(!st.isEmpty() || current!=null){
            if(current!=null){
                st.push(current);
                current=current.left;
            }
            else{
                Node peekNode=st.peek();
                
                if(peekNode.right!=null && peekNode.right!=lastVisited){
                    current=peekNode.right;
                }
                else{
                    System.out.print(peekNode.data+" ");
                    lastVisited=st.pop();
                }
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
        postOrderOneSt(root);
    }
}