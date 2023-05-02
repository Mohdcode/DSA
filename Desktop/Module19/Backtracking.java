import java.util.Arrays;

public class Backtracking {
    static String [] key= new String[]{",!", "abc", "def", "ghi", "ijk", "lmn", "opqr", "stuv", "wxyz"};
    public static void main(String[] args) {
        String arg="abc";

Permutations(arg,"");



//System.out.println(grid(0,0,3,3));
keypad("345","");
gridprint(3,3,"");
int n=4;
char [][] chess=new char[n][n];
        for (char[] chars : chess) {
            Arrays.fill(chars, 'X');
        }
Nqueens(chess,0);
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 } };



        Sol(maze,3,3 ,"");
    }

    static void Sol(int[][] maze,int r,int c,String s) {


        if(r==1 && c==1){
            System.out.print(s);
            return ;
        }
        if(issafe(maze[r][c],r ,c)){
            Sol(maze,r-1,c,s+'U');
            Sol(maze,r,c-1,s+'L');

        }
    }

    static boolean  issafe(int i,int r,int c) {//checking if going out the boundary
        return i != 0 && r >= 1 && c >= 1;
    }



     static void Nqueens(char[][] chess, int r) {
        System.out.println();
        if(r== chess.length){
print(chess);
            return;
        }
        for(int i=0;i<chess.length;i++){//row and column

            if(isSafe(chess,r,i)){
            chess[r][i]='Q';
            Nqueens(chess,r+1);
            chess[r][i]='X';
        }}

    }

     static boolean isSafe(char[][] chess, int r, int c) {
        //lower
         for (int i = r - 1; i >= 0; i--) {//looking backward to check if the already placed queen is there
             if (chess[i][c] == 'Q') {
                 return false;
             }
         }
             for (int i=r-1, j=c-1; i>=0 && j>=0;i--,j--){
                 if (chess[i][j] == 'Q') {
                     return false;
                 }
             }  for (int i=r-1, j=c+1; i>=0 && j<chess.length;i--,j++){
             if (chess[i][j] == 'Q') {
                 return false;
             }
         }return true;


         }

    static void print(char[][] chess){
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess.length;j++){
                     System.out.print(chess[i][j]);
                 }
                 System.out.println();
             }}


    static void gridprint(int i, int j, String s) {
        if(i==1 && j==1 ){//it's about printing
            System.out.println(s);
            return;
        }

        if(i>1){//to not let go out of the grid
            gridprint(i-1,j,s+'D');
         }if(j>1){
            gridprint(i,j-1,s+'R');
         }
    }


    static int grid(int i,int j) {// simple reverse grid
        if(i==1 || j==1){// when one of the column or row is 1 then there is only one way to do it that's why return 1;
            //indexing difference nothing else
            return 1;
        }
        return grid(i-1,j)+grid(i,j-1);


    }
    static int grid(int i,int j,int m,int n) {//grid simple
        if(i==m-1 || j==n-1){
            return 1;
        }else if(i==m || j==n){//edge case
            return 0;

        }
        return grid(i+1,j,m,n)+grid(i,j+1,m,n);


    }

    static void keypad(String n, String s) {//combination of number
        if(n.isEmpty()){
           System.out.println(s);
            return;}
        char ch=n.charAt(0);//selecting the number
         String rem=n.substring(1);//substring if the remaining number
        String keynum=key[ch-'0'];//index of the chosen number
        for(int i=0;i<keynum.length();i++){
            char cur=keynum.charAt(i);//String arr character

            keypad(rem,s+cur);//addition to the last new string and passing substring of original
        }
    }

    static void Permutations(String arg,String par) {
        if(arg.isEmpty()){
            System.out.println(par);
            return ;
        }// n! ways
        for(int i=0;i<arg.length();i++){//loop for string to select diffrent element
            char cur=arg.charAt(i);//selecting diffrent indexes
            String newstr=arg.substring(0,i)+arg.substring(i+1);//already selected ith element so can't select that why
            Permutations(newstr,par+cur);//adding and calling another remaing string without that selected element

        }
    }
}
