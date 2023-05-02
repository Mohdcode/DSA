import java.io.*;

public class DP {
    public static int Fib(int n,int []f){//memoization in DP
        if(n==0 || n==1){
            return n;
        }
        if(f[n]!=0){//if array index for call n is not empty then it has already been calculated so no need to go further just take it from here
            return f[n];
        }

        f[n]= Fib(n-1,f)+Fib(n-2,f);

        return f[n];
    }

    public static int FibTabulation(int n){//tabulation form
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+dp[i-2];

        }return dp[n];
    }
    public static void main(String[] args) {
int n=5;
int []f=new int [n+1];
System.out.println(Fib(n,f));
        System.out.println(FibTabulation(n));
    }
}
