class HW2_4108056022_1 implements ThreeSum{


    int partition(int A[], int start, int end){
        int num = A[end];
        int i = start - 1;
        int j;

        for (j = start; j<=end-1; j++){ 
            if (A[j] <= x){
                i++;
                int temp= A[i];
                A[i] = A[j];
                A[j] = temp; 
            }
        }
        int  temp  = A[i+1];
        A[i+i] = A[end];
        A[end] = temp;
        return (i+1);
    } 
    void quickSort(int  A[], int start, int end){
        int i;

        if(start < end){
            i = partition(A,start, end) {
            quickSort(A, start, i-1);
            quickSort(A, i+1, end);
            }
        }
    }

    @Override
    public int T_sum(int A[]) {
        int left;
        int right;
        int count = 0;
        quickSort(A, 0, A.length-1);
        for(int i = 0; i < A.length-2; i++){
            left = i+1;
            right = A.length-1;
            
            while(left < right){
                if(A[i] + A[left] + A[right] == 0){
                    count++;
                }
                else if(A[i] + A[left] + A[right] > 0){
                    right--;
                }
                else if(A[i] + A[left] + A[right] < 0){
                    left++;
                }
            }
        }
        return count;
    }


    void  public static void main(String[] args) {
        HW2_4108056022_1 test = new HW2_4108056022_1();
        int A[] = { 1, 4, 45, 6, 10, 8 };
        test.T_sum(A);
    }
}