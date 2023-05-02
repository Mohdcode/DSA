import java.util.Scanner;

public class Javabasics{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
       
       
       //variable should be in scope it could be a big problem 
       // always care about of integer and loops
        // while(i<n){ int j=0;
        //     while(j<n){
        //         System.out.print("*");
        //         j++;
        //        }System.out.println("");
        //        i++;  }

        // program for sum of n numbers

//         int sum=0;
// while(n>=i){
//     sum+=i;
//     i++;
// }System.out.println(sum);




//reverse the numbers



// while(n>0){
// int last =n%10;
// //System.out.print(last);
// i=i*10+last;
// n/=10;

// }System.out.print(i);


//take input until user give multiple of 10

// do{ int n=in.nextInt();
//     if(n%10==0){
//         break;
//     }
// System.out.print(n);
// }while(true);


//comtinue example

// int n=in.nextInt();

// for(;i<n;i++){
// if(i==3){
    
//     continue;
    
// }System.out.println(i);
// }




//  fibonacci series
//int n=in.nextInt();
// int j=0;
// int k=2;

// while(n>=k){
//     int temp=i;
//     i+=j;
//     j=temp;
//    k++;

// }System.out.print(i);

//
//factorial of no.


// int j=1;
// while(n>=i){
// j*=i;
// i++;
// }
// System.out.print(j);

//  multiple of no.

// int n=12;
// int i=0;
// while(i<=10){
//     int j=n*i;
   
//     System.out.println(j);
//     i++;
   
// }
//this is also a good example of variable i scope 

    // for(int i = 0; i <= 5; i++ ) {
    // System.out.println("i = " + i );
    // }System.out.println("i after the loop = " + i );
  //factorial of no.
//   int n=in.nextInt();
//   int i=1;
//   int j=1;
//   while(n>=i){
//     j*=i;
//     i++;
    
//   }
//   System.out.print(j);


//fibbonaci sequence
int n=in.nextInt();
int i=1;
int p=0;
int count=1;
while(count<=n){
    int temp=i;
    i+=p;
    p=temp;
count++;
}
System.out.print(i);

}
}