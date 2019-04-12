public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    if (n <= 0 || k <= 0) {
        return results;
    }
    combineHelper(n, k, 1, results, new ArrayList<Integer>());
    return results;
}

private void combineHelper (int n, int k, int st_num, List<List<Integer>> results, List<Integer> curSeq) {
    if (k == 0) {
        results.add(new ArrayList<Integer>(curSeq));
    }
    else {
        for (int i = st_num; i <= n; i++) {
            curSeq.add(i);
            combineHelper(n, k - 1, i + 1, results, curSeq);
            curSeq.remove(curSeq.size() - 1);
        }
    }
}
