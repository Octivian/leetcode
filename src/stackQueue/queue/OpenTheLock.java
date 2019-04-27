package stackQueue.queue;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    /**
     * BFS Solution, so slow
     */
    class Solution {
        public int openLock(String[] deadends, String target) {

            return BFS(deadends, target);
        }

        private int BFS(String[] deadends, String target) {
            Set<String> deadendsSet = new HashSet<>();

            for (String deadend : deadends) {
                deadendsSet.add(deadend);
            }

            int step = 0;

            Queue<String> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            q.offer("0000");
            visited.add("0000");


            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    String poll = q.poll();
                    if (poll.equals(target)) {
                        return step;
                    }

                    if (deadendsSet.contains(poll)) {
                        continue;
                    } else {
                        String[] neis = nei(poll);
                        for (String nei : neis) {
                            if (!visited.contains(nei)) {
                                System.out.println(nei);
                                q.offer(nei);
                                visited.add(nei);
                            }

                        }
                    }
                }
                step++;
            }
            return -1;
        }

        private String[] nei(String target) {
            String[] neis = new String[8];
            char[] chars = target.toCharArray();
            for (int i = 0; i < 4; i++) {

                StringBuilder sb = new StringBuilder(target);
                sb.setCharAt(i, Character.forDigit((Character.getNumericValue(chars[i]) + 10 - 1) % 10, 10));
                neis[i] = sb.toString();

                sb.setCharAt(i, Character.forDigit((Character.getNumericValue(chars[i]) + 10 + 1) % 10, 10));
                neis[i + 4] = sb.toString();
            }
            return neis;
        }
    }

    public static void main(String[] args) {
//        Arrays.stream(Solution.nei("0000")).forEach(x -> System.out.println(x));
//        System.out.println(Character.getNumericValue('0') + 10 - 1);
    }
}
