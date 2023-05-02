import java.util.Arrays;
import java.util.Scanner;

public class Str{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String name="appna";
        String name1="Kamaal";

        System.out.println(Duplicate(name));
        System.out.println(Reverse(name)+"    yo");
       
       // Upper(name1);
        //String fruit[]={"mango","apple","banana"};
        Occurence(name1);
       // System.out.print(Largest(fruit));
       // System.out.print(Capital(name1.toString()));
        //WNEENESENNN
       // System.out.print(Palindrome(name));
      //System.out.print( shortestpath(name));
    //    int s=0;
    //    int e=3;
      // System.out.print(sub(name,s,e));
    }

     static String Reverse(String name2) {
        char []ch=name2.toCharArray();//function only in string to convert string to arr
        int s=0;
        int e=ch.length-1;
        while(s<=e ){
            if(ch[s]!=ch[e]) {
                char temp = ch[s];
                ch[s] = ch[e];
                ch[e] = temp;
            }
            s++;
            e--;
        }
        String str=new String(ch);

        return str;

    }

    static StringBuilder Reverse2(StringBuilder name) {
        StringBuilder str=new StringBuilder("");
        int j=0;
        for(int i=name.length()-1;i>=0;i--){

            str.append(name.charAt(i));
        }
        return str;
    }

    static StringBuilder Duplicate(String name) {//duplicates using loops
        StringBuilder sb= new StringBuilder("");
        Boolean[] map =new Boolean[26];

        Arrays.fill(map, false);// function use to fill arr with same element
        for(int i=0;i<name.length();i++){
            char ch=name.charAt(i);
            if(!map[ch - 'a']){
                sb.append(name.charAt(i));
                map[ch-'a']=true;
            }
        }
        return sb;
    }

           static void Occurence(String name1) {
            String str="";
            for(int i=0;i<name1.length();i++){
                Integer j=1;
                while( i<name1.length()-1 && name1.charAt(i)==name1.charAt(i+1)){//if j greater then 1 then j++ and add
                    i++;
                    j++;}
                    str+=name1.charAt(i);
                    if(j>1){
                        str+=j.toString();
                      
                    }
               
            }System.out.print(str);

    }

        static void Upper(String name) {
       char ch[]=new char[name.length()];

            for(int i=0;i<name.length();i++){
                if(name.charAt(i)>='a' && name.charAt(i)<='z'){
                   ch[i]=(char)((name.charAt(i)-32));

                }

            }System.out.print(Arrays.toString(ch));
    }

        static StringBuilder Capital(String name1) {
            StringBuilder sb = new StringBuilder();
            char ch=Character.toUpperCase(name1.charAt(0));
            sb.append(ch);
            for(int i=1;i<name1.length();i++){
                if(name1.charAt(i)==' ' && i<name1.length()-1){
                sb.append(name1.charAt(i));
                i++;
                sb.append(Character.toUpperCase(name1.charAt(i)));
                }else{
                    sb.append(name1.charAt(i));
                }
            }
        return sb;
    }

        static String Largest(String[] fruit) {
            String largest=fruit[0];
            for(int i=1;i<fruit.length;i++){
                if(largest.compareTo(fruit[i])<0){//compareto method by java
                    largest=fruit[i];

                }

            }
return largest;
    }

    static String sub(String name,int s,int e) {
        String S="";
        for(int i=s;i<=e;i++) {
S+=name.charAt(i);
        }

        return S;
    }

    static Float  shortestpath(String name) {
        int x=0;
        int y=0;
    
        for(int i=0;i<name.length();i++){
           char k= name.charAt(i);
        if(k=='N'){
            y++;
        } else if(k=='S'){
            y--;
        } else if(k=='W'){
            x--;
        }else{
            x++;
        }}
        Float sum=(float)(Math.sqrt(Math.pow(x, 2)+Math.pow(x, 2)));
        return sum;
    }

    static boolean Palindrome(String name) {//palindrome
for(int i=0;i<name.length()/2;i++){
    if(name.charAt(i)!=name.charAt(name.length()-i-1)){
        return false;
    }}

        return true;
    }
}