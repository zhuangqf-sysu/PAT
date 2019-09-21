import java.util.Scanner;

public class Main2 {

    private static int[] num = new int[100001];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=2;i<100001;i++) {
            if(num[i] > 0) {
                continue;
            }
            for(int j=1;j*i<100001;j++) {
                num[j*i]++;
                int k = j;
                while (k % i == 0) {
                    num[j*i]++;
                    k = k / i;
                }
            }
        }
        long ans = 0;
        for(int i=2;i<=n;i++) {
            ans += num[i];
        }
        System.out.println(ans);
    }

}
