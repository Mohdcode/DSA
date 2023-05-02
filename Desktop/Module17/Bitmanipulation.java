import java.util.Set;

public class Bitmanipulation{
    public static void main(String[] args) {
        // int n=10;
//         int power=2;
//         int k=2;
//         int bit=1;
//         int arr[]={2,4,2,5,4,6,5};
// Oddoreven(n);
// System.out.print(Getbit(n,k));//use it to get n ith bit of no. k 
// System.out.println(Getbit(n));//use this to get n ith bit of no.n.
// System.out.println(Setbit(n,k));//use it to set n ith bit of no. k 
// System.out.println(Setbit(n));//use this to set n ith bit of no.n.
// System.out.println(clearbit(n,k));
// System.out.println(clearbit(n));
// System.out.println(updatebit(n,k,bit));
// System.out.println(ans(arr));
System.out.print(power(n,power));
int n=15;
int i=2;

int bitmask=-1<<i;
int bit=n & bitmask;
System.out.print(bit);
//2s compliment
                        //1st comliment then 2nd add 1 bit in no.
        // it will give negative of a no.




    }static int power(int base,int power){//calculate power
        int ans=1;
        while(0<power){//after shifting bits the only bit will remain would be 0 so thats why we comparate it with 0
        if((power&1)==1){
           ans*=base;//multiplying with next power bit
        }

        base*=base;//sqaring the no. here
    power=power>>1;//shifting the power
            //dividing the power by 2
}
        return ans;
    }

       
      static int ans(int[] arr) {
        int unique=0;
        for(int i:arr){
            unique^=i;//xor  n^n ==0
        }//below it is the same way initializing loops in arrays
        // }for(int i=0;i<arr.length;i++){
        //     unique^=arr[i];

        // }

        return unique;
    }


    static int updatebit(int n, int k, int bit) {
         if(bit==0){
           return clearbit(n,k);
         }else{
           return Setbit(n,k);
         }
        
    }


    static int  clearbit(int n, int k) {
        int bitmask=~(1<<n);//compliment
    return k & bitmask;
    }
    static int  clearbit(int n) {
        int bitmask=~(1<<n);//compliment
    return n & bitmask;
    }


    static int  Setbit(int n, int k) {
        int bitmask=1<<n;
        if((k | bitmask)==1){
            return 1;
        }else{
           return 0;
        }
      
    }
    static int  Setbit(int n) {
        int bitmask=1<<n-1;
        if((n | bitmask)==1){
            return 1;
        }else{
           return 0;
        }
      
    }

    static int Getbit(int n,int k) {
        int bitmask=1<<n;
        if((k & bitmask)==1){
            return 1;
        }else{
           return 0;
    }}  static int Getbit(int n) {
        int bitmask=1<<n-1;
        if((n & bitmask)==1){
            return 1;
        }else{
           return 0;
    }}

    static void Oddoreven(int n) {
        if((n & 1)==1){
            System.out.println("odd");

        }else{
            System.out.println("even");
        }
    }
}