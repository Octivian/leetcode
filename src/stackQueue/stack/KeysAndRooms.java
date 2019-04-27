package stackQueue.stack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Set<Integer> set = new HashSet<Integer>();
            set.add(0);
            DFS(rooms, rooms.get(0), set);

            return set.size() == rooms.size();
        }

        private void DFS(List<List<Integer>> rooms, List<Integer> keys, Set<Integer> set) {
            if (set.size() == rooms.size()) {
                return;
            }

            for (int i = 0; i < keys.size(); i++) {
                if (!set.contains(keys.get(i))) {
                    set.add(keys.get(i));
                    DFS(rooms, rooms.get(keys.get(i)), set);
                }
            }
        }
    }


}
