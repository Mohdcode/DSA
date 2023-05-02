public class practise {
    public static void main(String[] args) {
        int n=2;
        int a;
        int b;
        char c='A';
        a=20;
        b=20;
      // System.out.println( Same(n));
       //Swap(a,b);
       System.out.println(Add(c,2));
       System.out.println(Lower(c));
       seiveprime(20);
       
    }
public static void isprime(int n){
        boolean []arr=new boolean[n+1];//cuz we have to have till n
    Arrays.fill(arr,true);
    arr[0]=false;
    arr[1]=false;

    for(int i=2;i<=Math.sqrt(n);i++){
        for(int j=2*i;j<=n;j=j+i){//jumping according to number n and making them false
            arr[j]=false;
        }
    }
    System.out.print(Arrays.toString(arr));


}




      static char Lower(char a) {
        a=(char)(a|32);//add 32 to get lower and subtract to get upper case

        return a ;
    }





    static int Add(int a, int i) {
        return a | i;//or can use as addition operator in bit manipulation
    }





    static void Swap(int a,int b){
        a=a^b;//swap using xor operator
        b=a^b;
        a=a^b;
        System.out.print(a+" "+b);
    }

     static int Same(int n) {
        return n^n;//xor of same no. give 0
    }
}
