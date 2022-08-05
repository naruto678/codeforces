

def is_overlap(first_x, first_y, second_x, second_y):
    #print(first_x, first_y, second_x, second_y)
    if first_x >=second_x and first_y <=second_y: 
        return True
    return False


def main(): 
    n, m = map(int, input().split()) 
    ranges = []
    for i in range(m): 
        ranges.append(list(map(int, input().split())))
    ranges = sorted(ranges ,key = (lambda a:  a[0]))
    
    if len(ranges)==1: 
        print(ranges[0][1]-ranges[0][0]+1)
        return 

    start, end = ranges[0][0], ranges[0][1]

    for i in range(1, len(ranges)): 
        curr_start, curr_end = ranges[i][0], ranges[i][1]
        if curr_start > end or curr_end < start: 
            print(0)
            return
        else: 
            start = max(curr_start, start)
            end = min(curr_end, end)
    print(end-start+1)

if __name__ == "__main__":
    main()
