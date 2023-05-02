public class practise {
    public static void main(String[] args) {


       System.out.println( sum(121));
        //average of three no.
int a =9;
int b=0;
int c=2;
    //     System .out.println(aver(a,b,c));

    //     int n=487;
    //    System.out.print( isEven(n));
    }

public static boolean isEven(int n) {
    if(n%2==0){
return true;
    }else {
        return false;
    }
    }

    //function for average
    public static int  aver(int a, int b, int c) {

        int average=(a+b+c)/3;

        return average;
    }
    public static boolean palindrome(int n){//palindrome or not function
        int k=n;
int rem=0;
while(n>0){
int last =n%10;
rem=rem*10+last;
n/=10;
System.out.println(rem);
}
   return k==rem;
   

}public static int sum(int n){//function to add integers digits 
    int rem=0;
    while(n>0){
    int last=n%10;
    rem=rem+last;
n/=10;
    }
    return rem;
}

}