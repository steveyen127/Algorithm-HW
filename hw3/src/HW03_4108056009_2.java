
public class HW03_4108056009_2 extends HillFinding{

	public int H_Finding(int[] A) {
		int ikey=A.length-1;
		int istart=0;
		int iend=A.length-1;
		int ihalf=A.length/2;
		while(A[ihalf]<=A[ihalf+1])
		{
			if(A[ihalf]>A[ikey])
			{
				istart=ihalf+1;
				ihalf=((istart+iend)/2);
			}
			else if(A[ihalf]<A[ikey])
			{
				iend=ihalf-1;
				ihalf=((istart+iend)/2);
			}
			else
			{
				for(int i=istart;i<=iend;i++)
				{
					if(A[i]>A[i+1])
					{
						ihalf=i;
						break;
					}
				}
			}
		}
		return A.length-ihalf-2;
	}
	public static void main(String[] args) {
		int[] A= {1,1,1,1,1,1,0,1,1,1,1};
		HW03_4108056009_2 kk = new HW03_4108056009_2();
		System.out.println(kk.H_Finding(A));
	}
}
