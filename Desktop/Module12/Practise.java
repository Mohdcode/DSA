public class Practise{
    public static void main(String[] args) {
        //1st
        //return true if same element appears in a array
        int num[]={7,1,5,3,6,4};
        System.out.print( Stock(num));
       
    }

     static boolean Same(int[] num) {

        for(int i=0;i<num.length;i++){
for(int j=i+1;j<num.length;j++){
    
            if(num[i]==num[j]){
                return true;
        } 
        }
    }
return false;
    }

static int Stock(int []num){//calculating stocks price
    int buy=Integer.MAX_VALUE;
    int maxprofit=0;            //{7,1,5,3,6,4}
    for(int i=0;i<num.length;i++){
        if(buy<num[i]){
            int profit=num[i]-buy;
            maxprofit=Math.max(maxprofit, profit);
        }else{
            buy=num[i];
        }


    }
    return maxprofit;
}


}