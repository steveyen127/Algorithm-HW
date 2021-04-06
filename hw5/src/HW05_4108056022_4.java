public class HW05_4108056022_4 extends LLK{

    volatile boolean found = false;

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
        Thread[] t = new Thread[20];
        int size = (int)(array.length*1.7);
        found = false;
        for(int threadIndex = 0; threadIndex < 20; threadIndex++){
            final int index = threadIndex;
            t[threadIndex] = new Thread(()-> {
                DataItem[] hashArray=new DataItem[size];
                double slope;
                for(int i = index; i < array.length; i+=20){
                    for(int j = i+1; j < array.length;j++){
                        slope = (double)(array[i][0] - array[j][0]) / (double)(array[i][1] - array[j][1]);
                        if(insert(hashArray,slope, size)) {
                            found = true;
                            break;
                        }
                    }
                    if(found)break;
                    hashArray = new DataItem[size];
                }
            });
            t[threadIndex].start();
        }
        for(int threadIndex = 0; threadIndex < 20; threadIndex++){
            try{
                t[threadIndex].join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        return found;
    }
    public static void main(String[] args) {
        int[][] array = {{48471285,46187890},{29017325,54336429},{1111,1111},{2222,2222},{39071816,-13623959},{-68518169,15335968},{5555,5555}};
        HW05_4108056022_4 test = new HW05_4108056022_4();
        System.out.println(test.checkLLK(array));
    }
}

