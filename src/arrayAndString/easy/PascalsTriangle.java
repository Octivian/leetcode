package arrayAndString.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> r = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> t = new ArrayList<>();
                if (i == 0) {
                    t.add(1);
                    r.add(t);
                } else {
                    for (int j = 0; j < i + 1; j++) {
                        if (j == 0 || j == i) {
                            t.add(1);
                        } else {
                            List<Integer> t1 = r.get(i - 1);
                            t.add(t1.get(j - 1) + t1.get(j));
                        }
                    }
                    r.add(t);
                }
            }
            return r;
        }
    }
}
