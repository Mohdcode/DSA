import java.util.Arrays;

public class practise {
    public static void main(String[] args) {
        int k=2;
        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};

     //  System.out.print( linearseach(arr,k));
     //  System.out.print( Sum(arr,k));
Transpose(arr);
     for(int i=0;i<arr.length;i++){
        
            System.out.print(Arrays.toString(arr[i]));
    }}

       static int[][] Transpose(int[][] arr) {

        for(int i=0;i<arr.length;i++){
            for(int j=1+i;j<arr.length;j++){//pattern
                int temp=arr[j][i];
                arr[j][i]=arr[i][j];
                arr[i][j]=temp;
              //  System.out.print(arr[i][j]);}
              
            }}
        return arr;
        }
    

    static int Sum(int[][] arr, int k) {
        if(k>arr.length-1){
            return 0;
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(i==k){
                    sum+=arr[i][j];
                }
            }
        }
        return sum;
    }

    static int linearseach(int[][] arr,int k) {
        
   
        //linear search 
        int sum=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==k){
                   sum++;
                }
            }
        }
        
        
        
        
                
        
        return sum;
    }   
}
