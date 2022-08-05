def compute(n : int): 
    if n ==1: 
        return 2 
    if n ==2: 
        return 1; 
    if n ==3: 
        return 1 
    if n%3==0: 
        return n//3 
    else:  
        return n//3+1
    
def main(): 
    t = int(input())  
    for i in range(t):
        n = int(input())
        print(compute(n))

if __name__== '__main__':
    main()
