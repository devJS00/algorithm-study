def solution(clothes):
    answer = 1 
    clothes_map = {}
    for c in clothes:
        if c[1] in clothes_map:
            clothes_map[c[1]].append(c[0])  # 같은 종류의 옷은 리스트에 추가
        else:
            clothes_map[c[1]] = [c[0]]  # 새로운 종류는 추가
            
    # 각 종류의 옷 개수 + 1 (입지 않는 경우)를 곱하며 조합의 수를 구함
    for key in clothes_map:
        answer *= (len(clothes_map[key]) + 1)
    
    # 모든 옷을 안 입는 경우를 제외
    answer -= 1
    
    return answer
