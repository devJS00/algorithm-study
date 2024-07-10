import sys
sys.setrecursionlimit(10**6)

def dfs(v):
    for i in tree[v]:
        if parent[i] == 0:
            parent[i] = v
            dfs(i)

num = int(sys.stdin.readline()) # 노드의 개수
tree = [[] for i in range(num+1)]
parent = [0]*(num+1)
    
for i in range(num-1):
    a, b = map(int, input().split()) 
    tree[a].append(b) # graph의 a번째 리스트에 b를 넣는 것으로 a와 b가 연결되어 있다는 것 표현
    tree[b].append(a) # 같은 방식으로 b의 입장에서도 a와 연결되어 있다는 것 표현

dfs(1)

for i in range(2, num + 1):
    print(parent[i])
