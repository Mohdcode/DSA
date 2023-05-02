//import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class Arrays{
    public static void main(String[] args) {
        //find the largest in Arrays using linear search
        Scanner in=new Scanner(System.in);
     
      int num1[]={2,4,6,8,10};//second syntax
     int num2[]={0,2,1,5,3,4};
     int k=in.nextInt();
     Rotate(num1,k);
        
      
    
      //  Pairs(num1);
//subarrays(num1);
      // prefixmax(num1);
     // Kadanes(num1);
     // Permutation(num2);
    
    }


    

  
 static void Rotate(int[] num1, int k) {
     //1st approach
int n=num1.length-1;//but ithas edge case 
// int temp[]=new int[num1.length];
// int j=0;
// for(int i=k;i<num1.length;i++){

//     temp[j]=num1[i];
//     j++;
// }for(int i =0;i<k;i++){
//     temp[n-i]=num1[i];
// }
//2nd approach


for(int i=0;i<k ;i++){

    int temp1=num1[0];
    for(int j=1;j<=n;j++){
        //cyclic order
    num1[j-1]=num1[j];}
   num1[n]=temp1;


}




//print the array
for(int i=0;i<num1.length;i++){
    System.out.print(num1[i]+" ");}
}
    





static void Permutation(int[] num2) {//permutation of array concept on how array can internally change ints index
int num3[]=new int[num2.length];
for(int i=0;i<num2.length;i++){
    num3[i]=num2[num2[i]];

}
for(int i=0;i<num2.length;i++){
    System.out.print(num3[i]+" ");}
}
   // return num3;}
    




static void Kadanes(int[] num1) {//max subarrays in O(n);but not for all negative elements in arrays

    int cs=0;
    int ms=Integer.MIN_VALUE;
    for(int i=0;i<num1.length;i++){
        cs=cs+num1[i];
        if(cs<0){
            cs=0;
        }ms=Math.max(ms, cs);
    }System.out.print(ms);
    }






static void prefixmax(int[] num1) {//prefix sub array sum max
    int sum=0;
    int max=Integer.MIN_VALUE;

    int prefix[]=new int[num1.length];//prefix array
  //  prefix[0]=num1[0];
    for(int i=0;i<prefix.length;i++){
//used ternary operator so it doesn't go out of bound
        prefix[i]=i==0?num1[0]:prefix[i-1]+num1[i];//sum of array in prefix
    }
    
    for(int i=0;i<num1.length;i++){//sum of prefix
        for(int j=0;j<num1.length;j++){
           
 sum=i==0?prefix[j] : prefix[j]-prefix[i-1];//index out of bound

       if(max<sum){//max
        max=sum;
       } 
    }
    }System.out.println(max+" "+sum);
    }






static void subarrays(int[] num1) {//subarrays and with sum of largest subarrays
   int max=Integer.MIN_VALUE;
    for(int i=0;i<num1.length;i++){
        for(int j=i;j<num1.length;j++){
            int sum=0;
            for(int k=i;k<=j;k++){
            System.out.print(num1[k]+" ");
            sum+=num1[k];
if(sum>max){
    max=sum;
}
            }
            System.out.print("= "+sum);
            System.out.println(" ");
          
           
        }System.out.println("");
      }  System.out.print(max);
    }






    static void Pairs(int[] num1) {//pairs in no. arrays
        int k=0;
        for(int i=0;i<num1.length;i++){
            for(int j=i+1;j<num1.length;j++){
                k++;
                System.out.print("("+num1[i]+","+num1[j]+")");
                
               
            }
            System.out.println("");
        }System.out.print( k);
    }






    static int [] Swap(int[] num1) {//reverse array
        int start=0;
        int end=num1.length-1;
        while(start<=end){
            int temp=num1[start];
            num1[start]=num1[end];
            num1[end]=temp;
            start++;
            end--;
        }
        return num1;
    }

    static int Binarysearch(int[] num,int n) {//binary search

          int start=0;
           int end=num.length-1;
                       //int max=Integer.MIN_VALUE;
            while(start<=end){
   // int mid = (start + end) / 2;  might be possible that (start + end) exceeds the range of int in java
    int mid = start + (end - start) / 2;
    if(num[mid]==n){
        return num[mid];
    }else if(num[mid]>n){
        end=mid-1;
    }else if(num[mid]<n){
        start=mid+1;
    }
}

        return -1;
    }

    static int Largest(int[] num) {//function to get largest of all and linear search
        
        int max= Integer.MIN_VALUE;//this predefined min value in integer
        for(int i=0;i<num.length;i++){
         
          if(num[i]>max){
            max=num[i];
          
          }
        }return max;
        
    }

}