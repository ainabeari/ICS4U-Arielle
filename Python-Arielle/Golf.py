#Printing Golf Scores from an array 
#Arielle
#Friday May 25, 2018.

#ADDING ALL THE SCORES IN AN ARRAY
def addArray(data):
    ans = 0
    i = 0
    while i < len(data):
        ans += int(data[i])
        i += 1
    
    return ans

#GET MAX VAUE    
def getMax(data):
    checker = len(data)
    big = 0
    i = 0
    
    while i < len(data):
        checker -= 1
        c = 0
        while c <= checker:
            if int(data[c]) > int(data[big]):
                big = c
            c += 1
        i += 1
        
    return big

#variables
ans = 0
    
#input
i = 0
golf = []
while i < 18:
    print("Enter hole ", i + 1, ":")
    golf.append(int(input()))
    i += 1

i = 0
while i < 18:
    print("Hole ", i + 1, ": ", golf[i])
    i += 1 

print("Total score: ", addArray(golf))
print("Highest score: ", golf[getMax(data = golf)])     