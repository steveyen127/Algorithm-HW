public class HW08_4108056022_1 extends Buy_Phone_v2{



    void merge(int arr[][], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[][] = new int[n1][6];
        int R[][] = new int[n2][6];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i][0] <= R[j][0]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[][], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    int[][] ans(int [][] inputArr){
        int len = inputArr.length, newLen = len, i, j;

        for(i = 0; i < len-1; i++){
            if(inputArr[i] == null){
                newLen--;
                continue;
            }
            for(j = len-1; j > i;j--){
                if(inputArr[j] == null) {
                }
                else {
                    assert inputArr[i] != null;
                    if(inputArr[i][0]<=inputArr[j][0] && inputArr[i][1] <= inputArr[j][1]&& inputArr[i][2] <= inputArr[j][2]&& inputArr[i][3] <= inputArr[j][3]&& inputArr[i][4] <= inputArr[j][4]&& inputArr[i][5] <= inputArr[j][5]){
                        inputArr[i] = null;
                        newLen--; break;
                    }
                }
            }
        }
        int [][] ans = new int [newLen][];
        for(i =0, j=0; i < len; i++){
            if(inputArr[i]!= null){
                ans[j++] = inputArr[i];
            }
        }
        sort(ans, 0, newLen-1);
        return ans;
    }

    @Override
    public int[][] bestPhone(int[][] inputArr){

        sort(inputArr, 0, inputArr.length-1);
        return ans(inputArr);
    }

}
