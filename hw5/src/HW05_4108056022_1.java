public class HW05_4108056022_1 extends LLK{
    public static void main(String[] args) {
        int[][] array = {{1,1},
                         {2,2},
                         {3,3}};
        HW05_4108056022_1 test = new HW05_4108056022_1();
        System.out.println(test.checkLLK(array));
    }

    void quickSort(double A[], int left, int right) {
        if (left >= right) {
            return;
        }
        double key = A[left], temp;
        int i = left, j = right;
        while (i != j) {
            while (A[j] > key && i < j) {
                j--;
            }
            while (A[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[left];
        A[left] = A[i];
        A[i] = temp;
        quickSort(A, left, i - 1);
        quickSort(A, i + 1, right);

    }
    public double[]angles(int[][] array,int index){
        double[]angles = new double[array.length];
        for (int i=0;i<array.length; i++){
            if(i == index) continue;
            angles[i]=  Math.atan2(array[i][1] - array[index][1], array[i][0] - array[index][0]) * 180 / Math.PI;
        }
        return angles;
    }
    public boolean checker(double[]angles){
        quickSort(angles, 0, angles.length-1);
        for (int i = 0; i < angles.length-1; i++){
            if(angles[i] == angles[i+1]) return true;
        }
        return false;
    }
    @Override
    public boolean checkLLK(int[][] array) {
        double[]angles;
        boolean flag;
        for(int i = 0; i < array.length; i++){
            flag = checker(angles(array,i));
            if(flag== true) return true;
        }
        return false;
    }
}
