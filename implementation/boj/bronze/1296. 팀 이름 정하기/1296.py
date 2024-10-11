# 입력 받기
yd_name = input().strip()  # 연두의 이름
n = int(input())  # 팀 이름 후보의 수
team_names = [input().strip() for _ in range(n)]  # 팀 이름 목록


# L, O, V, E의 개수를 세는 함수
def count_love(name):
    L = name.count('L')
    O = name.count('O')
    V = name.count('V')
    E = name.count('E')
    return L, O, V, E


# 연두 이름에서 L, O, V, E의 개수를 먼저 구해놓음
L_yd, O_yd, V_yd, E_yd = count_love(yd_name)

max_score = -1
answer = ""

for team_name in team_names:
    L_team, O_team, V_team, E_team = count_love(team_name)

    # 합친 이름의 L, O, V, E 개수
    L = L_yd + L_team
    O = O_yd + O_team
    V = V_yd + V_team
    E = E_yd + E_team

    score = ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100

    if score > max_score:
        max_score = score
        answer = team_name
    elif score == max_score:
        # 확률이 같으면 사전순으로 앞서는 팀을 선택
        if team_name < answer:
            answer = team_name

# 결과 출력
print(answer)
