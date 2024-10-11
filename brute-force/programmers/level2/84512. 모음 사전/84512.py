from itertools import product

def solution(word):
    answer = 0
    alphabets = ['A', 'E', 'I', 'O', 'U']
    words = []
    
    for i in range(1, 6):
        words.extend((map(''.join, product(alphabets, repeat = i))))
        
    words.sort()

    answer = words.index(word) + 1
          
    return answer
