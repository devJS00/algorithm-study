results = []

for test_case in range(1, 11):
    N = int(input())
    heights = list(map(int, input().split()))
    
    view_count = 0

    # 각 건물 검사 (맨 왼쪽 두 칸, 오른쪽 두 칸 제외)
    for i in range(2, N - 2):    
        max_neighbor_height = max(heights[i - 2], heights[i - 1], heights[i + 1], heights[i + 2])  # 왼쪽에 위치한 두 건물과 오른쪽에 위치한 두 건물의 높이 중 최댓값
       
        if heights[i] > max_neighbor_height:  # 현재 건물이 이들보다 높아야 조망권 확보 가능 
            view_count += heights[i] - max_neighbor_height  # 조망권 확보된 세대 수는 현재 높이에서 최대 이웃 높이를 뺀 값

    results.append(f"#{test_case} {view_count}")

print("\n".join(results))
