import java.util.Scanner;

public class Javabasics{
    //classes first letter should be capital its a good practise a cuz all pre define classes are same as convention
    public static void main(String[] args) {//this is the function compiler look before running a program
       
      //print Styles
                System.out.print("*");
                System.out.println("print in next line");   /*use to print next line */
            //there are two type of synatx use while commenting above syntax is use to comment multiple line at a same time
         
            System.out.print(" \n");//use to print in next line  ("kamaal\n")
        //variable can be changed
        //identifier can be any character
        //identifier are name of integer, class or more
        //literals are value that can't be changed like '1','2',0 and more
        //value are stored in heap memory and identifiers are stored in stack memory
        char ch='a';//only character
        System.out.print(ch);
        boolean var=true;//true or false 
        float price= 1.33f;//use 'f' in float and cuz its default in others primitve data types
        float pric= (float) 1.33;//decimal use and type casting at same time
        System.out.print(price);
        System.out.print("12_324_234");//this is use to type like money
        //integers are of wrapper class
        // type promtion is use by program itself like converting data type to bigger in output but can't be demotion it depends on size
//type should be compatible to conversion
//bigger to smaller conversion is called lossy conversion it has to be explicit

        Scanner sc=new Scanner(System.in);//use to input from keyboard and this is a class and "sc" can be changed in other char
        int a=sc.nextInt();//this how we have to define while taking input
String nam=sc.next();//for single string
String surname=sc.nextLine();//use to input with paragraph


    }}