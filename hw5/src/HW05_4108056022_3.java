public class HW05_4108056022_3 extends LLK{

    boolean found = false;
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
        Thread[] t = new Thread[5];
        int size = 1 << ((int) Math.ceil(Math.log10(array.length) / 0.3010));
        for(int threadIndex = 0; threadIndex < 5; threadIndex++){
            t[threadIndex] = new Thread(()-> {
                    double slope;
                    DataItem[] hashArray = new DataItem[size];
                    for(int i = 0; i < array.length; i+=5){
                        for(int j = i+1; j < array.length;j++){
                            slope = (double)(array[i][1] - array[j][1]) / (double)(array[i][0]-array[j][0]);
                            if(insert(hashArray,slope, size)) {
                                found = true;
                                break;
                            }
                        }
                        if(found) break;
                    }
            });
            t[threadIndex].start();
        }
        try{
            t[0].join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            t[1].join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            t[2].join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            t[3].join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            t[4].join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return found;
    }
    public static void main(String[] args) {
        int[][] array = {{1,1},
                {2,2},
                {3,3}};
        HW05_4108056022_3 test = new HW05_4108056022_3();
        System.out.println(test.checkLLK(array));
    }
}

