public class HW05_4108056022_1 extends LLK{
    public static void main(String[] args) {
        int[][] array = {{1,1},
                         {0,2},
                         {3,3}};
        HW05_4108056022_1 test = new HW05_4108056022_1();
        System.out.println(test.checkLLK(array));
    }


    boolean collinear(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y1 - y2) * (x1 - x3) == (y1 - y3) * (x1 - x2);
    }

    @Override
    public boolean checkLLK(int[][] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length;j++){
                for(int k = 0; k < array.length; k++){
                    if(i == k || j == k) continue;
                    if(collinear(array[i][0],array[i][1],array[j][0],array[j][1],array[k][0],array[k][1])) return true;
                }
            }
        }
        return false;
    }
}
