public class HW03_4108056022_1 extends HillFinding{
    volatile boolean flag = false;
    public static void main(String[] args) {
        int[] A = {8,1,1,1,1,1,1,1,1,1};
        HW03_4108056022_1 test = new HW03_4108056022_1();
        System.out.println(test.H_Finding(A));
    }
    public class multi_search extends Thread{
        int A[], start, end,  ans[];
        public multi_search(int[] A, int start, int[] ans){
            this.A = A; this.start = start; this.ans = ans;
        }
        public void run(){
            int i;
            for(i = start; !flag && A[i]<=A[i+1]; i++);
            if(!flag)ans[0] = A.length-1 - (i+1);
            flag = true;
        }

    }
    public int thread_call(int[] A){
        int ans[]={0,0};

        multi_search thread1 = new multi_search(A,0,ans);
        multi_search thread2 = new multi_search(A, A.length/2, ans);
        thread1.start();
        thread2.start();
        try{
            thread1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        try {
            thread2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return ans[0];
    }
    @Override
    public int H_Finding(int[] A) {
        int mid, start = 0, end = A.length-1, lasto = end;
        while(start < end){
            mid= (start+end)>>>1;
            if(A[mid+1]<A[mid]) return lasto-(mid+1);
            else if(A[mid] < A[mid-1]) return lasto-mid;
            if(A[end] > A[mid]) end = mid-1;
            else start = mid+1;
        }
        return thread_call(A);
    }
}



