package arrayAndString.array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i <= rowIndex; i++) {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        list1.add(1);
                    } else if (j == i) {
                        list1.add(1);
                    } else {
                        list1.add(list2.get(j - 1) + list2.get(j));
                    }
                }
                list2.clear();
                list2.addAll(list1);
                list1.clear();
            }
            return list2;
        }
    }
}
