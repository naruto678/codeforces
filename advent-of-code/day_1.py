


def main():
    arr =[] 
    with open('input.txt', 'r') as file:
        curr_sum = 0
        for line in file.readlines():
            if len(line.strip()) > 0: 
                curr_sum+=int(line)
            else:
                arr.append(curr_sum)  
                curr_sum = 0 
    arr = sorted(arr) 
    print(arr[-1]+arr[-2]+arr[-3])

if __name__ == '__main__': 
    main()
