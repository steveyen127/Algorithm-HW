public class HW06_4108056011_5 extends Dessert_Desert{

    public static void main(String[] args){
        int [][] A = {{1,1,1,1,1,1,1},{1,3,5,7,9},{1,2,3},{5,4,3,2,1},{2,1,3,2},{6,1,5,8,3,7,9,8,10},{6,8,1,7,10,9,12,11},{2,2,2,1,1,1}};
        HW06_4108056011_5 t = new HW06_4108056011_5();
        int[] Ans;
        Ans=t.maxBlocks(A);
        for (int i=0;i<Ans.length;i++)
            System.out.println(Ans[i]);
    }

    static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[i];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    static int[] quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
        return arr;
    }

    public int[] maxBlocks(int[][] inputArr){
        int[] A=new int[inputArr.length];
        int[] sinput;
        long n1,n2;
        for (int i=0;i<inputArr.length;++i){
            n1=n2=0;
            sinput=new int[inputArr[i].length];
            System.arraycopy(inputArr[i],0,sinput,0,inputArr[i].length);
            quickSort(sinput,0,sinput.length-1);
            for (int k=0;k<inputArr[i].length;++k){
                n1+=inputArr[i][k];
                n2+=sinput[k];
                if (n1==n2){
                    ++A[i];
                    n1=n2=0;
                }
            }
        }
        return A;
    }

}
