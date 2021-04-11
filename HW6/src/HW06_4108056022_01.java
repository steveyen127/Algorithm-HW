public class HW06_4108056022_01 extends Dessert_Desert{

    public int solution(int[] arr){
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        minOfRight[n-1] = arr[n-1];
        int m = n-1;
        for(int i = 1; i < n; i++){
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
            minOfRight[i] = Math.min(minOfRight[n-i], arr[m-i]);
        }
        int ans=0;
        for (int i=0;i<n;i++){
            if(maxOfLeft[i] <= minOfRight[i]) ++ans;
        }
    return ans+1;
    }

    @Override
    public int[] maxBlocks(int[][] inputArr){
        int[] ans = new int[inputArr.length];
        for (int i =0; i < inputArr.length; i ++){
            ans[i] = solution(inputArr[i]);
        }
        return ans;
    }
}
