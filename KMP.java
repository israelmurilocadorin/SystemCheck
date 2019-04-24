class KMP {
    private String pat;
    private String txt = "oi xau oi xauxau oi j";
    private int lps[];
    private int len = 0;
    private int i = 1;
    private int m;

    public KMP(String pat) {
        this.pat = pat;
    }

    public void KMPSearch() {
        int m = pat.length();
        int n = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[m];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)

        int i = 0; // index for txt[]
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            } if (j == m) {
                System.out.println("Palavra/letra encontrada na posição: " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    public void computeLPSArray() {
        // length of the previous longest prefix suffix 
        // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < this.m) {
            if (this.pat.charAt(i) == this.pat.charAt(this.len)) {
                len++;
                this.lps[i] = this.len;
                i++;
            } else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (this.len != 0) {
                    this.len = this.lps[this.len - 1];

                    // Also, note that we do not increment
                    // i here
                } else {
                    this.lps[i] = this.len;
                    i++;
                }
            }
        }
    }

    public void retornar() {
        KMPSearch();
        computeLPSArray();
    }
}