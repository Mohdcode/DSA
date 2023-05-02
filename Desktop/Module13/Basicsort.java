import java.util.Arrays;

public class Basicsort{
    public static void main(String[] args) {
        int num[]={5,1,4,2,3};
        //5,4,1,2,3
        //5
    //     Bubble(num);
    //    Selection(num);
    //   Insertion1(num);
     // counting(num);
      cyclic(num);
    }
     static void cyclic(int[] num) {//use only when in number are in 1 to n;
        for(int i=0;i<num.length-1;){
            int k=num[i]-1;
          if(num[i]!=num[k]){
                int temp=num[i];
                num[i]=num[k];
                num[k]=temp;

        }else{
            i++;
        }
        
    }
pr(num);


    }
//implement this on positive no. only
static void counting(int[] num) {//number of frequency array 

    int largest=Integer.MIN_VALUE;//to  find frequency arr size
    for(int i=0;i<num.length;i++){
        largest=Math.max(largest,num[i]);
    }
    //frequency part
    int count[]=new int[largest+1];
    for(int i=0;i<num.length;i++){
count[num[i]]++;

    }
    //sorting part
    int j=0;
    for(int i=0;i<count.length;i++){
        while(count[i]>0){
num[j]=i;
j++;
count[i]--;
        }
    }pr(num);
    }












static void Insertion1(int[] num) {//insertion sort 
    
    for(int i=0;i<num.length-1;i++){
        for(int j=i+1;j>0;j--){
            if(num[j]<num[j-1]){
                int temp=num[j-1];
                
                    num[j-1]=num[j];
                    num[j]=temp;

            }else{
                break;
                
            }
        }
    }
    pr(num);}
 
    static void Selection(int[] arr) {//selection
       // int swap=0;
                for(int i=0;i< arr.length-1;i++ ){//outer loop to swap the min
            int min=i;
            for(int j=i+1; j< arr.length;j++){//outer loop is to find the min elemt in array
                if(arr[j]<arr[min]){
                    min=j;}}//finding the minimum number index
                    int temp=arr[i];//   swap++;
                    arr[i]=arr[min];
                    arr[min]=temp;
                }



        System.out.println(Arrays.toString(arr));
            }

    static void Bubble(int[] num) {//bubble sort algo
        int n=num.length-1;
      int swap=0;
        for(int i=0;i<n;i++){
          
            for(int j=0;j<n-i;j++){
                if(num[j+1]<num[j]){//swaping every time
                   
                    int temp=num[j];
                    swap++;
                    num[j]=num[j+1];
                    num[j+1]=temp;

                }
            } 
        }System.out.println(swap);
      
        pr(num);//print function to print arr

    }
    static void pr(int arr[]){
        
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
    }
     
    }
}