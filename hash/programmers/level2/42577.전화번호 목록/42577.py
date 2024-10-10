def solution(phone_book):
    phone_map = {}
    # 전화번호를 해시맵에 저장
    for phone_number in phone_book:
        phone_map[phone_number] = 1  # 1은 임의의 값
    
    # 각 전화번호에 대해, 그 번호의 모든 가능한 접두어를 하나씩 만들어서 해시맵에 존재하는지 확인
    for phone_number in phone_book:
        prefix = ''
        for number in phone_number:
            prefix += number
            if prefix in phone_map and prefix != phone_number:  # 자신이 아닌 다른 전화번호의 접두어로 존재하는지 확인
                return False
    
    return True
