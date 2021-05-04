public class HW08_4108056019_1 extends Buy_Phone_v2{
    public int[][] bestPhone(int[][] inputArr){
        int[][] ansL = new int[inputArr.length][6];
        sort(inputArr, 0, inputArr.length - 1, 5);   
        sort(inputArr, 0, inputArr.length - 1, 4);   
        sort(inputArr, 0, inputArr.length - 1, 3);   
        sort(inputArr, 0, inputArr.length - 1, 2);   
        sort(inputArr, 0, inputArr.length - 1, 1);
        sort(inputArr, 0, inputArr.length - 1, 0);   
        
        int count = 1;
        int countAns;
        int max[] = new int[5];
        for(int i = 0; i < 5; i++){
            max[i] = inputArr[inputArr.length - 1][i+1];
        }
        int j = inputArr.length - 1;
        ansL[inputArr.length - 1] = inputArr[inputArr.length - 1];
        
        for(int i = inputArr.length - 1; i > 0; i--){
            countAns = 0;
            if(max[0] < inputArr[i - 1][1]){
                max[0] = inputArr[i - 1][1];
                countAns++;
            }
            if(max[1] < inputArr[i - 1][2]){
                max[1] = inputArr[i - 1][2];
                countAns++;
            }
            if(max[2] < inputArr[i - 1][3]){
                max[2] = inputArr[i - 1][3];
                countAns++;
            }
            if(max[3] < inputArr[i - 1][4]){
                max[3] = inputArr[i - 1][4];
                countAns++;
            }
            if(max[4] < inputArr[i - 1][5]){
                max[4] = inputArr[i - 1][5];
                countAns++;
            }
            if(countAns > 0){
                ansL[--j] = inputArr[i - 1];
                count++; 
            }             
        }        
        int[][] ansS = new int[count][6];
        int len = ansL.length - count - 1;
        for(int i = ansL.length - 1; i > len; i--){
            ansS[--count][0] = ansL[i][0];
            ansS[count][1] = ansL[i][1];
            ansS[count][2] = ansL[i][2];
            ansS[count][3] = ansL[i][3];
            ansS[count][4] = ansL[i][4];
            ansS[count][5] = ansL[i][5];
        }

        return ansS;
    }   

        static void merge(int arr[][], int l, int m, int r, int xy)
        {
            int n1 = m - l + 1;
            int n2 = r - m;
     
            int L[][] = new int[n1][6];
            int R[][] = new int[n2][6];
            
            for (int i = 0; i < n1; ++i){
                L[i][0] = arr[l + i][0];
                L[i][1] = arr[l + i][1];
                L[i][2] = arr[l + i][2];
                L[i][3] = arr[l + i][3];
                L[i][4] = arr[l + i][4];
                L[i][5] = arr[l + i][5];
            }
            for (int j = 0; j < n2; ++j){
                R[j][0] = arr[m + 1 + j][0];
                R[j][1] = arr[m + 1 + j][1];
                R[j][2] = arr[m + 1 + j][2];
                R[j][3] = arr[m + 1 + j][3];
                R[j][4] = arr[m + 1 + j][4];
                R[j][5] = arr[m + 1 + j][5];
                
            }
            int i = 0, j = 0;
            int k = l;
            if(xy == 0){
                while (i < n1 && j < n2) {
                    if (L[i][xy] <= R[j][xy]) {
                        arr[k][xy] = L[i][xy];
                        arr[k][1] = L[i][1];
                        arr[k][2] = L[i][2];
                        arr[k][3] = L[i][3];
                        arr[k][4] = L[i][4];
                        arr[k][5] = L[i][5];
                        i++;
                    }
                    else {
                        arr[k][xy] = R[j][xy];
                        arr[k][1] = R[j][1];
                        arr[k][2] = R[j][2];
                        arr[k][3] = R[j][3];
                        arr[k][4] = R[j][4];
                        arr[k][5] = R[j][5];
                        j++;
                    }
                    k++;
                }
    
                while (i < n1) {
                    arr[k][xy] = L[i][xy];
                    arr[k][1] = L[i][1];
                    arr[k][2] = L[i][2];
                    arr[k][3] = L[i][3];
                    arr[k][4] = L[i][4];
                    arr[k][5] = L[i][5];
                    i++;
                    k++;
                }
    
                while (j < n2) {
                    arr[k][xy] = R[j][xy];
                    arr[k][1] = R[j][1];
                    arr[k][2] = R[j][2];
                    arr[k][3] = R[j][3];
                    arr[k][4] = R[j][4];
                    arr[k][5] = R[j][5];
                    j++;
                    k++;
                }
            }
            else if(xy == 1){
                while (i < n1 && j < n2) {
                    if (L[i][xy] <= R[j][xy]) {
                        arr[k][xy] = L[i][xy];
                        arr[k][0] = L[i][0];
                        arr[k][2] = L[i][2];
                        arr[k][3] = L[i][3];
                        arr[k][4] = L[i][4];
                        arr[k][5] = L[i][5];
                        i++;
                    }
                    else {
                        arr[k][xy] = R[j][xy];
                        arr[k][0] = R[j][0];
                        arr[k][2] = R[j][2];
                        arr[k][3] = R[j][3];
                        arr[k][4] = R[j][4];
                        arr[k][5] = R[j][5];
                        j++;
                    }
                    k++;
                }
    
                while (i < n1) {
                    arr[k][xy] = L[i][xy];
                    arr[k][0] = L[i][0];
                    arr[k][2] = L[i][2];
                    arr[k][3] = L[i][3];
                    arr[k][4] = L[i][4];
                    arr[k][5] = L[i][5];
                    i++;
                    k++;
                }
    
                while (j < n2) {
                    arr[k][xy] = R[j][xy];
                    arr[k][0] = R[j][0];
                    arr[k][2] = R[j][2];
                    arr[k][3] = R[j][3];
                    arr[k][4] = R[j][4];
                    arr[k][5] = R[j][5];
                    j++;
                    k++;
                }
            }
            else if(xy == 2){
                while (i < n1 && j < n2) {
                    if (L[i][xy] <= R[j][xy]) {
                        arr[k][xy] = L[i][xy];
                        arr[k][0] = L[i][0];
                        arr[k][1] = L[i][1];
                        arr[k][3] = L[i][3];
                        arr[k][4] = L[i][4];
                        arr[k][5] = L[i][5];
                        i++;
                    }
                    else {
                        arr[k][xy] = R[j][xy];
                        arr[k][0] = R[j][0];
                        arr[k][1] = R[j][1];
                        arr[k][3] = R[j][3];
                        arr[k][4] = R[j][4];
                        arr[k][5] = R[j][5];
                        j++;
                    }
                    k++;
                }
    
                while (i < n1) {
                    arr[k][xy] = L[i][xy];
                    arr[k][0] = L[i][0];
                    arr[k][1] = L[i][1];
                    arr[k][3] = L[i][3];
                    arr[k][4] = L[i][4];
                    arr[k][5] = L[i][5];
                    i++;
                    k++;
                }
    
                while (j < n2) {
                    arr[k][xy] = R[j][xy];
                    arr[k][0] = R[j][0];
                    arr[k][1] = R[j][1];
                    arr[k][3] = R[j][3];
                    arr[k][4] = R[j][4];
                    arr[k][5] = R[j][5];
                    j++;
                    k++;
                }
            }
            else if(xy == 3){
                while (i < n1 && j < n2) {
                    if (L[i][xy] <= R[j][xy]) {
                        arr[k][xy] = L[i][xy];
                        arr[k][0] = L[i][0];
                        arr[k][1] = L[i][1];
                        arr[k][2] = L[i][2];
                        arr[k][4] = L[i][4];
                        arr[k][5] = L[i][5];
                        i++;
                    }
                    else {
                        arr[k][xy] = R[j][xy];
                        arr[k][0] = R[j][0];
                        arr[k][1] = R[j][1];
                        arr[k][2] = R[j][2];
                        arr[k][4] = R[j][4];
                        arr[k][5] = R[j][5];
                        j++;
                    }
                    k++;
                }
    
                while (i < n1) {
                    arr[k][xy] = L[i][xy];
                    arr[k][0] = L[i][0];
                    arr[k][1] = L[i][1];
                    arr[k][2] = L[i][2];
                    arr[k][4] = L[i][4];
                    arr[k][5] = L[i][5];
                    i++;
                    k++;
                }
    
                while (j < n2) {
                    arr[k][xy] = R[j][xy];
                    arr[k][0] = R[j][0];
                    arr[k][1] = R[j][1];
                    arr[k][2] = R[j][2];
                    arr[k][4] = R[j][4];
                    arr[k][5] = R[j][5];
                    j++;
                    k++;
                }
            }
            else if(xy == 4){
                while (i < n1 && j < n2) {
                    if (L[i][xy] <= R[j][xy]) {
                        arr[k][xy] = L[i][xy];
                        arr[k][0] = L[i][0];
                        arr[k][1] = L[i][1];
                        arr[k][2] = L[i][2];
                        arr[k][3] = L[i][3];
                        arr[k][5] = L[i][5];
                        i++;
                    }
                    else {
                        arr[k][xy] = R[j][xy];
                        arr[k][0] = R[j][0];
                        arr[k][1] = R[j][1];
                        arr[k][2] = R[j][2];
                        arr[k][3] = R[j][3];
                        arr[k][5] = R[j][5];
                        j++;
                    }
                    k++;
                }
    
                while (i < n1) {
                    arr[k][xy] = L[i][xy];
                    arr[k][0] = L[i][0];
                    arr[k][1] = L[i][1];
                    arr[k][2] = L[i][2];
                    arr[k][3] = L[i][3];
                    arr[k][5] = L[i][5];
                    i++;
                    k++;
                }
    
                while (j < n2) {
                    arr[k][xy] = R[j][xy];
                    arr[k][0] = R[j][0];
                    arr[k][1] = R[j][1];
                    arr[k][2] = R[j][2];
                    arr[k][3] = R[j][3];
                    arr[k][5] = R[j][5];
                    j++;
                    k++;
                }
            }
            else if(xy == 5){
                while (i < n1 && j < n2) {
                    if (L[i][xy] <= R[j][xy]) {
                        arr[k][xy] = L[i][xy];
                        arr[k][0] = L[i][0];
                        arr[k][1] = L[i][1];
                        arr[k][2] = L[i][2];
                        arr[k][3] = L[i][3];
                        arr[k][4] = L[i][4];
                        i++;
                    }
                    else {
                        arr[k][xy] = R[j][xy];
                        arr[k][0] = R[j][0];
                        arr[k][1] = R[j][1];
                        arr[k][2] = R[j][2];
                        arr[k][3] = R[j][3];
                        arr[k][4] = R[j][4];
                        j++;
                    }
                    k++;
                }
    
                while (i < n1) {
                    arr[k][xy] = L[i][xy];
                    arr[k][0] = L[i][0];
                    arr[k][1] = L[i][1];
                    arr[k][2] = L[i][2];
                    arr[k][3] = L[i][3];
                    arr[k][4] = L[i][4];
                    i++;
                    k++;
                }
    
                while (j < n2) {
                    arr[k][xy] = R[j][xy];
                    arr[k][0] = R[j][0];
                    arr[k][1] = R[j][1];
                    arr[k][2] = R[j][2];
                    arr[k][3] = R[j][3];
                    arr[k][4] = R[j][4];
                    j++;
                    k++;
                }
            }
        }
        static void sort(int arr[][], int l, int r, int xy)
        {
            if (l < r) {
                int m =l+ (r-l)/2;
    
                sort(arr, l, m, xy);
                sort(arr, m + 1, r, xy);

                merge(arr, l, m, r, xy);
            }
        }
}