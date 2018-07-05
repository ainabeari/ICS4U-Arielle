#Making an object using OOP
#Saturday May 26, 2018.
#Arielle

class Test:
    #Emoty constructor/ initializer
    #note in python there is always one argument, the object (self/var)
    def __init__(self):
        self.grade = 100
        self.student = "Bob"
        self.subject = "Notinputted"
    
    #Getters (but with Python since there aren't any private variables you can just call it without a getter
    def getGrade(self):
        return self.grade
    def getStudent(self):
        return self.student
    def getSubject(self):
        return self.subject
    
    #Setters
    def setGrade(self, grade):
        self.grade = grade
    def setStudent(me, student):
        me.student = student
    def setSubject(self, subject):
        self.subject = subject
        
    #Pass or Fail
    def status(self):
        if self.grade < 50:
            return "Fail"
        elif self.grade > 94:
            return "Pass - by Ellie's standards"
        else:
            return "Pass... barely"
        
    #ToString()
    def toString(self):
        return "Student: " + self.student + " Subject: " + self.subject + " Grade: " + str(self.grade) + " Pass? " + self.status()
   
#Client Code        
t = Test()

#Setting all behaviours
t.setStudent("Ellie")
t.setSubject("Computer Science")
t.setGrade(95)

#Printing object's behaviours
print(t.toString())
        