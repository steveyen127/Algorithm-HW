public  class HW03_4108056011_1 extends HillFinding {
    public static void main(String[] args){
        int[] A = {6,7,8,5,6};
        HW03_4108056011_1 t = new HW03_4108056011_1();
        System.out.println(t.H_Finding(A));
    }



    public  int H_Finding(int[] A){
        int i;
        int start=0;
        int end=A.length-2;
        int target=A[A.length-1];
        while (start <= end) {
            int mid = (start + end) / 2;
            if(A[mid]>A[mid+1])
                return A.length-mid-2;
            if(A[mid]>target)
                start=mid+1;
            if(A[mid]<target)
                end=mid-1;
            if(A[mid]==target)
                for(i=start;i<=end;i++)
                    if(A[i]>A[i+1])
                        return A.length-i-2;
        }
        return -1;
    }


}
