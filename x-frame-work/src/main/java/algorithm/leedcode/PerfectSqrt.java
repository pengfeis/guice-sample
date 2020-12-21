package algorithm.leedcode;

/**
 * @author supengfei
 */
public class PerfectSqrt {
    public static void main(String[] args) {
        PerfectSqrt p = new PerfectSqrt();
        int r = p.findPerfectSqrtCnt(15);
        System.out.println(r);
    }

    public int findPerfectSqrtCnt(int n) {

        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        for (int i = 0; i * i <= n; ++i) {
            int j = (int) Math.sqrt(n * 1.0 - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0) {
                    res += 1;
                }
                if (j > 0) {
                    res += 1;
                }
                return res;
            }
        }
        return 3;
    }

}
