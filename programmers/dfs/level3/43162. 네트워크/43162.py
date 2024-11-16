def solution(n, computers):
    def dfs(i):
        visited[i] = True
        for j in range(n):
            if visited[j] == False and computers[i][j] == 1:
                dfs(j)

    answer = 0
    
    visited = [False] * n
    
    for i in range(n):
        if visited[i] == False:
            dfs(i)
            answer += 1
        
    
    return answer
