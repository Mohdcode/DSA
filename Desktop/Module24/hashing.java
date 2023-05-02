import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class hashing {
    public static void main(String[] args) {
        String s = "race";
        String t = "care";
       System.out.print( isAnagram(s, t));



        //note
        //must check how hashmap are implemented in java as it can be asked in interview
        // HashMap<String,Integer>hm=new HashMap<>(); data structure used in it is arrays of singly linked list
        //LinkedHashmap<K,V>lhm=new LinkedHashmap<>(); data structure is used in it is doubly linked list and remaining is same as hashmap
        //Treemap<K,V>lhm=new Treemap<>(); data structure is used in it is Red black tree (BST) the element are sorted on the bases of keys
        //hashset are implemented by hashmap

        //to get the number of frequency
        int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};//use to decrease the time complexity
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);//increasing the frequency of alredy contained element

            } else {
                map.put(arr[i], 1);
            }
        }
//loops on hashmap
        Set<Integer> keyset = map.keySet();//use hashset keep it unique
        for (Integer key : keyset
        ) {
            if (map.get(key) > arr.length / 3) {
                System.out.println(key);

            }

        }
        HashSet<Integer>set=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
            
        }
        System.out.println(set.size());

        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};
        HashSet<Integer>set1=new HashSet<>();
        //union
        for (int i = 0; i <arr1.length ; i++) {
            set1.add(arr1[i]);

        } for (int i = 0; i <arr2.length ; i++) {
            set1.add(arr2[i]);

        }
        System.out.println("union  "+set1.size());
        set1.clear();
        //intersection
        for (int i = 0; i <arr1.length ; i++) {
            set1.add(arr1[i]);
        }
        int count=0;
        for (int i = 0; i <arr2.length ; i++) {
            if(set.contains(arr2[i])) {
                count++;
                set1.remove(arr2[i]);
            }
        }
        System.out.println("intersection  "+count);

        int subarr[]={15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer>hm=new HashMap<>();
        int sum=0;
        int len=0;
        for (int i = 0; i <subarr.length ; i++) {
            sum+=subarr[i];
            if(map.containsKey(sum)){//if same as sum and already existing sum then
                len=Math.max(len,i- map.get(sum));//sum is key not the value
            }
            else{
                map.put(sum,i);
            }

        }
        System.out.println("length "+len);
        map.clear();

int arr3[]={10,2,-2,-20,10};
int k=-10;
        map.put(0,1);
        int sum1=0;
        int ans=0;
        for (int i = 0; i <arr3.length ; i++) {
            sum1+=arr3[i];
            if (map.containsKey(sum1-k)){
                ans+=map.get(sum1-k);
            }
            map.put(sum1, map.getOrDefault(sum1,0)+1);
        }
        System.out.println("number "+ans);



    }

    private static boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        //frequency part
        for (int i=0;i< s.length();i++){
            char ch =s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(map.get(ch)!=null) {//checking with same character if it already exist
                if (map.get(ch) == 1) {
                    map.remove(ch);//if checked then remove


                } else {
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }
}
