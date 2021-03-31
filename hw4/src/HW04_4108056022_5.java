public class HW04_4108056022_5 extends One_0k_rock{

    public static void main(String[] args) {
        String[] tests = {
                "0000111",      // false
                "01",    // true
                "011",   // false
                "001",   // false
                "0011",  // true
                "0101",  // false
                "013",   // false
                "0000011111", // true

        };
        boolean[] answer;

        HW04_4108056022_5 test = new HW04_4108056022_5();
        answer = test.one0k(tests);
        for(int i = 0; i <tests.length;i++){
            System.out.println(answer[i]);
        }
    }
    public boolean checker(String str){
        int length = str.length()-1;
        for (int i = 0; i <= length>>1; i++){
            if(str.charAt(i) >= str.charAt(length-i)) return false;
        }
        return true;
    }

    public boolean[]  one0k(String[] str){
        boolean[] ans = new boolean[str.length];
        for(int i = 0; i < str.length; i++){
            if(str[i].length()<2) continue;
            ans[i] = checker(str[i]);
        }
        return ans;
    }
}
