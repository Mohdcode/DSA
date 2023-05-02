import java.util.*;

public class Queues {
    private class Node {
        private int val;
        private Node next;

        private Node(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public class Qlink {//queue using linked list
        static Node head;
        static Node tail;

        public boolean isempty() {
            return head == null && tail == null;
        }

        public void add(int data) {
            if (isempty()) {
                Node newnode = new Node(data);
                tail = head = newnode;
            }

            Node newnode = new Node(data);
            tail.next = newnode;
            tail = newnode;

        }

        public int remove() {
            int result = head.val;
            head = head.next;
            return result;
        }

        public int peek() {
            return head.val;
        }
    }

    public static class Qarr {//queue using array

        //circular queue
        static int[] arr;
        static int size;
        static int rear;
        static int front;


        Qarr(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;


        }//circular queue using array

        public static boolean isempty() {
            return rear == -1 && front == -1;
        }

        public static boolean isfull() {
            return (rear + 1) % size == front;
        }

        public static void add(int val) {
            if (isfull()) {
                System.out.print("full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;//index increasing
            arr[rear] = val;
        }

        public static int remove() {
            if (isempty()) {
                System.out.print("empty");
                return -1;
            }
            int result = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }//modular use in changing the index
            return result;
        }

        public static int peek() {
            if (isempty()) {
                System.out.print("empty");
                return -1;
            }
            return arr[front];
        }


    }





    public static void main(String[] args) {
        Queue<Integer> qu = new ArrayDeque<>();
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6,};
        int k = 3;


        String s = "aabccxb";
        Unique(s);
        for (int i = 1; i <= 10; i++) {
            qu.add(i);
        }
        interleave(qu);
        while (!qu.isEmpty()) {
            System.out.print(qu.remove() + " ");
        }
        System.out.println(reverse("aabccxb"));
        Maximumsub(arr, k);
        System.out.println();
        printMax(arr, arr.length, k);
        System.out.println();
        generatePrintBinary( 10);

    }



        static void printMax(int arr[], int n, int k){
        Deque<Integer> Qi = new LinkedList<Integer>();
        //deque can be used as stick and queue
        int i;//O(n)
        for (i = 0; i < k; ++i) {//getting first K size window max
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]){
                Qi.removeLast();
            }
            Qi.addLast(i);//adding into queue
        }
        for (; i < n; ++i) {//then following
            System.out.print(arr[Qi.peek()] + " ");//peek in the first element

            while ((!Qi.isEmpty()) && Qi.peek() <=i - k){//to remove the element index out of the index
                Qi.removeFirst();
            }//if the element maximum but out the sliding window
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]){//again same comparison that we did in starting loop
                Qi.removeLast();//if the element next in arr is greater thne the peek last then remove from last cuz that's not useful at all
            }
            Qi.addLast(i);//adding at every single element at last and checking if that element is useful or not
        }
        System.out.print(arr[Qi.peek()]);//it's for the last element remaining in the deque
    }
    static void generatePrintBinary(int n){
        Queue<String> q = new LinkedList<String>();
        q.add("1");//binary start with number
        while (n-- > 0) {
            String s1 = q.remove();//string is changing everytime
            System.out.println(s1);
            String s2 = s1;// first string
            q.add(s1 + "0");
            q.add(s2 + "1");
        }}

            private static void Maximumsub ( int[] arr, int k){
                int[] arr1 = new int[arr.length - k + 1];
                int p = 0;
                int max = arr[0];
                //brute force for sliding window


                for (int i = 0; i < arr.length - k + 1; i++) {//order matter of arr.length-k+1 as operator works from
                    for (int j = 0; j < k; j++) {
                        if (arr[i + j] > max) {
                            max = arr[i + j];
                        }


                    }
                    if (p < arr1.length) {
                        arr1[p] = max;
                        p++;
                    }
                    // System.out.print(max+" ");

                }
                for (int l = 0; l < arr1.length; l++) {
                    System.out.print(arr1[l] + " ");
                }
            }

            private static String reverse (String s){
                String s1 = "";
                Stack<Character> st = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                    st.add(s.charAt(i));

                }
                while (!st.isEmpty()) {
                    char ch = st.pop();
                    s1 = s1 + ch;
                }
                return s1;
            }

            private static void interleave (Queue < Integer > qu) {
                Queue<Integer> Firsthalf = new ArrayDeque<>();
                int size = qu.size();
                for (int i = 0; i < size / 2; i++) {
                    Firsthalf.add(qu.remove());//first half added in new que
                }
                while (!Firsthalf.isEmpty()) {
                    //adding and removing at the same time in the old queue
                    qu.add(Firsthalf.remove());
                    qu.add(qu.remove());
                }
            }

            private static void Unique (String s){
                Queue<Character> qu = new ArrayDeque<>();
                int[] arr = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    char ch = s.charAt(i);
                    qu.add(s.charAt(i));
                    arr[ch - 'a']++;//increment that index by one
                    while (!qu.isEmpty() && arr[qu.peek() - 'a'] > 1) {//checking queue
                        qu.remove();

                    }
                } System.out.println(qu.peek() + " ");

            }
        }