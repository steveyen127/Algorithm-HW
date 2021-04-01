public class HW02_4108056022_1 extends ThreeSum {

    public static void main(String[] args) {
        int A[] = {-1,0,2,-2,3,1};
        HW02_4108056022_1 test = new HW02_4108056022_1();
        System.out.println(test.T_sum(A));
    }
    class multiple extends Thread{
        int A[],counts[], index, partitions;
        public multiple(int A[], int partitions, int index, int counts[]){
            this.A = A; this.partitions = partitions; this.index = index; this.counts = counts;
        }
        public void run(){
            int count = 0, left, right, j, target;
            for (j = index; j < A.length - 2; j+=partitions) {
                if (A[j] >= 0) break;
                left = j + 1;
                right = A.length - 1;
                target = -A[j];
                while (left < right) {
                    if (A[left] + A[right] == target) {
                        count++;
                        --right;++left;
                    } else if (A[left] + A[right] > target) {
                        --right;
                    } else{
                        ++left;
                    }
                }
            }
            counts[index] = count;

        }
    }
    void threadx6(int A[], int counts[]){
        multiple thread1 = new multiple(A,6,0,counts);
        multiple thread2 = new multiple(A,6,1,counts);
        multiple thread3 = new multiple(A,6,2,counts);
        multiple thread4 = new multiple(A,6,3,counts);
        multiple thread5 = new multiple(A,6,4,counts);
        multiple thread6 = new multiple(A,6,5,counts);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try{
            thread1.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        try{
            thread2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        try{
            thread3.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        try{
            thread4.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        try{
            thread5.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        try{
            thread6.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    void quickSort(int A[], int left, int right) {
        if (left >= right) {
            return;
        }
        int key = A[left], i = left, j = right, temp;
        while (i != j) {
            while (A[j] > key && i < j) {
                j--;
            }
            while (A[i] <= key && i < j) {
                i++;
            }
            if (i < j) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        temp = A[left];
        A[left] = A[i];
        A[i] = temp;
        quickSort(A, left, i - 1);
        quickSort(A, i + 1, right);

    }

        public int T_sum(int A[]) {
            int totalCount=0;
            int counts[]={0,0,0,0,0,0};
            if(A.length < 3){
                return 0;
            }else{
                quickSort(A, 0, A.length-1);
                threadx6(A,counts);
            }
            return (counts[0]+counts[1]+counts[2]+counts[3]+counts[4]+counts[5]);
        }
}