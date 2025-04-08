def solution(N, colors):
    red_blocks = 0
    blue_blocks = 0

    if colors[0] == "R":
        red_blocks += 1
    else:
        blue_blocks += 1

    for i in range(1, N):
        if colors[i] != colors[i - 1]:
            if colors[i] == "R":
                red_blocks += 1
            elif colors[i] == "B":
                blue_blocks += 1

    return min(red_blocks, blue_blocks) + 1


# 입출력
N = int(input())
colors = input().strip()
print(solution(N, colors))
