package algo.strings;

public class KMPPatternMatching {

    private static void patternSearch(String pat, String txt) {
        int lps[] = computeLPSArray(pat);
        int txtIndex = 0, patIndex = 0;
        while (txtIndex < txt.length()) {
            if (pat.charAt(patIndex) == txt.charAt(txtIndex)) {
                patIndex++;
                txtIndex++;
            }
            if (patIndex == pat.length()) {
                System.out.println("Found pattern at index " + (txtIndex - patIndex));
                patIndex = lps[patIndex - 1];
            } else if (txtIndex < txt.length() && pat.charAt(patIndex) != txt.charAt(txtIndex)) {
                if (patIndex != 0) {
                    patIndex = lps[patIndex - 1];
                } else {
                    txtIndex = txtIndex + 1;
                }
            }
        }
    }

    private static int[] computeLPSArray(String pat) {
        int lps[] = new int[pat.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = len;
                i++;
            }
        }
        return lps;
    }

    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        patternSearch(pat, txt);
    }
}


