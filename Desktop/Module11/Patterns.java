public class Patterns{
    //check out kunal videos for more methods
    public static void main(String[] args) {
int n=5;//pattern for boundary
for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
        if(i==1 || i==n || j==1 || j==n){
            System.out.print("*");
        }else{
            System.out.print(" ");
        }
    }System.out.println("");
}//end

//pattern inverted and rotated half pyramid
for(int i=1;i<=n;i++){
    for(int j=1;j<=n-i;j++){
        System.out.print(" ");
        
    }
    for(int j=1;j<=i;j++){
        System.out.print("*");
        
    }System.out.println("");
}
// inverted half pyarmid with no.

for(int i=0;i<=n;i++){
    for(int j=1;j<=n-i;j++){
        System.out.print(j);
    }System.out.println("");
}

//floyd's triangle
int l=0;
for(int i=0;i<n;i++ ){
    for(int j=0;j<=i;j++){
        ++l;
        System.out.print(l+" ");
        ;
    }System.out.println("");
}
//0-1 triangle
for(int i=1;i<=n;i++){
    for(int j=1;j<=i;j++){
        int sum=i+j;
        if(sum%2!=0){
            System.out.print("1");
        }else{
            System.out.print("0");
        }
    }System.out.println("");
}
//butterfly pattern
//1st half
for(int i=0;i<=n;i++){
    //star
    for(int j=0;j<=i;j++){
        System.out.print("*");
    }//spaces
    for(int j=0;j<2*(n-i);j++){
        System.out.print(" ");
    }//star
    for(int j=0;j<=i;j++){
        System.out.print("*");
    }
    System.out.println("");
}
//2nd half
for(int i=n;i>=0;i--){
    for(int j=0;j<=i;j++){
        System.out.print("*");
    }//spaces
    for(int j=0;j<2*(n-i);j++){
        System.out.print(" ");
    }//star
    for(int j=0;j<=i;j++){
        System.out.print("*");
   
}System.out.println("");

}
//rhombus
for(int i=0;i<=n;i++){
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=0;j<=n;j++){
        System.out.print("*");
    }System.out.println("");
}
//hollow rhombus
for(int i=0;i<=n;i++){
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=0;j<=n;j++){
        if(j==0 || j==n || i==0 || i==n){
        System.out.print("*");}
        else {
            System.out.print(" ");
        }
    }System.out.println("");
}

//diamond pattern
//ist half
for(int i=0;i<=n;i++){
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=0;j<(2*i)-1;j++){
        System.out.print("*");
    }System.out.println("");
}//2nd half
for(int i=n;i>=0;i--){
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=0;j<(2*i)-1;j++){
        System.out.print("*");
    }System.out.println("");}
//Number pyramid
for(int i=0;i<=n;i++){
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=0;j<(2*i)-1;j++){
        System.out.print(i);
    }System.out.println("");

//palindrome no.pyramid
}for(int i=0;i<=n;i++){
    for(int j=0;j<n-i;j++){
        System.out.print(" ");
    }for(int j=1;j<i-1;j++){
        System.out.print(j);
    }for(int j=i-1;j>0;j--){
        System.out.print(j);
    }
    System.out.println("");


}


}}