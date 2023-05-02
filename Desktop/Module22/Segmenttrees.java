public class Segmenttrees {
    static int [] tree;
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int buildsgt(int arr[],int i,int s,int e){
        if(s==e){
            tree[i]=arr[s];
            return arr[s];
        }
        int mid =(s+e)/2;
        buildsgt(arr,2*i+1,s,mid);
        buildsgt(arr,2*i+2,mid+1,e);
        tree[i]=tree[2*i+1]+tree[2*i+2];//adding the tree sub node and making it parent node
        return tree[i];
    }
    public static int getsumutil(int i,int si,int sj,int qi,int qj){
        //range query sum
        if(qj<=si || qi>=sj){// to not overlap
            return 0;
        }
        else if(si>=qi && sj <=qj){ // to not overlap
            return tree[i];
        }
        else{
            int mid=(si+sj)/2;
            int left=getsumutil(2*i+1,si,mid,qi,qj);
            int right=getsumutil(2*i+2,mid+1,sj,qi,qj);
            return left+right;
        }
    }
    public static int getsum(int arr[],int qi,int qj){
        int n=arr.length;
        return getsumutil(0,0,n-1,qi,qj);
    }
    public static void update(int arr[],int idx,int newval){
        int n= arr.length;
        int diff=newval-arr[idx];
        arr[idx]=newval;
        updateutil(0,0,n-1,idx,diff);
    }



    public static void updateutil(int i,int si,int sj,int idx,int diff ){
        if(idx>=sj || idx <=si){
            return;
        }
        tree[i]+=diff;
        if(si!=sj){
            int mid =(si+sj)/2;
            updateutil(2*i+1,si,mid,idx,diff);
            updateutil(2*i+2,mid+1,sj,idx,diff);


        }
    }


    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buildsgt(arr,0,0,n-1);
        for (int i = 0; i < tree.length; i++) {
            System.out.println(tree[i]);
        }
    }
    static class MaxMinSegmentTree {
        int[] maxTree;
        int[] minTree;
        int n;

        public MaxMinSegmentTree(int[] arr) {
            n = arr.length;
            maxTree = new int[4 * n];
            minTree = new int[4 * n];
            buildMaxMinSegmentTree(arr, 1, 0, n - 1);
        }

        private void buildMaxMinSegmentTree(int[] arr, int treeIndex, int lo, int hi) {
            if (lo == hi) {
                maxTree[treeIndex] = arr[lo];
                minTree[treeIndex] = arr[lo];
                return;
            }
            int mid = lo + (hi - lo) / 2;
            buildMaxMinSegmentTree(arr, 2 * treeIndex, lo, mid);
            buildMaxMinSegmentTree(arr, 2 * treeIndex + 1, mid + 1, hi);
            maxTree[treeIndex] = Math.max(maxTree[2 * treeIndex], maxTree[2 * treeIndex + 1]);
            minTree[treeIndex] = Math.min(minTree[2 * treeIndex], minTree[2 * treeIndex + 1]);
        }

        public int queryMax(int lo, int hi) {
            return queryMaxutil(1, 0, n - 1, lo, hi);
        }

        private int queryMaxutil(int treeIndex, int left, int right, int lo, int hi) {
            if (left >= lo && right <= hi) {
                return maxTree[treeIndex];
            }
            if (right < lo || left > hi) {
                return Integer.MIN_VALUE;
            }
            int mid = left + (right - left) / 2;
            return Math.max(queryMaxutil(2 * treeIndex, left, mid, lo, hi),
                    queryMaxutil(2 * treeIndex + 1, mid + 1, right, lo, hi));
        }

        public int queryMin(int lo, int hi) {
            return queryMinutil(1, 0, n - 1, lo, hi);
        }

        private int queryMinutil(int treeIndex, int left, int right, int lo, int hi) {
            if (left >= lo && right <= hi) {
                return minTree[treeIndex];
            }
            if (right < lo || left > hi) {
                return Integer.MAX_VALUE;
            }
            int mid = left + (right - left) / 2;
            return Math.min(queryMinutil(2 * treeIndex, left, mid, lo, hi),
                    queryMinutil(2 * treeIndex + 1, mid + 1, right, lo, hi));
        }
    }

}
