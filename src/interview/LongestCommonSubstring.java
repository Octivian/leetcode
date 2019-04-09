package interview;

public class LongestCommonSubstring {
    int lcsForNum(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int m = a.length;
        int n = b.length;
        int[][] matrix = new int[m][n];
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == b[j]) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                    num = Math.max(matrix[i][j], num);
                }
            }
        }
        return num;
    }

    static String lcsForString(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        //TODO

        String r = new String();

        return r;
    }

    public static void main(String[] args) {
        System.out.println(lcsForString("qwertewgfvew", "gfdgtrertewgfqw"));
    }
}
