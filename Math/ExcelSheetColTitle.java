package Math;

//Given an integer convert it to the column title in the excel sheet --> 28 = "AB"
public class ExcelSheetColTitle {

    public static String convertToTitle(int colNum){
        if(colNum == 0) return "";

        StringBuffer sb= new StringBuffer();

        while(colNum > 0){
            colNum--;
            char ch = (char)(colNum % 26 + 'A');
            colNum /= 26;
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        int colNumber = 28;
        System.out.println(convertToTitle(colNumber));
    }
}
