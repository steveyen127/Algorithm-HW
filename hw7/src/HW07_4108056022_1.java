public class HW07_4108056022_1 extends Buy_Phone{

static int[][] tempArr = new int[100000][2];
    public static void main(String[] args) {
        int[][] inputArr = {{100,10},{100,101},{100,100},{101,4},{4,8},{5,5},{8,4},{10,2},{10,1}};
        HW07_4108056022_1 test = new HW07_4108056022_1();
        int[][] ans = test.bestPhone(inputArr);
        for (int[] an : ans) {
            System.out.println(an[0] + "," + an[1]);
        }
    }


    void quickSort(int A[][], int left, int right) {
        if (left >= right) {
            return;
        }
        int[] key = A[left];int i = left, j = right;
        int[] temp;
        while (i != j) {
            while (A[j][0] > key[0] && i < j) {
                j--;
            }
            while (A[i][0] <= key[0] && i < j) {
                
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

    @Override
    public int[][] bestPhone(int[][] inputArr){
        int len = inputArr.length;
        int ansIndex=0, maxX, maxY;
        quickSort(inputArr,0,len-1);
        tempArr[0] = inputArr[len-1];
        maxX = inputArr[len-1][0];
        maxY = inputArr[len-1][1];
        for(int i = len-2; i > -1; i--){
            maxY = Math.max(maxY, inputArr[i][1]);
            if(inputArr[i][0]<maxX && inputArr[i][1] < maxY) continue;
            if(inputArr[i][0] != tempArr[ansIndex][0] && inputArr[i][1]!=tempArr[ansIndex][1]){
                tempArr[++ansIndex] = inputArr[i];
            }
        }
        int[][]result = new int [ansIndex+1][2];
        for(int i=0; i <= ansIndex; i++){
            result[i] = tempArr[ansIndex-i];
        }
        return result;
    }
}
