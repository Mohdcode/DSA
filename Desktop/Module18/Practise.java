public class Practise {
    public static void main(String[] args) {
        int []arr={3,2,4,5,6,2,7,2,2};
        int k=2;
       Occur(arr,k,0);
       String str="abc";
      System.out.println( Length(str)+" this is length");
      int r=4;
      int c=4;
     // System.out.println(Skip(str,0,'a',new StringBuilder("")));
      Subseq(str,new String(""));
     System.out.print(Palindrome(str,0,str.length()-1));

    }

     static boolean Palindrome(String str,int s,int e) {//pass in arguement

        if(s>=e){
            return str.charAt(s)==str.charAt(e) ;//return statement is very importnt this the statement it will take with itself when it will be removed the stack
        }

        return str.charAt(s)==str.charAt(e) && Palindrome(str,s+1,e-1);
    }
    static boolean Palindrome(String str) {
        int s=0;
        int e=str.length()-1;//pass in body
        if(s<=e){
            return str.charAt(s)==str.charAt(e) ;//return statement is very importnt this the statement it will take with itself when it will be removed the stack
        }
        ++s;//either iterate in body or pass in arguement
        --e;
        return str.charAt(s)==str.charAt(e) && Palindrome(str);
    }
    static void Subseq(String str, String s) {
        if(str.isEmpty()){

            System.out.println(s);
            return;
        }char ch=str.charAt(0);

        Subseq(str.substring(1),s);
        Subseq(str.substring(1),s+ch);
    }

    static StringBuilder Skip(String name,int i,char k, StringBuilder sb) {//skip program
 if(i>name.length()-1){
     return sb;
 }//remember for only one function
 if(name.charAt(i)==k){
   return   Skip(name,i+1,k,sb);
 }else{
     sb.append(name.charAt(i));
   return   Skip(name,i+1,k,sb);
 }
    }

    static int Length(String str) {

        if(1>str.length()-1){
            return 1;

        }
        //or just ++i here instead of function
        return Length(str.substring(1))+1;

    }

    static void Occur(int[] arr, int k, int i) {
        if(i>arr.length-1){

            return;
        }

         if(arr[i]==k){
             System.out.println(i);
         }
         Occur(arr,k,i+1);

    }
}
