import collections 

def main(): 
    n = int(input())
    val =list('imrTu')    
    for i in range(n): 
        _, letter = input(), input()
        if len(letter) == len(val): 
            for item in val: 
                if item not in letter:
                    print(f'{item} NO')
                    return
            print("YES")
            return 
        print("NO")
        
        
if __name__ == '__main__': 
    main()
