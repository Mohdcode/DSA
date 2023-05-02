import java.util.Arrays;

public class Recursion{
    public static void main(String[] args) {
        //base case or final case
        //iterative
        //arguements
        //call function
        //return type


//        int n=4;
//        int a=1342;
//        int b=1020;
//String name="kamaal";
//Boolean map[]=new Boolean[26];
//        Arrays.fill(map, false);//function use to fill arr with same thing
//System.out.println(Duplicate(name,map,0,new StringBuilder("")));
Towerofhanoi(3,'S','H','D');

//
//        System.out.println(Count(b));
//        Numbers(n);
    //    System.out.println(Fibonacci(n));
//        System.out.println(Sum(n)+"   is sum");
//        System.out.println(Digits(a)+" digit");
//        System.out.println(Rev(a)+" Reverse");
//
//
////n--
//        //--n use this in recursion
//
//        int p1=0;
//        int p2=1;
//        for(int i=0;i<n;i++){
//        int temp=p1;
//        p1=p1+p2;//adding 1 and 2 no. then adding again and again so we can use recursive function
//        p2=temp;}
////        System.out.println(p1);
//        System.out.println(Factorial(n));
//        int arr[]=new int[]{1,2,3,4,5,6,8,9};
//        int arr1[]={8,3,6,9,5,10,2,5,3};
//        System.out.println(BinarySearch(arr,8,0,arr.length-1));
//        Print(arr,arr.length-1);
//        System.out.println(Sorted2(arr,0));
//        System.out.println(Firstindex(arr1,0,5));
//        System.out.println(Lastindex(arr1,arr1.length-1,5));
//        a=5;
//        int x=2;
//        System.out.println(Power(x,a)+" Power");
//        System.out.println(Optimizedpower(x,a)+" Optimized way Power");

    }

     static void Towerofhanoi(int i, char s, char h, char d) {
        if(i==0){
            return;
        }Towerofhanoi(i-1,s,d,h);//first we have made helper the destination till all come in
        System.out.println(i+" "+s+"  -> "+d);
         Towerofhanoi(i-1,h,s,d);//and then from helper as a source we are sending it to the destination
    }

    static StringBuilder Duplicate(String name,Boolean []map,int i,StringBuilder str) {//in this recursion we are adding before going in to recursive
        if(i==name.length()){
            return str;
        }char ch=name.charAt(i);
        if(!map[ch-'a']){

            str.append(name.charAt(i));
            map[ch-'a']=true;
            return Duplicate(name,map,i+1,str);


        }else{
            return Duplicate(name,map,i+1,str);
        }

    }


    static int Optimizedpower(int x, int a) {//logn

        if(a==0){
            return 1;
        }
        int half=Optimizedpower(x,a/2); //same function so optimized it
        int halfsq=half*half;
        if(a%2!=0){
            halfsq=x*halfsq;
        }return halfsq;
    }

    static int Power(int x, int a) {//O(n)
        if(a<0){
            System.out.print("not for negative");
            return -1;
        }
        if(a==1){//base case
            return a;
        }return x*Power(x,a-1);
    }

    static int Lastindex(int[] arr, int i, int k) {
        if(i<0){//first recursive program by my on brainstroming
            System.out.print("not found");
            return -1;
        }if(k==arr[i]){
            return i;
        }return Lastindex(arr,i-1,k);}
    static int Firstindex(int[] arr, int i,int k) {
        if(i>arr.length-1){//first recursive program by my on brainstroming
            System.out.print("not found");
            return -1;
        }if(k==arr[i]){
            return i;
        }return Firstindex(arr,i+1,k);}


        static int Linearsearch(int[] arr, int i,int k) {
        if(i>arr.length-1){//first recursive program by my on brainstroming
            System.out.print("not found");
        return -1;
    }if(k==arr[i]){
            return i;
        }return Linearsearch(arr,i+1,k);


    }

    private static boolean Sorted(int[] arr, int i) {
        if(i==arr.length-1){//sorted arr using recursion
            return true;
        }
        return arr[i]<=arr[i+1] && Sorted(arr,i+1);//think which one loops and put recursion on it
    }
     static boolean Sorted2(int[] arr, int i) {

        if(i==arr.length-1){//sorted arr using recursion
            return true;
        }if (arr[i]>arr[i+1]){
            return false;
         }

         return Sorted(arr,i+1);//think which one loops and put recursion on it
    }

    static int Count(int b) {

        return helper(b,0);
    }

     static int helper(int b, int c) {
        if(b==0){
            return c;
        }
        int rem=b%10;
        if(rem==0){
          return   helper(b/10,c+1);
        }return helper(b/10,c);
    }

    static int sum=0;
     static int  Rev(int a) {
        if(a==0){
            return sum;
        }
        int last=a%10;
        sum=sum*10+last;
                return Rev(a/10);
    }

    static int Digits(int a) {

        if(a==0) {
            return 0;
        }
      //  int rem=rem*10+last;
        return (a%10)+Digits(a/10);
    }

    static void Print(int[] arr,int i) {

        if(i<0){

        return;}
         System.out.print(arr[i]+" ");//before calling function
        Print(arr,i-1);
         System.out.print(arr[i]+" ");//after calling function out then do this job that's why it is reverse
    }

    static int Sum(int n) {
        if(n<1){
            return n;
        }return n+Sum(n-1);
    }

    static int BinarySearch(int arr[],int k,int s,int e) {
        if(s>e){
            return -1;
        }
        int mid=s+(e-s)/2;
        if(arr[mid]==k){
            return mid;
        } if(arr[mid]>s){
            return BinarySearch(arr,k,mid+1,e);//should know what to return in function paramters
        }
            return BinarySearch(arr,k,s,mid-1);


     }

    static void Numbers(int n) {
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        Numbers(n-1);//this is tailed recursion
    }

    static int Factorial(int n) {
        if(n<2){//but here it is only calling one function tree that's why 2-1=0
            return n;
        }return n*Factorial(n-1);
    }

    static int Fibonacci(int n) {
        if(n<=1){//this condition
            return n;
        }int n1=Fibonacci(n-1);
        int n2=Fibonacci(n-2);

return n1+n2;//formula derived for recursion is called (recurrence relation )
}}