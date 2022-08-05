

from array import array 

def compute_sum(arr, idx, step, comp_index): 
    curr_sum = arr[idx]
    comp_index.add(idx)
    count = 1
    start_idx = (idx+step) % len(arr)
    while start_idx!=idx:
        curr_sum += arr[start_idx]
        count += 1
        comp_index.add(start_idx)
        start_idx = (start_idx+ step)%len(arr)
    if count * step !=len(arr): 
        return 10**9 
    return curr_sum 

def main(): 
    N, K = map(int, input().split())
    arr = array('i',map(int, input().split()))
    if K==1: 
        print(sum(arr))
        return 

    min_val = sum(arr)
    comp_index = set()
    for i in range(len(arr)): 
        if i not in comp_index: 
            min_val = min(compute_sum(arr, i, K, comp_index), min_val)
    print(min_val)



if __name__ == "__main__":
    main()

