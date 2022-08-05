from array import array 
import math 
def main():
    arr = array('i', map(int, input().split()))
    print(math.ceil(arr[0]/arr[1]))


if __name__ == "__main__":
    main()
