


def compute_part_1(): 
    total_score = 0
    score = {'A': 1, 'B': 2 ,'C': 3, 'X': 1, 'Y': 2, 'Z': 3}
    rock  = set(['A', 'X'])
    paper = set(['B', 'Y'])
    scissor = set(['C', 'Z'])

    with open('inputs/day_2.txt', 'r') as file: 
        for line in file.readlines():
            first, second = line.strip().split(' ') 
            if score[first] == score[second]: # draw here 
                total_score+=3+score[second]

            elif second in rock and first in scissor: # won
                total_score+=6+score[second]
            elif second in scissor and first in paper: #won
                total_score+=6+score[second]
            elif second in paper and first in rock: #won
                total_score+=6+score[second]
            else: 
                total_score+=score[second] #won


    print(total_score) 

def compute_part_2(): 
    total_score = 0
    score = {'A': 1, 'B': 2 ,'C': 3}
    rock, paper, scissor = 'A', 'B', 'C'

    with open('inputs/day_2.txt', 'r') as file: 
        for line in file.readlines(): 
            first , second = line.strip().split(' ')
            
            if second =='Z': # need to win  
                if first == rock: total_score+=6+score[paper]
                elif first == paper : total_score += 6+score[scissor]
                elif first == scissor : total_score += 6+score[rock]
            if second =='Y': #need to draw
                total_score+=3+score[first]
            elif second == 'X': 
                if first == rock: total_score += score[scissor]
                elif first == paper: total_score +=score[rock] 
                elif first == scissor : total_score +=score[paper]



        print(total_score) 





def main(): 
   compute_part_1()
   compute_part_2()

if __name__=='__main__': 
    main()
