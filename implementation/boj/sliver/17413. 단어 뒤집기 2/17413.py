string = input()
result = []
word = []
in_tag = False
for char in string:
    if char == '<':
        if word:
            result.append(''.join(reversed(word)))
            word.clear()
        in_tag = True
        result.append(char)  # '<'도 추가
    elif char == '>':
        in_tag = False  # 태그 종료
        result.append(char)
    elif in_tag:  # 태그 내부
        result.append(char)  # 태그 안의 내용은 그대로 추가
    elif char == ' ':
        result.append(''.join(reversed(word)))
        result.append(char)  # 공백도 추가
        word.clear()
    else:
        word.append(char)

if word:
    result.append(''.join(reversed(word)))

print(''.join(result))
