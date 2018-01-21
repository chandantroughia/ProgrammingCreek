package Math;

//given a string convert it to the column number -- "AB" = 28
public class ExcelSheetColNumber {

    public static int titleToNumber(String s){
        if(s == null || s.length() == 0) return -1;
        int result = 0;
        int t = 0;
        int i = s.length() - 1;

        while(i >= 0){
            char currentChar = s.charAt(i);
            result += (int) Math.pow(26, t) * (currentChar - 'A' + 1);
            t++;
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "AB";
        System.out.println(titleToNumber(s));
    }
}
