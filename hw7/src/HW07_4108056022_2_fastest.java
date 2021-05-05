public class HW07_4108056022_2 extends Buy_Phone{

    public static void main(String[] args) {
        int[][] inputArr = {{100,10},{100,101},{100,100},{101,4},{4,8},{5,5},{8,4},{10,2},{10,1}};
        HW07_4108056022_2 test = new HW07_4108056022_2();
        int[][] ans = test.bestPhone(inputArr);
        for (int[] an : ans) {
            System.out.println(an[0] + "," + an[1]);
        }
    }
    @Override
    public int[][] bestPhone(final int[][] inputArr){
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
                    if(inputArr[i][0]<=inputArr[j][0] && inputArr[i][1] <= inputArr[j][1]){
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
        return ans;
    }
}
