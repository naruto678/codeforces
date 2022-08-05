
from array import array 

def compute_val(arr:array)->int:
    val_dict = dict()
    max_val = -1
    for i in reversed(range(len(arr))):
        index_val = val_dict.get(arr[i], -1)
        if index_val==-1: 
            #print("i am in the if blok")
            val_dict[arr[i]] = i  
        else:
            #print("I am in the else block")
            max_val = max(max_val, i)
    return max_val+1

def main(): 
    t = int(input())
    for i in range(t):
        n = input()
        arr = array('i', map(int, input().split()))
        print(compute_val(arr))




if __name__== '__main__':
    main()
