#Nathan Comer

import functools
class Zillion():
	def __init__(self, digits):
		self.LID = []
		n=0
		while(n<len(digits)):
			if(digits[n].isdigit()):
				self.LID += [int(digits[n])]
				n+=1
			elif(digits[n] == ',' or digits[n]==' '):
				n+=1
			else:
				raise RuntimeError("String contains incompatible characters")
		
	def increment(self):
		n = len(self.LID)
		while(n>=0 and n<=len(self.LID)):
			if(self.LID[n-1] < 9):
				self.LID[n-1]+=1
				self.LID = self.LID[:(n)] + list(map((lambda x: x*0), self.LID[n:]))
				break
			elif(n == 0):
				self.LID=[1]+list(map(lambda x: x*0, self.LID))
				n-=1
			elif(self.LID[n-1] == 9):
				n-=1
				
	def isZero(self): #Reduce is not a built-in function in Python 3
		return functools.reduce(lambda x,y: x + y, self.LID, 0)==0
		
	def toString(self):
		n=0
		temp=""
		while(n<len(self.LID)):
			temp += str(self.LID[n])
			n+=1
		return temp

z=Zillion('999 999 999 999')
print(z.isZero())
p=1000
while(p>0):
	z.increment()
	print(z.toString())
	p-=1
print(z.toString())

