from itertools import permutations

def solution(k, dungeons):
    answer = -1
    routes = list(permutations(dungeons))  # 던전들의 순서를 고려해야 하기 때문에 순열을 사용
    for route in routes:
        current_k = k  # 현재 피로도. 탐험할 때마다 갱신
        count = 0
        for r in route:
            if r[0] <= current_k:
                current_k -= r[1]  # 던전을 탐험하면 소모 피로도만큼 현재 피로도 감소
                count += 1
        if count > answer:  
            answer = count
    return answer
