public class HW01_4108056022_3 extends ArrayData {

    public HW01_4108056022_3 (int[] A){
        this.A = A;
    }
    public static void main(String[] args){
        int[] A = {1,2,3};
        HW01_4108056022_3 test = new HW01_4108056022_3(A);
        System.out.println("Max = " + test.max());
        System.out.println("Min = " + test.min());
    }

public int max(){
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < A.length; i++){
        if( A[i] > max){
            max = A[i];
        }
        if( A[i] < min){
            min = A[i];
        }
    }
    A[0] = min;
    return max;
}

public int min(){
    int min = A[0];
    return min;
}

}
