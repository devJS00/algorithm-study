import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) return cities.length * 5; // 캐시 크기가 0이면 전부 cache miss
        int time = 0;
        Queue<String> cache = new ArrayDeque<>();
        
        for (String city : cities) {
            city = city.toLowerCase(); 
            
            if (cache.contains(city)) { // Cache Hit
                // 최근 사용으로 갱신하기 위해 삭제 후 재삽입
                cache.remove(city); 
                cache.add(city);
                time += 1;
            } else { // Cache Miss
                if (cache.size() >= cacheSize) { // 캐시가 가득 찬 경우, 가장 오래된 항목 제거
                    cache.poll();
                }
                cache.add(city);
                time += 5;
            }
        }
        
        return time;
    }
}
