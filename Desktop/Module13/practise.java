import java.util.Arrays;

public class practise {
    public static void main(String[] args) {
        int arr[]={3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        int arr1[]={1,2,3,4,5};
       System.out.print(Arrays.toString(Bubble(arr))) ;
       System.out.print(Arrays.toString(Selection(arr))) ;
       System.out.print(Arrays.toString(Insertion(arr))) ;
       System.out.print(Arrays.toString(Cyclic(arr1))) ;
       System.out.print(Arrays.toString(Counting(arr))) ;
     //  System.out.print(Arrays.toString(Counting1(arr))) ;
    }

   

static int[] Counting(int[] arr) {
int largest=Integer.MIN_VALUE;
for(int i=0;i<arr.length;i++){
   
        largest=Math.max(arr[i], largest);//find the largest element in arr
    
}int count[]=new int[largest+1];//then make arr of that size
for(int i=0;i<arr.length;i++){
    count[arr[i]]++;//take the frequency 

}int j=0;
for(int i=0;i<count.length;i++){//now sort it out
    while(count[i]>0){      //only when in count arr the index element is greater then zero
        //int arr[]={3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        arr[j]=i;
        j++;
        count[i]--;
    }
}
        return arr;
    }

static int[] Cyclic(int[] arr) {//linear sorting algo but no frequency of element and no negative
    for(int i=0;i<arr.length-1;i++){
        int k=arr[i]-1;
        if(arr[k]!=arr[i]){
            int temp=arr[k];
            arr[k]=arr[i];
            arr[i]=temp;
        }
    }


        return arr;
    }

static int [] Insertion(int[] arr) {
for(int i =0;i<arr.length-1;i++){
    for(int j=i+1;j>0;j--){
        if(arr[j]>arr[j-1]){//throwing element on sorted side one by one
            int temp=arr[j-1];
            arr[j-1]=arr[j];
            arr[j]=temp;
        }

    }

}

        return arr;
    }

static int[] Selection(int[] arr) {
    for(int i=0;i<arr.length-1;i++){
        int k=i;//last element pointer 
        for(int j=1+i;j<arr.length-1;j++){
            if(arr[j]>arr[k]){//change pointer if index element is greater 
                k=j;

            }

        }int temp=arr[i];
        arr[i]=arr[k];
        arr[k]=temp;
    }





        return arr ;
    }

static int [] Bubble(int[] arr) {
    for(int i=0;i<arr.length-1;i++){
        for(int j=0;j<arr.length-1-i;j++){
            if(arr[j]<arr[j+1]){//internal swapping is too much
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }return arr;
    }
    
}
