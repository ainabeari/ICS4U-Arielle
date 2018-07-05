#Acid Rain
#Arielle
#Friday May 25, 2018

#Info
print ("ACID RAIN")
print ("Acid rain is a danger for ecosystems, they can kill the wildlife living in them.\n This program will determine if the pH level entered for water is safe for fish to live in. \n ")

#Input
pH = int(input("Enter pH: "))
print ("The pH you entered was ", pH)

#Conditions
if pH < 0 or pH > 14:
    print ("ERROR BAD DATA, PLEASE TRY AGAIN.")
    print ("Remember pH is on a scale from 0 - 14 (inclusive)")

elif pH > 7.45:
    print ("TOO ALKALINE - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE.")

elif pH < 6.45:
    print("TOO ACIDIC - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE.")

else:
    print("NEUTRAL - FISH IN STREAMS, RIVERS AND LAKES WILL SURVIVE.")
