public class HW06_4108056022_4 extends Dessert_Desert{

    public static void main(String[] args){
        int [][] A = {{1,1,1,1,1,1,1},{1,3,5,7,9},{1,2,3},{5,4,3,2,1},{2,1,3,2},{6,1,5,8,3,7,9,8,10},{6,8,1,7,10,9,12,11},{2,2,2,1,1,1}};
        HW06_4108056022_4 t = new HW06_4108056022_4();
        int[] Ans;
        Ans=t.maxBlocks(A);
        for (int an : Ans) System.out.println(an);
    }


    @Override
    public int[] maxBlocks(int[][] inputArr){
        int[] ans = new int[inputArr.length];
        Thread[] multiThread = new Thread [10];
        for (int threadIndex = 0; threadIndex < 10; threadIndex++){
            final int index = threadIndex;
            multiThread[threadIndex] = new Thread(()->{
                int[] minOfRight;
                int maxOfLeft, len, j;
                for (int i =index; i < inputArr.length; i+=10){
                    len = inputArr[i].length-1;
                    minOfRight = new int[len+1];
                    minOfRight[len] = inputArr[i][len];
                    for(j = len-1; j >= 0; j--){
                        minOfRight[j] = (minOfRight[j+1]>inputArr[i][j])? inputArr[i][j]:minOfRight[j+1];
                    }
                    ans[i] = 1;
                    maxOfLeft = inputArr[i][0];
                    for(j = 1; j <= len; j++){
                        if(maxOfLeft <= minOfRight[j]){
                            ++ans[i];
                            maxOfLeft = inputArr[i][j];
                        }else{
                            maxOfLeft = (maxOfLeft>inputArr[i][j])? maxOfLeft:inputArr[i][j];
                        }
                    }
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
