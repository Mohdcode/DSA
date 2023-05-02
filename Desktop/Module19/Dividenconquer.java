import java.util.Arrays;

public class Dividenconquer {
    public static void main(String[] args) {
        int []arr={4,5,6,7,8,0,1,2,3,3,3};
//        Mergesort2(arr,0,arr.length);
//        System.out.print(Arrays.toString(arr));
//     System.out.print(Arrays.toString(Mergesort(arr,0,arr.length-1)));
//        quickSort(arr,0,arr.length-1);
//        System.out.print(Arrays.toString(arr));
        System.out.println(Rotated(arr,0,arr.length-1,5));
System.out.print(countOccurrences(arr,3));

    }public static int countOccurrences(int[] arr, int target) {
        return countOccurrencesHelper(arr, target, 0, arr.length - 1);
    }

    private static int countOccurrencesHelper(int[] arr, int target, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return 0;
        }
        if (leftIndex == rightIndex) {
            if (arr[leftIndex] == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int midIndex = (leftIndex + rightIndex) / 2;
        int leftCount = countOccurrencesHelper(arr, target, leftIndex, midIndex);
        int rightCount = countOccurrencesHelper(arr, target, midIndex + 1, rightIndex);
        return leftCount + rightCount;
    }


    static int Rotated(int[] arr,int s,int e,int k) {
        if(s>e){
            return -1;
        }int mid=s+(e-s)/2;
        if(arr[mid]==k){
            return mid;
        }if(arr[s]<=arr[mid]){//left array
            if(arr[s]<=k && k<=arr[mid]){// smaller then mid
                return Rotated(arr,s,mid-1,k);
            }else{
                return Rotated(arr,mid+1,e,k);
            }
         }else{//right array
            if(arr[e]>=k && k>=arr[mid]){//  greater then mid
                return Rotated(arr,mid+1,e,k);
            }else{
                return Rotated(arr,s,mid-1,k);
            }
         }

    }

    static void Quicksort(int[] arr, int start, int end) {
        if(start>=end){//only for middle element as pivot
            return;
        }
        int s=start;
        int e=end;
        int mid=(s+e)/2;
        int pivot=arr[mid];
        while(s<=e){
            while(arr[s]<pivot){
                s++;

            }while(arr[e]>pivot){
                e--;
            }if(s<=e){//checking while conditon again
                int temp=arr[s];
                arr[s]=arr[e];//swapping part
                arr[e]=temp;
                s++;
                e--;
            }
        }
        Quicksort(arr,start,e);
        //partition
        Quicksort(arr,s,end);

    }
    //adjacent element pivot

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;//swapping pivot

        return i + 1;
    }



    //Inplace sorting
    static void Mergesort2(int[] arr,int s,int e) {
        if(e-s==1){
         return ;
        }
        int mid=(s+e)/2;
        Mergesort2(arr,s,mid);
        Mergesort2(arr,mid,e);
         Merge2(arr,s,mid,e);
    }

    static void Merge2(int[] arr, int s,int m,int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        System.arraycopy(mix, 0, arr, s, mix.length);

        }
    static int[] Mergesort(int[] arr,int s,int e) {
        if(s==e){
            int[]b={arr[s]};//this is because return the only single element in element
            return b;
        }
        int mid=(s+e)/2;
        int []left =Mergesort(arr,s,mid);
        int []right =Mergesort(arr,mid+1,e);
        return Merge(left,right);
    }

    static int[] Merge(int[] f, int[] l) {
        int i=0;
        int j=0;
        int k=0;
        int []mix=new int[f.length+l.length];
        while(i<f.length && j<l.length){
            if(f[i]<l[j]){
                mix[k]=f[i];
                i++;
                k++;
            }else {
                mix[k]=l[j];
                j++;
                k++;
            }}
        while(i<f.length){
            mix[k]=f[i];
            i++;
            k++;
        }while(j<l.length){
            mix[k]=l[j];
            j++;
            k++;
        }return mix;
    }



}