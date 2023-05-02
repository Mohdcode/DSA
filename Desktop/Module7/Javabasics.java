import java.util.Scanner;

public class Javabasics{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // int n=sc.nextInt();
        // if(n%2==0 && n>0){
        //     System.out.print("even");

        // }else{
        //     System.out.print("odd");
        // }






        // if (condition 1){

        // }else if(conditon 2){

        // }else{

        // }



//else if is used to save time and check multiple statement and if first conditon is true then second condition denoted by else if wouldn't be checked




// if(condition 1){
    
// }if (condition 2){

// }else{

// }


// if and if would check both condition no matter if it's true or not

//ternary operator
//variable = condition?statement1:statement2;



//switch statement


// int number=sc.nextInt();
// switch(number){
//     case 1: System.out.print("abba");
//     break;

// case 2: System.out.print("chacha");
// break;
// case 3:System.out.print("nana");
// break;
// default: System.out.print("we wake up");
//     }

//continue
// is used to skip the rest of the code and again run in the loop


int n=sc.nextInt();
if(n%4==0){
    if(n%100==0){
       if(n%400==0){
                System.out.print("a leap year");
         }
    }
    
    
    else {
    System.out.print(" a leap year");
}}

    else{
    System.out.print("not a leap year");}
}}



