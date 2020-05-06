package SemesterWork3;

public class KMPAlgorithm {

    public static int[] prefixFunction(String s) {
        int n = s.length();
        int[] pr = new int[n];
        for (int i = 1; i < n; i++) {
            int k = pr[i - 1];
            while (k > 0 && s.charAt(k) != s.charAt(i))
                k = pr[k - 1];
            if (s.charAt(k) == s.charAt(i))
                pr[i] = k + 1;
            else
                pr[i] = 0;
        }
        return pr;
    }

    public static int findIndex(String text, String pattern) {
        int nope = -1;
        int[] pf = prefixFunction(pattern);
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            while (index != 0 && pattern.charAt(index) != text.charAt(i))
                index = pf[index - 1];
            if (pattern.charAt(index) == text.charAt(i))
                index++;
            if (index == pattern.length())
                return i - index + 1;
        }
        return nope;
    }
}
