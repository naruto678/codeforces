
def compute(k: int): 
    n = 10000 
    ans = 0 
    for i in range(1, n): 
        if i*(i+1) > 2*k:
            return ans
        else: 
            ans = i
    return ans 


def main(): 
    t = int(input())
    for i in range(t): 
        print(compute(int(input())))

if __name__ == "__main__":
    main()


