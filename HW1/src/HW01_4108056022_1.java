public class HW01_4108056022_1 extends ArrayData {

    public HW01_4108056022_1 (int[] A){
        this.A = A;
    }
    public static void main(String[] args){
        int[] A = {3,2,1,2,5,6,7,8,9,2,2,2,2,1,1,10};
        HW01_4108056022_1 test = new HW01_4108056022_1(A);
        System.out.println("Max = " + test.max());
        System.out.println("Min = " + test.min());
    }


public class ThreadforLoopA extends Thread{
    int max;
    int min;
    int [] A;

    public ThreadforLoopA (int[] A){
        this.A = A;
    }

    public void run(){
        max = A[0];
        min = A[0];
        for(int i = 1; i <= A.length/2; i++){
            if( A[i] > max){
                max = A[i];
            }
            if( A[i] < min){
                min = A[i];
            }
        }
    }
}
public class ThreadforLoopB extends Thread{
    int max;
    int min;
    int[] A;

    public ThreadforLoopB (int[] A){
        this.A = A;
    }
    public void run(){
        max = A[A.length-1];
        min = A[A.length-1];
        for(int j = A.length-1; j > A.length/2; j--){
            if( A[j] > max){
                max = A[j];
            }
            if( A[j] < min){
                min = A[j];
            }
        }
    }
}

@Override
public int max(){
    ThreadforLoopA loopA = new ThreadforLoopA(A);
    ThreadforLoopB loopB = new ThreadforLoopB(A);
    loopA.start();
    loopB.start();
    
    
    if(loopA.max>loopB.max){
        A[1] = loopA.max;
    }else{
        A[1] = loopB.max;
    }
    if(loopA.min>loopB.min){
        A[0] = loopB.min;
    }else{
        A[0] = loopA.min;
    }
    return A[1];
}

public int min(){
    return A[0];
}

}
