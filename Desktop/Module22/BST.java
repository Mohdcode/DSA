public class BST {
    static class Node{//this is just a box
        //static so it never changes
        //class for node or box
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;

        }}
        public static void Inorder(Node root) {//here we are giving the whole tree which we have built using root
            if (root == null) {

                return;
            }


            Inorder(root.left);
            System.out.print(root.data + " ");//in order
            Inorder(root.right);//getting the right
        }

    static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if (root.data>val){
            root.left=insert(root.left,val);
        }else {
            root.right=insert(root.right,val);
        }return root;
    }
    static boolean search(Node root,int key){
        if(root==null){

            return false;
        }
        if (root.data==key){
            return true;
        }
        if (root.data>key){
            return search(root.left,key);
        }else {
         return search(root.right,key);
        }
    }
    static Node delete(Node root,int key){
        if (root.data<key) {
            root.right=delete(root.right, key);
        }else if(root.data>key){
            root.left=delete(root.left,key);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }else  if(root.right==null){
                return root.left;
            }
            Node IS=Inordersuccessor(root.right);
            root.data= IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
        }

    private static Node Inordersuccessor(Node root) {
        while(root.left!=null){

            root=root.left;//updating the value
        }return root;
    }
    static void printinrange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printinrange(root.left,k1,k2);
            System.out.print(root.data+" ");//printing part only just like inorder traversal
            printinrange(root.right,k1,k2);
        }else if(root.data<k1){
            printinrange(root.left,k1,k2);

        }else{
            printinrange(root.right,k1,k2);
        }
    }
    static boolean validBST(Node root,Node min,Node max){
        //also can check is validate or not by printing the node int inorder and if they are sorted then yes or else false
        if (root == null){
            return true;
            //chhecking if the rul BST validate or not if the root smaller or greater then the sub node
        }if (min!=null && min.data>= root.data)//min and max will change when there node will change
        {
        return false;}
        if (max!=null && max.data<= root.data)
        {
            return false;}
        return validBST(root.left,min,root) && validBST(root.right,root,max);//min from left and maximum from right
    }
    static Node mirror(Node root){
        //we are not creating any new Node here or any new tree
        if (root==null){
            return null;
        }
        //we are just swipping the right and left side only as the root node would be same no matter what
        Node leftmirror=mirror(root.left);//storing the real node
        Node rightmirror=mirror(root.right);

        root.left=rightmirror;//swapping the node from the mirror one
        root.right=leftmirror;
        return root;
    }
    static Node createBST(int arr[],int s,int e){//create bst using sorted array
        if (s>e){
            return null;
        }
        int mid =s+(e-s)/2;
        Node root=new Node(arr[mid]);//root
        root.left=createBST(arr,s,mid-1);//creating node
        root.right=createBST(arr,mid+1,e);
        return root;

    }

    public static void main(String[] args) {
        int []value={5,1,3,4,2,7};
        Node root=null;
        for (int j : value) {//here we have to pass the pass from arr every time
            root = insert(root, j);
        }



Inorder(root);
       System.out.println( search(root,3 ));
        System.out.println(validBST(root,null,null));
    }



}
