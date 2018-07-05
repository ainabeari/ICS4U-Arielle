#Standard Time
#Arielle
#Friday May 25, 2018


def convertToTraditional (time):
    resultH = int(time[0:2])
    resultM = int(time[3:5])
    
    if resultM > 59 or resultM < 0 or resultH > 23 or resultH < 1:
                return "ERROR INVALID TIME, PLEASE TRY AGAIN."
    if resultH > 12:
        resultH -= 12
    result =  str(resultH)
    result += ":"
    result += str(resultM)
    
    return result

def convertToStandard(time):
    resultH = int(time[0:2])
    resultM = int(time[3:5])
    m = time[5:7]
    if resultM > 59 or resultM < 0 or resultH > 12 or resultH < 1:
                return ("ERROR INVALID TIME, PLEASE TRY AGAIN.")
    else:
        if m == "pm":
            if resultH == 12:
                resultH == 12
            else: 
                resultH += 12
    
        elif resultH == 12:
            resultH = 0
         
    result =  str(resultH)
    result += ":"
    result += str(resultM)
    return result
        
        
 
choice = input("Input 1 to convert to standard and anything else to convert to traditional: ")
if choice == str(1):
    print("Inputted time must have this format: 00:00xx")
    answer = input("Enter time using above format: ")
    print (convertToStandard (time = answer))
else:
    print ("Inputted time must have this form 00:00")
    answer = input("Enter time using above format: ")
    print (convertToTraditional (time = answer))    
