class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            long index = left + i;  // 전체 배열에서의 위치 계산
            int row = (int) (index / n);
            int col = (int) (index % n);
            result[i] = Math.max(row, col) + 1;
        }
        return result;
    }
}
