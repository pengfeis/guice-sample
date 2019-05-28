package algorithm;

public class ReverseStr {


    /**
     * X^T = reverse X
     *
     * X = "abc", X^T = "cba"
     *
     * (X^TY^T)^T = YX
     * (cbazyx)^T = xyzabc
     * ab, cxyz --> cxyz, ab
     *
     * @param input
     * @return
     */



    public char[] reverse(char[] input, int f, int t) {
        while (f < t) {
            char x = input[f];
            input[f++] = input[t];
            input[t--] = x;
        }




        return input;
    }

    void leftRotateString(char[] s,int n,int m) {
        m %= n;               //若要左移动大于n位，那么和%n 是等价的
        reverse(s, 0, m - 1); //反转[0..m - 1]，套用到上面举的例子中，就是X->X^T，即 abc->cba
        reverse(s, m, n - 1); //反转[m..n - 1]，例如Y->Y^T，即 def->fed
        reverse(s, 0, n - 1); //反转[0..n - 1]，即如整个反转，(X^TY^T)^T=YX，即 cbafed->defabc。
    }


    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();


        char[] input = {'a', 'b', 'c', 'd', 'e', 'f'};
        reverseStr.leftRotateString(input, 6, 4);
        for (char c : input) {
            System.out.println(c);
        }

    }
}
