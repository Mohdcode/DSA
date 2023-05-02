import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Greedy {
    public static void main(String[] args) {
        int []start={1,3,0,5,8,5};
        int []end={2,4,6,7,9,9};
        int [][]activities=new int [start.length][3];
        for (int i=0;i< start.length;i++){
            //to ge sorted list index
            activities[i][0]=i;
            activities[i][1]=start[i];
            activities[i][2]=end[i];
        }
        //sorting 2d array and object using comparator
        //lambda function using comparator class
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));
        int maxActivity=0;
        ArrayList<Integer>list=new ArrayList<>();
        maxActivity=1;
        list.add(activities[0][0]);
        int lastend=end[0];
        for(int i=0;i<end.length;i++){
            if(activities[i][1]>=lastend){// starting time is great or equal to ending time thne add
                maxActivity++;
                list.add(activities[i][0]);
                lastend=activities[i][2];
            }
        }
        for (Integer integer : list) {
            System.out.println(integer +" "+ maxActivity);
        }



        int []A={1,2,3};
        int []B={2,1,3};
        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff=0;
        for (int i=0;i<A.length;i++){
            minDiff+=Math.abs(A[i]-B[i]);

        }
        System.out.print("Mindiff  "+ minDiff);


        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        Arrays.sort(coins, Comparator.reverseOrder());
        int count=0;
        int amount=590;
        ArrayList<Integer> coinlist=new ArrayList<>();
        for(int i=0;i< coins.length;i++){
            if(coins[i]<=amount){
                while (coins[i]<=amount){
                    count++;
                    coinlist.add(coins[i]);
                    amount-=coins[i];
                }
            }
        }
        System.out.print(count);
    }


}
