package math;

public class PowRecursion {
    
    public static long pow(int a,int b){
        return b == 0 ? 1 : a * pow(a,b-1);
    }
}
