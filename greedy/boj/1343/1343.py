def solution(str):
    asw = ''
    splited = str.split('.') # '.'을 기준으로 split
    for i in range(len(splited)):
        if len(splited[i]) % 2 == 0: # 문자열의 길이가 짝수면
            for j in range(len(splited[i]) // 4): # 'AAAA'를 넣을 수 있는 만큼 넣기
                asw += 'AAAA'
            for k in range(len(splited[i]) % 4 // 2): # 들어갈 자리가 있으면 'BB' 넣기
                asw += 'BB'
            if i != len(splited)-1:
                asw += '.'
        else: # 문자열들 중 하나라도 길이가 홀수면 덮을 수 없음
            print(-1)
            return
    print(asw)

str = input()
solution(str)
