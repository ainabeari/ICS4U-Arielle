#Closer To Two
#Arielle
#Friday May 25, 2018

#Variables 
d = 1
num = 0
loopcount = 0

#Output
print ("This program will demonstrate the result of adding the numbers 1, 1/2, 1/4, 1/8, 1/16, \n ... and so on getting closer and closer to 2 without becoming 2.")
                
#Processing 
while num < 2.0:
                print (num , " + 1 /", d,  "=")
                num += 1.0/d
                print (num)
                d *= 2
                loopcount += 1
                
#Output (Loop counter)
print ("\nIt took " , loopcount , " times to get to 2.0")
