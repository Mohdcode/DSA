public class Matrix{
    public static void main(String[] args) {
        int arr[][]={{10,20,30,40},
        {15,25,35,45},
        {27,29,37,48},
        {32,33,39,50}
        };
        int k=32;
        
        
    //  System.out.print(linearSearch(arr,k));
     // BinarySearch(arr,k);
      staircasesearch(arr,k);
      //Diagnol(arr);
      //Zigzag(arr);
     // SpiralMatrix(arr);
     }
     
         static void staircasesearch(int[][] arr, int k) {
            int r=0;
int c=arr[0].length-1;
while(r<arr.length && c>=0){
    if(arr[r][c]==k){
        System.out.print(r+","+c);
        return;
    }else if(arr[r][c]>k){
        c--;
    }else if (arr[r][c]<k){
        r++;
    }
}
    }

        static void BinarySearch(int[][] arr, int k) {
            for(int i=0;i<arr.length;i++){
                int s=0;
                int e=arr[i].length-1;
                while(s<=e){
int mid=s+(e-s)/2;
if(arr[i][mid]==k){
    System.out.print(i+" "+mid);
    return;
}else if(arr[i][mid]>k){
    e=mid-1;
}else if(arr[i][mid]<k){
    s=mid+1;
}

                   
                }
            }

        
    }

    static int linearSearch(int[][] arr,int k) {
//linear search 
int sum=0;
for(int i=0;i<arr.length;i++){
    for(int j=0;j<arr[i].length;j++){
        if(arr[i][j]==k){
            System.out.println(i+" "+j);
            return 0;
        }
    }
}




        return -1 ;
    }

    static int Diagnol(int[][] arr) {
          int sum=0;
        
        for(int i=0;i<arr.length;i++){
         
          sum=sum+arr[i][i];
          
        } 
    for(int i=arr.length-1;i>=0;i--){

          if(i!=arr.length-i-1){

    sum=sum+arr[i][arr.length-i-1];
        
                  }     
        }return sum;
    }//end


    //start
    static void SpiralMatrix(int[][] arr) {
        int sc=0;
        int sr=0;
        int ce=arr[0].length-1;
        int re=arr.length-1;
while(sc<=ce && sr<=re){

    for(int j=sc;j<=ce;j++){
        System.out.print(arr[sr][j]+" ");//top
    }for(int i=sr+1;i<=re;i++){
        System.out.print(arr[i][ce]+" ");//rigt
    }for(int j=ce-1;j>=sc;j--){//bottom
        if(sc==ce){
            break;
        }
        System.out.print(arr[re][j]+" ");
    }for(int i=re-1;i>=sr+1;i--){//left
        System.out.print(arr[i][sc]+" ");
    }
sc++;
sr++;
re--;
ce--;
}

    }//end



     
     
     static void Zigzag(int [][]arr){//star
     for(int i=0;i<arr.length;i++){
           

        if(i%2==0){
            for(int j=0;j<arr[i].length;j++){
        System.out.println(arr[i][j]+" ");

       } }else{ for(int j=arr[i].length-1;j>=0;j--){
        System.out.println(arr[i][j]+" ");}}}}}
        
        //end