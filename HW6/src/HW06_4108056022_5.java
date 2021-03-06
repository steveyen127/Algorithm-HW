public class HW06_4108056022_5 extends Dessert_Desert{


    public int solution(int[] arr){
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        minOfRight[n-1] = arr[n-1];
        int m = n-1;
        for(int i = 1; i < n; i++){
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
            minOfRight[m-i] = Math.min(minOfRight[n-i], arr[m-i]);
        }
        int ans=0;
        for (int i=0;i<n-1;i++){
            if(maxOfLeft[i] <= minOfRight[i+1]) ++ans;
        }
        return ans+1;
    }

    @Override
    public int[] maxBlocks(int[][] inputArr){
        int[] ans = new int[inputArr.length];
        Thread[] multiThread = new Thread [8];
        for (int threadIndex = 0; threadIndex < 8; threadIndex++){
            final int index = threadIndex;
            multiThread[threadIndex] = new Thread(()->{
                for (int i =index; i < inputArr.length; i+=8){
                    ans[i] = solution(inputArr[i]);
                }
            });
            multiThread[threadIndex].start();
        }
        for(int i = 0; i < 8; i++){
            try{
                multiThread[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        return ans;
    }
}
