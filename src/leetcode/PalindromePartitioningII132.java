package leetcode;

/**
 * @author zhuangqf
 * @date 2018/1/29
 */
public class PalindromePartitioningII132 {

    private String s;
    private int f[][] = new int[1000][1000];

    public int minCut(String s) {
        this.s = s;
        for(int t=0;t<=s.length();t++){
            for(int i=0,j=t;j<s.length();i++,j++){
                f[i][j] = compCut(i,j);
            }
        }
        return f[0][s.length()-1];
    }

    public int compCut(int i,int j) {
        if(isPalindrome(i,j)) return 0;
        int min = s.length();
        for(int p=i;p<j;p++) {
            int a = f[i][p];
            int b = f[p+1][j];
            a = a + b + 1;
            min = min<a?min:a;
        }
        return min;
    }

    public boolean isPalindrome(int i,int j){
        while(i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] arg) {
        PalindromePartitioningII132 app = new PalindromePartitioningII132();
        System.out.println( app.minCut("leet") );
    }



}
