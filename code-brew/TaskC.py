

from array import array 

def main(): 
    n = int(input())
    if n==0: 
        print("YES")
        return 
    arr = sorted(array('i', map(int, input().split())))
    
    if len(arr)==1: 
        if arr[0] <2: 
            print("YES")
            return 
        else: 
            print("NO")
            return 
    
    for i in range(1,len(arr)): 
        if abs(arr[i]-arr[i-1]) >2: 
            print("NO")
            return 
    print("YES")

if __name__ == "__main__":
    main()
