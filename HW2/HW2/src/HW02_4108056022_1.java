public class HW02_4108056022_1 extends ThreeSum{


    int partition(int A[], int start, int end){
        int pivot = A[end];
        int i = (start - 1);

        for (int j = start; j < end; j++){ 
            if (A[j] <= pivot){
                i++;
                int temp= A[i];
                A[i] = A[j];
                A[j] = temp; 
            }
        }

        int  temp  = A[i+1];
        A[i+1] = A[end];
        A[end] = temp;
        return (i+1);
    } 
    void quickSort(int  A[], int left, int right){
        int i;

        if(left < right){
            i = partition(A, left, right);
            quickSort(A, left, i-1);    
            quickSort(A, i+1, right);
            
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
                    System.out.printf("%d\n", count);
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


  public static void main(String[] args) {
        int A[] = {1,2,3,4,-1,-2,-3,-4};
        HW02_4108056022_1 test = new HW02_4108056022_1();
        System.out.printf("count: %d\n",test.T_sum(A));
    }
}