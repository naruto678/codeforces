import math 
def main():
    t = int(input())
    for i in range(t):
        n, H, M = list(map(int, input().split()))
        total_mins = 1500  
        for j in range(n):
            h,m = list(map(int, input().split()))
            total_mins = min(total_mins, compute_mins(H, M, h,m))
        total_hours = math.floor(total_mins//60) 
        total_mins = total_mins%60
        print(f'{total_hours} {total_mins}')
        
def compute_mins(H: int, M:int, h:int, m:int)->int:
    #print(f'Got this {H} {M} {h} {m}')
    sleep_time = H*60+M
    alarm_time = h*60+m

    if alarm_time >= sleep_time: 
        return alarm_time-sleep_time 
    else: 
        return (24*60-sleep_time)+alarm_time
        

if __name__ == '__main__':
    main()

