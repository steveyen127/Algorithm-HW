public class HW05_4108056022_3 extends LLK{

    public class DataItem{
        public double slope;
        public DataItem nextItem;

        public DataItem(double slope, DataItem nextItem){
            this.slope = slope; this.nextItem = nextItem;
        }
    }
    public boolean duplicate(DataItem[] hashArray, double slope, int hashIndex){
        for(DataItem curr = hashArray[hashIndex]; curr!= null; curr = curr.nextItem){
            if(slope == curr.slope) return true;
        }
        return false;
    }
    boolean insert(DataItem[] hashArray, double slope, int size) {

        int hashIndex= (Double.valueOf(slope).hashCode() & 0x7fffffff) % size;
        if(duplicate(hashArray, slope, hashIndex)) return true;

        DataItem item = new DataItem(slope,hashArray[hashIndex]);
        hashArray[hashIndex] = item;

        return false;
    }

    @Override
    public boolean checkLLK(int[][] array) {
        int size = (int)(array.length*1.7);
        double slope;
        DataItem[] hashArray = new DataItem[size];

        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length;j++){
                slope = (double)(array[i][1] - array[j][1]) / (double)(array[i][0]-array[j][0]);
                if(insert(hashArray,slope, size)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] array = {{1,1},
                {0,2},
                {3,3}};
        HW05_4108056022_3 test = new HW05_4108056022_3();
        System.out.println(test.checkLLK(array));
    }
}
