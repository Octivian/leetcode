package stack;

public class FloodFill {
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] != newColor) {
                DFS(image, sr, sc, image[sr][sc], newColor);
            }

            return image;
        }

        private void DFS(int[][] image, int sr, int sc, int old, int newColor) {
            int h = image.length;
            int v = image[0].length;

            if (sr >= 0 && sr < h && sc >= 0 && sc < v && image[sr][sc] == old) {
                image[sr][sc] = newColor;
                DFS(image, sr + 1, sc, old, newColor);
                DFS(image, sr, sc + 1, old, newColor);
                DFS(image, sr - 1, sc, old, newColor);
                DFS(image, sr, sc - 1, old, newColor);
            }
        }
    }
}
