public class HW05_4108056022_1 extends LLK{
    public static void main(String[] args) {
        int[][] array = {{1,1},
                         {2,2},
                         {3,6}};
    }

    
    public double[]angles(int[][] array,int index){
        double[]angles = new double[array.length];
        for (int i=0;i<array.length; i++){
            if(i == index) continue;
            angles[i]=  Math.atan2(array[i][1] - array[index][1], array[i][0] - array[index][0]) * 180 / Math.PI;
        }
        return angles;
    }
    public boolean checker(double[]angles){

    }
    @Override
    public boolean checkLLK(int[][] array) {
        double[]angles;
        for(int i = 0; i < array.length; i++){
            angles = angles(array,i);
        }
        return false;
    }
}
