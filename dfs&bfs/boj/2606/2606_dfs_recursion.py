import sys
sys.setrecursionlimit(10**4)

comp = int(input()) # 컴퓨터의 수
pair = int(input()) # 컴퓨터 쌍의 수
graph = [[] for i in range(comp+1)]
visited = [0]*(comp+1) # 방문 정보 표현할 리스트
answer = 0

for i in range(pair):
    a, b = map(int, input().split()) # 연결되어 있는 컴퓨터의 번호 쌍
    graph[a].append(b) # graph의 a번째 리스트에 b를 넣는 것으로 a와 b가 연결되어 있다는 것 표현
    graph[b].append(a) # 같은 방식으로 b의 입장에서도 a와 연결되어 있다는 것 표현

def dfs(i):
    global answer
    visited[i] = 1 # 방문 처리
    for j in graph[i]:
        if visited[j] == 0: # 방문하지 않은 노드인 경우
            dfs(j) # dfs 함수 호출
            answer += 1

dfs(1)
print(answer)
