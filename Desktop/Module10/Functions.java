
public class Functions{
    static int x=153;// example of scoping
    public static void main(String[] args) {
        System.out.println("binary  "+Binary1 (x));
        prime(x);

        System.out.println(isPrime(x));
        //functions 
        int p=5;
        int q=2;
        byte r=4;
        byte s=3;


        Swap(p,q);//call by value
        //swap 
        Swap2(p,q);
       //call by regrence it doesn't swap the no.
        System.out.println(p+" "+q);
        //2nd way pf swaping value
        Swap(r,s);//example of function overloading and depend on no. of parameters and data types
       int k= Fac(p);
       System.out.println(k);
       System.out.println(Bincoeff(p,q));


        
    }public static int Bincoeff(int p, int q) {// to get ncr

int a=Fac(p);// function is used again
int b=Fac(q);
int c=Fac(p-q);
int sum=a/(b*c);

        return sum;
    }
    public static void Swap(byte a,byte b){//call by value
       byte  temp=a;
        a=b;
        b=temp;
        System.out.println(a+" "+b);
    }
    public static void Swap2(int a,int b){//call by refrence (cuz arguement just send the copy) 
        int temp=a;
        a=b;
        b=temp;
       
    }public static void Swap(int a,int b){// just another to swap to value in function
       
        a=a+b;
        b=a-b;
        a=a-b;

        System.out.println(a+" "+b);

        
}public static int Fac(int a){// function to get factorial of no.
    int i=1;
    int j=1;
    while(a>=j){
        i*=j;
j++;

    }return i;
}

public static boolean isPrime(int n){
    if(n<2){
        return false;
    }
    for(int i=2;i<=Math.sqrt(n);i++){
        if(n%i==0){
            return false;
        }
    }


    return true;
}



public static void prime(int l){
   
    for(int i=2;i<=l;i++){
       if(isPrime(i)){
        System.out.print(i+" ");
    }}
}
// Binary to decimal

public static int Binary(int n){

    int i=0;
    int dec=0;
    while(n>0){
        int j=n%10;
        n/=10;
         dec =(int) (dec+j*Math.pow(2, i));
         //remainder =remainder *10+last digit 
         i++;

    }


    return dec;

}
public static int Binary1(int n){//decimal to binary

    int i=0;
    int dec=0;
    while(n>0){
        int j=n%2;
        n/=2;
        dec=(int) (dec+j*Math.pow(10, i));//important formula 
       i++; 

    }


    return dec;


}
}