import java.util.Scanner;

public class practise {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        System.out.print(Vowels(str));
    }

     static int Vowels(String str) {
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)== 'o' || str.charAt(i)=='u' ){
                count++;
            }
        } str="ApnaCollege".replace("l", "");//replacement function 
        System.out.print(str);
        return count;
    }
}
