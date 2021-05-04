public class HW08_4108056007_1 extends Buy_Phone_v2
{

	public int[][] bestPhone(int[][] inputArr){
		final int len= inputArr.length, len_minus1= len-1;
		int[][] temp= new int[len][];
		int total=len_minus1;
		boolean flag=false;
		sort(inputArr, 0,len_minus1);

		int[] max_of_y= inputArr[len_minus1];

		temp[total--]=inputArr[len_minus1];
		System.out.println("1 " + inputArr[len_minus1][0]+ " "+inputArr[len_minus1][1]+ " "+inputArr[len_minus1][2]+ " "+inputArr[len_minus1][3]+ " "+inputArr[len_minus1][4]+ " "+inputArr[len_minus1][5]);
		for (int i= len-2; i>=0; --i, flag=false){
			for (int j=1; j<6; ++j){
				if (inputArr[i][j]>max_of_y[j]) {
					max_of_y[j] = inputArr[i][j]; flag=true;
				}
			}
			if (flag){
				temp[total--]=inputArr[i];
			}
		}
		int[][] ans= new int[len_minus1-total][];
		System.out.println(max_of_y[0]+" "+max_of_y[1]+" "+max_of_y[2]+" "+max_of_y[3]+" "+max_of_y[4]+" "+max_of_y[5]);
		for (int i=total+1, j=0; i<len; ++i){
			ans[j]=temp[i];
			System.out.println(temp[i][0]+" "+temp[i][1]+" "+temp[i][2]+" "+temp[i][3]+" "+temp[i][4]+" "+temp[i][5]);

			j++;
		}
		//for (int i=0 ; i < 6; i++){
		//	System.out.println(ans[i][0]+ " " +ans[i][1]+ " " +ans[i][2]+ " " +ans[i][3]+ " " +ans[i][4]+ " " +ans[i][5]);
		//}
		System.out.println();
		return ans;
	}

	void merge(int[][] arr, int l, int m, int r)
	{
		int[][] L, R;
		int n1 = m - l + 1,  n2 = r - m;
		L = new int[n1][];
		R = new int[n2][];

		int i, j;
		for (i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		i = 0; j = 0;
		int k = l, x;
		boolean flag;
		while (i < n1 && j < n2) {
			flag=false;
			if (L[i][0] < R[j][0]) {
				arr[k] = L[i++];
			}
			else if (L[i][0] == R[j][0]){
				for (x=1; x<6; ++x){
					if (L[i][x]>R[j][x]){
						arr[k] = R[j++];
						flag=true; break;
					}
					else if(L[i][x]<R[j][x]){
						arr[k] = L[i++];
						flag=true; break;
					}
				}
				if (!flag) arr[k] = L[i++];
			}
			else {
				arr[k] = R[j++];
			}
			++k;
		}

		while (i < n1) {
			arr[k++] = L[i++];
		}

		while (j < n2) {
			arr[k++] = R[j++];
		}
	}

	void sort(int[][] arr, int l, int r)
	{
		if (l < r) {
			int m =l+ (r-l)/2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
}
