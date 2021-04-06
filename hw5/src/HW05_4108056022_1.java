public class HW05_4108056022_1 extends LLK{
    public static void main(String[] args) {
        int[][] array = {{48471285,46187890},{29017325,54336429},{1111,1111},{2222,2222},{39071816,-13623959},{-68518169,15335968},{5555,5555}};
        HW05_4108056022_1 test = new HW05_4108056022_1();
        System.out.println(test.checkLLK(array));
    }


    boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (slope(x1,y1,x2,y2) == slope(x2,y2,x3,y3)){
            return slope(x1, y1, x2, y2) == slope(x1, y1, x3, y3);
        }
        return false;
    }
    double slope(int x1, int y1, int x2, int y2){
        return ((double)(x1 - x2)/ (double) (y1-y2));
    }
    @Override
    public boolean checkLLK(int[][] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length;j++){
                for(int k = 0; k < array.length; k++){
                    if(i == k || j == k) continue;
                    return collinear(array[i][0],array[i][1],array[j][0],array[j][1],array[k][0],array[k][1]);
                }
            }
        }
        return false;
    }
}
