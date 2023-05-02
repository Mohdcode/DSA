import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Binarytree {



    static class Node{//this is just a box
        //static so it never changes
        //class for node or box
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    static class Tree {// binary tree building here
        static int idx = -1;

        public static Node builtree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;//here we setting the tree node if the -1 is there
            }
            //it's preorder tree
            Node newnode = new Node(nodes[idx]);//creating new node by the data stored on index
            newnode.left = builtree(nodes);//first getting into left till end
            newnode.right = builtree(nodes);//then into right
            return newnode;

        }

        public static void preorder(Node root) {//here we are giving the whole tree which we have built using root
            if (root == null) {

                return;
            }
            System.out.print(root.data + " ");//preorder

            preorder(root.left);
            preorder(root.right);
        }

        public static void Inorder(Node root) {//here we are giving the whole tree which we have built using root
            if (root == null) {

                return;
            }


            Inorder(root.left);
            System.out.print(root.data + " ");//in order
            Inorder(root.right);//getting the right
        }
        public static void postrder(Node root) {//here we are giving the whole tree which we have built using root
            if (root == null) {

                return;
            }


            postrder(root.left);

            postrder(root.right);//getting the right
            System.out.print(root.data + " ");//post order
        }
        //level order trversal
        public static void level(Node root){//how many levels
            int sum=0;
            if (root==null){
                return;
            }
            Queue<Node> qu=new LinkedList<>();
            qu.add(root);//putting first root in the queue
            qu.add(null);

            while(!qu.isEmpty()){
                Node cur=qu.remove();//taking out the que element

                if (cur==null){
                    System.out.println();
                    if (qu.isEmpty()){
                            break;
                    }else{//when you have to remove null the  you have to put null again if there are element in the queue
                        qu.add(null);
                    }
                }
//if curr root is not null then move forward by storing for its child
                else{
                    sum+=cur.data;
                    System.out.print(cur.data+" ");
//both should check that why if for both no matter what ?
                    if (cur.left!=null){
                        qu.add(cur.left);//adding the cur root's left and right side
                    } if(cur.right!=null){
                        qu.add(cur.right);
                    }
                }
            }
            System.out.println("sum using queue in level order is "+sum);
        }
        public static int height(Node root){
            if (root ==null){
                return 0;
            }
            int l=height(root.left);
            int r=height(root.right);
            return Math.max(l,r)+1;//maximum node of root +  root
        }
        public static int countnode(Node root){
            if (root ==null){
                return 0;
            }
            int l=countnode(root.left);
            int r=countnode(root.right);
            return l+r+1;// sub root +  node
        }
        public static int sumnode(Node root){
            if (root ==null){
                return 0;
            }
            int l=sumnode(root.left);
            int r=sumnode(root.right);
            return l+r+ root.data;// sub node.data
        }

        public int diameter(Node root) {  //O(n^2)
            if (root==null){
                return 0;
            }

            int lh=height(root.left);
            int rh=height(root.right);
            int selfnodediameter=lh+rh+1;//height of subtree and if the distance between l and f is greater then curr node
            return Math.max(selfnodediameter,Math.max(diameter(root.left),diameter(root.right)));
        }
        public static boolean issubtree(Node root, Node subroot){
            if(root ==null){
                return false;
            }
            if(root.data == subroot.data){//if root data are same then check
                if(isidentical(root,subroot)){
                    return true;

                }
            }
            //the reason we don't use subroot.left cuz we are looking for the subroot to be identical to root so we can check if they are identical or not
            return issubtree(root.left,subroot)||issubtree(root.right,subroot);
        }

        private static boolean isidentical(Node root, Node subroot) {

            if (root ==null && subroot ==null){
                return true;
            } else if (root==null || subroot ==null || root.data != subroot.data)  {
                return false;

            }
            if(!isidentical(root.left,subroot.left)){
                return false;
            }
            return isidentical(root.right, subroot.right);
        }
        static class info{
            Node node;
            int hd;

            public info(Node node,int hd) {
                this.node = node;//node
                this.hd=hd; //horizontal distance
            }
        }
        public static void topview(Node root){
            Queue<info>q=new LinkedList<>();//string the both node and distance
            HashMap<Integer,Node>map=new HashMap<>();//used hashmao here to get the unique value
            int min=0,max=0;//min and max are tack the distance from the root of the tree
            q.add(new info(root,0));
            q.add(null);
            while(!q.isEmpty()){
                info curr=q.remove();
                if(curr==null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }
                else{if(!map.containsKey(curr.hd)){//if the curr distance is not in the map or must be unique
                    map.put(curr.hd,curr.node);

                }
                if (curr.node.left!=null){
                    q.add(new info(curr.node.left, curr.hd-1));//think of graph
                    min=Math.min(min, curr.hd-1);
                }
                if (curr.node.right!=null){
                    q.add(new info(curr.node.right, curr.hd+1));
                    max=Math.max(max, curr.hd+1);
                }
            }}
            for (int i=min;i<=max;i++){
                System.out.print(map.get(i).data);
            }
        }
        static void klevel(Node root, int level, int k){
            if (root==null){
                return;
            }
            if (level==k){//if level is same then print it
                System.out.print(root.data);
                return;

            }
            klevel(root.left, level+1, k);//go left
            klevel(root.right, level+1, k);//go right
        }


        static Node lca(Node root,int n1,int n2){
            ArrayList<Node>path1=new ArrayList<>();
            ArrayList<Node>path2=new ArrayList<>();
            getPath(root,n1,path1);//checking in just single time adding into arraylist
            getPath(root,n2,path2);

            int i=0;
            for(;i<path1.size() && i<path2.size();i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            Node lca=path1.get(i-1);//cuz the i while checking would have move by 1 that's why 1 need to be canceled
            return lca;
        }

        private static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if(root==null){
                return false;
            }
            path.add(root);
            if(root.data==n){
                return true;
            }

          boolean l=  getPath(root.left, n, path);
           boolean r= getPath(root.right, n, path);

            if (l||r){//important
                return true;
            }
            path.remove(path.size()-1);//if false remove the last indexed element cuz that's not useful
            return false;


        }
        private static boolean getPath1(Node root, int n1,int n2) {
            if(root==null){
                return false;
            }

            if(root.data==n1 || root.data==n2){//if the value is found then return
                return true;
            }

            boolean l=  getPath1(root.left, n1,n2);
            boolean r= getPath1(root.right, n1,n2);

           if (l&&r) {//if we both the subtree has the node then return the root
            System.out.println(root.data);

          } if(l||r){
                return true;

            }


            return false ;


        }
        private static Node lca2(Node root, int n1,int n2) {

            if(root==null || root.data==n1 || root.data==n2){
                return root;}

            Node l=  lca2(root.left, n1,n2);
            Node r= lca2(root.right, n1,n2);

             if(l==null){//if left is null then the value is right
                 return r;

            }   if(r==null){
                return l;

            }


            return root ;


        }
        static int mindist(Node  root,int n1,int n2){
            Node lca=lca2(root, n1, n2);
            //from lca root
           int d1= lcadist(lca,n1);//lca dist from given to lca node
           int d2=lcadist(lca,n1);

           return d1+d2;
        }

        private static int lcadist(Node root, int n) {
            if (root==null){
                return -1;
            }if(root.data==n){
                return 0;
            }
            int l=lcadist(root.left, n);
            int r=lcadist(root.right,n);
            if (l==-1 && r==-1){
                return -1;
            }else if (l==-1){
                return r+1;
            }else {
                return l+1;
            }
        }
        static int Kancestor(Node root,int n,int k){

            if(root==null){
                return -1;
            }if(root.data ==n){//you are the node
                return 0;
            }
            int l=Kancestor(root.left, n, k);
            int r=Kancestor(root.right, n, k);
            if(l==-1 && r==-1){//if booth are not the node
                return -1;
            }
            int max=Math.max(l,r);//max node
            if(max+1==k){//max+1 is the k level
                System.out.println(root.data);
            }
            return max+1;//then retrun it

        }
        static int sumofsubnode(Node root){
            if (root==null){
                return 0;
            }
            int l=(sumofsubnode(root.left));
            int r=(sumofsubnode(root.right));

            int data =root.data;//storing the data of which node remove actual data
            int newleft=root.left==null?0:root.left.data;
            int newright=root.right==null?0:root.right.data;

            root.data=newleft+l+newright+r;//here we get the data of the whole sub node
            return data;//here returning the old data of the node
        }

    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        int maxPathSum = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathSumHelper(root);
            return maxPathSum;//we have got the maximum of all
        }

        private int maxPathSumHelper(TreeNode node) {//helper function is  to find all the combination which could have been the maximum
            if (node == null) {
                return 0;
            }

            // Recursively compute the maximum path sum for the left and right subtrees
            int leftMax = Math.max(maxPathSumHelper(node.left), 0);
            int rightMax = Math.max(maxPathSumHelper(node.right), 0);

            // Compute the maximum path sum that includes the current node
            int nodeMax = node.val + leftMax + rightMax;//what can be node maximum

            // Update the global maximum path sum
            maxPathSum = Math.max(maxPathSum, nodeMax);

            // Return the maximum path sum that can be extended from the current node
            return node.val + Math.max(leftMax, rightMax);//maximum from one side and itself because we are finding from the single side that's why we can't retrun both
        }
    }


    public static void main(String[] args) {
        int []node={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};


        Tree tree=new Tree();
        Node root= Tree.builtree(node);

        System.out.println(root.data);//here we are printing the data
        Tree.preorder(root);//here we are just giving the boxes only
        System.out.println();
        Tree.Inorder(root);
        System.out.println();
        Tree.postrder(root);
        System.out.println();
        Tree.level(root);
        System.out.println(Tree.height(root));//cuz the function is static
        System.out.println(Tree.countnode(root));
        System.out.println(Tree.sumnode(root));
        System.out.println(tree.diameter(root));

        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        System.out.println(Tree.issubtree(root,subroot));
        Tree.topview(root);
        System.out.println();
        int k=2;
        Tree.klevel( root,0, k);
        System.out.println();
        System.out.println(Tree.lca(root,4, 6).data );
        Tree.getPath1( root, 4,6);
        Tree.Kancestor( root, 4,1);
        Tree.sumofsubnode(root);
        Tree.Inorder(root);








    }
}
