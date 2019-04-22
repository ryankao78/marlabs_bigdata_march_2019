public List<Integer> findAnagrams(String s, String p) {
    ArrayList<Integer> ans = new ArrayList<>();
    int[] vs = new int[26];
    int[] vp = new int[26];

    for (int i = 0; i < p.length(); i++) {
        vp[p.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
        if (i >= p.length()) {
            vs[s.charAt(i - p.length()) - 'a']--;
        }
        vs[s.charAt(i) - 'a']++;
        if (Arrays.equals(vs, vp)) {
            ans.add(i + 1 - p.length());
        }
    }
    return ans;
}
