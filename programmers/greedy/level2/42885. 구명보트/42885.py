# 가장 무거운 사람과 가장 가벼운 사람을 묶어야 보트를 최소로 사용할 수 있다는 것이 핵심 아이디어 

def solution(people, limit):
    answer = 0
    start = 0 
    end = len(people)-1
    people.sort()
    while start < end:
        if people[start] + people[end] > limit:
            end -= 1
        elif people[start] + people[end] <= limit: 
            start += 1
            end -= 1
        answer += 1
    
    if start == end:
        answer += 1
            
    return answer
