n = int(input())  # 단어의 개수
words = [input() for _ in range(n)]  # N개의 단어 입력

selected = []


def anagrams(word, visited):
    global selected
    if len(selected) == len(word):
        print(''.join(map(str, selected)))
        return

    prev = ''

    for i in range(len(word)):
        if word[i] != prev and not visited[i]:
            visited[i] = True
            selected.append(word[i])
            anagrams(word, visited)
            prev = selected.pop()
            visited[i] = False


for i in range(n):
    v = [False] * len(words[i])
    anagrams(sorted(words[i]), v)
