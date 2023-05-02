import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Stacks {

    static class Node {//class for linked list box
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
        
    static class stack {
        static Node head = null;//initially pointing to null

        public static boolean isempty() {
            return head == null;
        }

        public static void push(int data) {
            Node newnode = new Node(data);
            if (isempty()) {
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        public static int pop() {
            if (isempty()) {
                return -1;
            }
            int top = head.val;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isempty()) {
                return -1;
            }
            return head.val;
        }

    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static boolean isempty() {
        return list.size() == 0;
    }

    //push
    public static void push(int data) {
        list.add(data);
    }

    //pop
    public static int pop() {
        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    //peek
    public static int peek() {
        int top = list.get(list.size() - 1);
        return top;
    }


    public static void main(String[] args) {
        LinkedList<Character> list=new LinkedList<>();
        String s="abcba";
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
            st.push(s.charAt(i));
        }
        System.out.print(Palindrome(list,st));



//        Stack s = new Stack();
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        while (!s.isempty()) {
//            System.out.println(s.peek());
//            s.pop();
        int [] arr ={1,0,9,3,2,6,4,5,3};
        int []arr1={100,80,60,70,60,85,100};
        System.out.println(Arrays.toString(Greaterarr(arr)));
        System.out.println(Arrays.toString(stockspan(arr1)));

        Stack<Integer> rev = new Stack<>();
        rev.push(1);
        rev.push(2);
        rev.push(3);
        reverse(rev);
        while (!rev.isEmpty()) {
            System.out.println(rev.peek());
            rev.pop();//decrement

        }
//        int []stocks={100,80,60,70,60,85,100};
//        int []span=new int[stocks.length];
//        stockspan(stocks,span);
//        for(int i=0;i<stocks.length;i++){
//            System.out.print(span[i]+" ");
//        }
//        stack s1 = new stack();
//        s1.push(1);
//        s1.push(2);
//        s1.push(3);
//        while (!s1.isempty()) {
//            System.out.println(s1.peek());
//            s1.pop();
//        }


//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        st.push(2);
//        st.push(3);


       // pushatbottom(st, 4);
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
        System.out.println(

                Reverse("abcd"));
        System.out.print(isBalanced("()]"));

    }

        private static boolean Palindrome(LinkedList<Character> list, Stack<Character> st) {
       while(!st.isEmpty() && !list.isEmpty()){
            char ch =st.pop();
            char ch1 =list.getFirst();
            list.removeFirst();
        if(ch1!=ch){

            return false;

            }}return true;
        }

        private static int[] Greaterarr(int[] arr) {//greatest on the right then loop from last to end
        int []great=new int[arr.length];//new arrat to sumbit the greater

        Stack<Integer>st=new Stack<>();//stack of integer in which  we are gonna push the array's  integer
        for(int i=arr.length-1;i>=0;i--){//loop from last to first
            if(st.isEmpty()){//if empty then push
                st.push(arr[i]);
                great[i]=-1;//then register it as -1
            }
            else if (arr[i]<st.peek()) {
                great[i]=st.peek();
                st.push(arr[i]);


            }

                while(!st.isEmpty() && arr[i]>=st.peek() ){
                    st.pop();}

                 if (! st.isEmpty() && arr[i]<st.peek()){
                    great[i]=st.peek();
                    st.push(arr[i]);


                } else if (st.isEmpty()) {

                    st.push(arr[i]);
                    great[i]=-1;
                 }


        }return great;
        }

        static int [] stockspan(int[] stocks) {//similar as greater element to the right just difference that you have to find the greatest elemt at index on the left
        int []span=new int[stocks.length];//new array
        Stack<Integer>col=new Stack<>();
        span[0]=1;
        col.push(0);
        for (int i=1; i<stocks.length;i++){


            while(!col.isEmpty() && stocks[i] > stocks[col.peek()]){
                col.pop();

            }
             if (col.isEmpty()){
                 span[i]=1;
                 col.push(i);

            }else  if(stocks[i]<=stocks[col.peek()]){//dis similar then found the grates element
                 int prev=col.peek();//it's just get the right index of the element greatest before the current
                span[i]=i-prev;// to calculate how many days before the price was high
                col.push(i);
            }

        }return span;

    }
    static void Duplicatebracket(String str){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch==')'){
                //directly closing the bracket
                if(st.peek() =='('){
                    System.out.print(true);//contain nothing
return;
                }else {
                    while(st.peek()!='('){
                        st.pop();//removing till find the duplicate one

                    }
                    st.pop();

                }

            }else{
                st.push(ch);//just adding if don't find any closing bracket
            }
        }System.out.print(false);
    }

    private static void reverse(Stack<Integer> rev) {

        if(rev.isEmpty()){
             return;
        }
        int top=rev.pop();

        reverse(rev);
        //while getting of the recursion
        pushatbottom(rev,top);

    }

    private static void pushatbottom(Stack<Integer> s, int data) {
        if (s.empty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushatbottom(s, data);
        s.push(top);//while returning

    }








static String Reverse(String str){
    Stack<Character> ch=new Stack<>();
    for (int i=0;i<str.length();i++){
        char k=str.charAt(i);
        ch.push(k);
    }
    StringBuilder sb=new StringBuilder("");
    while (!ch.isEmpty()){
        char top=ch.pop();
        sb.append(top);

    }return sb.toString();


}

public static boolean isBalanced(String bracket){
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < bracket.length(); i++) {
                char ch = bracket.charAt(i);
                if (ch == ')' || ch == '}' || ch == ']'){
                    if (!stack.isEmpty()){
                        if (stack.peek() == '(' && ch == ')'){
                            stack.pop();
                        }else if (stack.peek() == '{' && ch == '}'){
                            stack.pop();
                        }else if (stack.peek() == '[' && ch == ']'){
                            stack.pop();
                        }else {
                            return false;//only if just closing bracket and not open then return false
                        }
                    }else {
                        return false;//if stack is empty wile getting closing bracket then return false
                    }
                }else if  (ch == '(' || ch == '{' || ch == '['){
                    stack.push(ch);
                }
            }
            return stack.empty();
        }
    }}