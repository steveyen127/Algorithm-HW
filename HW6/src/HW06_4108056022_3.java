public class HW06_4108056022_3 extends Dessert_Desert{
    public static void main(String[] args){
        int [][] A = {{1,1,1,1,1,1,1},{1,3,5,7,9},{1,2,3},{5,4,3,2,1},{2,1,3,2},{6,1,5,8,3,7,9,8,10},{6,8,1,7,10,9,12,11},{2,2,2,1,1,1}};
        HW06_4108056022_3 t = new HW06_4108056022_3();
        int[] Ans;
        Ans=t.maxBlocks(A);
        for (int an : Ans) System.out.println(an);
    }

    public int solution(int[] arr){
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        minOfRight[n-1] = arr[n-1];
        int m = n-1;
        for(int i = 1; i < n; i++){
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }
        for(int i = n-2; i >= 0; i--){
            minOfRight[i] = Math.min(minOfRight[i+1],arr[i]);
        }
        int ans=0;
        for (int i=0;i<n-1;i++){
            if(maxOfLeft[i] <= minOfRight[i+1]) ans++;
        }
        return ans+1;
    }

    @Override
    public int[] maxBlocks(int[][] inputArr){
        int[] ans = new int[inputArr.length];
        Thread[] multiThread = new Thread [10];
        for (int threadIndex = 0; threadIndex < 10; threadIndex++){
            final int index = threadIndex;
            multiThread[threadIndex] = new Thread(()->{
                for (int i =index; i < inputArr.length; i+=10){
                    ans[i] = solution(inputArr[i]);
                }
            });
            multiThread[threadIndex].start();
        }
        for(int i = 0; i < 10; i++){
            try{
                multiThread[i].join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        return ans;
    }
}
