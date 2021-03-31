public class HW04_4108056022_2 extends One_0k_rock{

    public static void main(String[] args) {
        String[] tests = {
                "0000111",      // false
                "0",    // true
                "011",   // false
                "001",   // false
                "0011",  // true
                "0101",  // false
                "013",   // false
                "0000011111", // true

        };
        boolean[] answer;

        HW04_4108056022_2 test = new HW04_4108056022_2();
        answer = test.one0k(tests);
        for(int i = 0; i <tests.length;i++){
            System.out.println(answer[i]);
        }
    }
    public boolean checker(String str){
        int length = str.length()-1;
        for (int i = length>>1; i >=0; i--){
            if(str.charAt(i)>=str.charAt(length-i)) return false;
        }
        return true;
    }

    public boolean[]  one0k(String[] str){
        boolean[] ans = new boolean[str.length];
        for(int i = 0; i < str.length; i++){
            ans[i] = checker(str[i]);
        }
        return ans;
    }
}
