public  class HW03_4108056011_2 extends HillFinding {
    public static void main(String[] args){
        int[] A = {4,4,4,5,4,4,4};
        HW03_4108056011_2 t = new HW03_4108056011_2();
        System.out.println(t.H_Finding(A));
    }



    public  int H_Finding(int[] A){
        int[] v={0,0,0,0,0};
        int f=0,i,l=0,r=A.length-2,tar=A[r];
        while(l<r){
            f=0;
            v[0]=l;
            v[1]=l+(r-l)/5;
            v[2]=l+2*(r-l)/5;
            v[3]=l+3*(r-l)/5;
            v[4]=r;
            for(i=0;i<=4;++i){
                if(A[v[i]]>A[v[i]+1])
                    return A.length-v[i]-2;
                if(A[v[i]]>tar) {
                    if (v[i] > l) {
                        f = 1;
                        l = v[i];
                    }
                }
                if(A[v[i]]<tar){
                    if(v[i]<r) {
                        r = v[i];
                        f=1;
                    }
                }
            }
            if(f==0){
                for(i=l;i<=r;++i)
                    if(A[i]>A[i+1])
                        return A.length-i-2;
            }
        }
        return -1;
    }


}