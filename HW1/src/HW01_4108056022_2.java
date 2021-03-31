public class HW01_4108056022_2 extends ArrayData {

    public HW01_4108056022_2 (int[] A){
        this.A = A;
    }
    public static void main(String[] args){
        int[] A = {1,2,3};
        HW01_4108056022_2 test = new HW01_4108056022_2(A);
        System.out.println("Max = " + test.max());
        System.out.println("Min = " + test.min());
    }


@Override
public int max(){
    int max = Integer.MIN_VALUE;
    for(int i = A.length-1; i >= 0; i--){
        if(A[i] > max){
            max = A[i];
        }
    }
    return max;
}

public int min(){
    int min = Integer.MAX_VALUE;
    for(int i = A.length-1; i >= 0; i--){
        if(A[i] < min){
            min = A[i];
        }
    }
    return min;
}

}
