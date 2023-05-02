import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Heaps {
    static class Student implements Comparable<Student> {
        String name;
        int rank;


        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student o) {//have to override cuz of interface
            return this.rank - o.rank;//this tell to compare only onthe bases of primitive data type or object
            //of this value
            //if -ve then smaller
            //if +ve then greater
            //if zero then equal
        }
    }

    public static void main(String[] args) {
        int arr[]=new int[]{1, 2, 34, 3453, 244, 3, 2, 4};

       System.out.print(Arrays.toString(heap.heapsort(arr)));

        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 3));
        pq.add(new Student("B", 38));
        pq.add(new Student("C", 4));
        pq.add(new Student("D", 6));
//also can use for sorting
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + "->>>>>" + pq.peek().rank);
            pq.remove();
        }
//nearest cars solution
        PriorityQueue<point> p = new PriorityQueue<>();//these  are implemented using heaps internally
        int k = 2;
        int[][] pts = {{3, 3}, {5, -1}, {-2, 4}};
        for (int i = 0; i < pts.length; i++) {
            int sqrt = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            p.add(new point(pts[i][0], pts[i][1], sqrt));
        }
        for (int i = 0; i < k; i++) {
            System.out.println(p.remove().sqrt);
        }
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        int[] rope = {2, 3, 3, 4, 6};
        for (int i = 0; i < rope.length; i++) {
            p1.add(rope[i]);
        }
        int cost = 0;
        while (p1.size() > 1) {
            int min = p1.remove();
            int min2 = p1.remove();
            cost += min + min2;
            p1.add(min + min2);
        }
        System.out.println("my cost of connecting ropes" + cost);


    }
    //there are two was to make heap tree
    //1 is using priority queue
    //2 is is by using this method to keep the tree balanc
    // ArrayList<Integer> arr=new ArrayList<>();
//    public void add(int data){
//        //complete binary tree
//        //add at last index
//        arr.add(data);
//        int x=arr.size()-1;
//        int par=(x-1)/2;//parent index
//        while(arr.get(x)<arr.get(par)){// log n
//            //swapping part
//            int temp=arr.get(x);
//            arr.set(x,arr.get(par));
//            arr.set(par,temp);
//            x=par;
//            par=(x-1)-2;
//}

        static class heap{//can't use binary tree class cuz we have to leap the tree complete balance binary tree
        //to inset in heap
        ArrayList<Integer> arr=new ArrayList<>();
        public void add(int data){
            //complete binary tree

            arr.add(data); //add at last index
            int x=arr.size()-1;
            int par=(x-1)/2;//parent index

            //now fixing the heaap after adding the lement
            while(arr.get(x)<arr.get(par)){// for min heap



                //swapping part
                int temp=arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                //now changing the x or last index u add in arraylist in the parent index
                x=par;//updating the value
                par=(x-1)-2;//then again have to change parent too
            }

        }
         int peek(){
            return arr.get(0);

        }
        private void heapify(int i){//to correct the heap property for minimum heap tree
            //i would be changed into min idx
            int left=2*i+1;
            int right=2*i+2;
            int minidx=i;
            if(left<arr.size() && arr.get(minidx)>arr.get(left)){
                minidx=left;
            }   if(right<arr.size() && arr.get(minidx)>arr.get(right)){
                minidx=right;
            }

            if(minidx!=i){//after getting the min elemeent index from from left and right then swap and move forward from curr index for new min
                int temp=arr.get(i);
                arr.set(i,arr.get(minidx));
                arr.set(minidx,temp);
                heapify(minidx);//again we will check for the minimum we got

            }

        }
        public int remove(){
            int data=arr.get(0);
            int temp=arr.get(0);
            //swapping cuz it's easy to remove from last index in heap
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            arr.remove(arr.size()-1);
            heapify(0);//then just correcting the array
            //till now was removing and storing the value
            return data;//to transfer the data we have removed from the heap
        }
        public static int[] heapsort(int []arr){
            int n=arr.length;
            for(int i=n/2;i>=0;i--){//half sorting
              //main
                heapify(arr,i,n);

            }
            for(int i=n-1;i>0;i--){//then sorting from back till 0
                //swapping the first element to the last and forgetting as a part of the element as it is already sorted
                int temp=arr[0];
                arr[0]=arr[i];
                arr[i]=temp;

                heapify(arr,0,i);//sizing changing everytime
            }

            return arr;
        }
        static void heapify(int []arr,int i,int size){//to compelete the property of heap
            int left=2*i+1;
            int right=2*i+2;
            int maxidx=i;
            if(left<size && arr[left]>arr[maxidx]){
                maxidx=left;
            }
            if(right<size && arr[right]>arr[maxidx]){
                maxidx=right;
            }
            if(maxidx!=i){
                int temp=arr[i];
                arr[i]=arr[maxidx];
                arr[maxidx]=temp;
                heapify(arr,maxidx,size);
            }


        }

    }
    static class point implements Comparable<point>{
        int x;
        int y;
        int sqrt;
        public point(int x,int y,int sqrt){
            this.x=x;
            this.y=y;
            this.sqrt=sqrt;
        }

        @Override
        public int compareTo(point o1) {
            return this.sqrt- o1.sqrt;
        }
    }
}
