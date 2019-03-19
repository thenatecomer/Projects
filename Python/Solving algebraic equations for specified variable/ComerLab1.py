#Nathan Comer
import sys

def left(e):
	return e[0]
	
def op(e):
	return e[1]
	
def right(e):
	return e[2]
	
def isInside(v, e):
	for p in e:
		if p == v:
			return True
		if isinstance(p,list):
			if isInside(v, p) is True:
				return True
	return False
	
def solve(v, q):
	if(isInside(v,left(q))):
		return solving(v, q)
	elif(isInside(v,right(q))):
		e=[right(q),op(q),left(q)]
		return solving(v,e)
	else:
		return None
			
def solving(v, q):
	if v is left(q):
		return q
	elif(op(left(q))=='+'):
		return solvingAdd(v,q)
	elif(op(left(q))=='-'):
		return solvingSubtract(v,q)
	elif(op(left(q))=='*'):
		return solvingMultiply(v,q)
	elif(op(left(q))=='/'):
		return solvingDivide(v,q)
	
def solvingAdd(v, q):
	if(isInside(v,left(q[0]))):
		f=[right(q),'-',right(q[0])]
		return solving(v,[left(q[0]),op(q),f])
	elif(isInside(v,right(q[0]))):
		f=[right(q),'-',left(q[0])]
		return solving(v,[right(q[0]),op(q),f])
		
def solvingSubtract(v, q):
	if(isInside(v,left(q[0]))):
		f=[right(q),'+',right(q[0])]
		return solving(v,[left(q[0]),op(q),f])
	elif(isInside(v,right(q[0]))):
		f=[left(q[0]),'-',right(q)]
		return solving(v,[right(q[0]),op(q),f])
		
def solvingMultiply(v, q):
	if(isInside(v,left(q[0]))):
		f=[right(q),'/',right(q[0])]
		return solving(v,[left(q[0]),op(q),f])
	elif(isInside(v,right(q[0]))):
		f=[right(q),'/',left(q[0])]
		return solving(v,[right(q[0]),op(q),f])
		
def solvingDivide(v, q):
	if(isInside(v,left(q[0]))):
		f=[right(q),'*',right(q[0])]
		return solving(v,[left(q[0]),op(q),f])
	elif(isInside(v,right(q[0]))):
		f=[left(q[0]),'/',right(q)]
		return solving(v,[right(q[0]),op(q),f])

#Test Cases:

print(isInside('x', 'x'))                           #  True
print(isInside('x', 'y') )                          #  False
print(isInside('x', ['x', '+', 'y']))               #  True
print(isInside('x', ['a', '+', 'b']) )              #  False
print(isInside('x', [['m', '*', 'x'], '+', 'b']))   #  True

print(solve('x', [['a', '+', 'x'], '=', 'c']))   #  ['x', '=', ['c', '-', 'a']]
print(solve('x', [['x', '+', 'b'], '=', 'c']))   #  ['x', '=', ['c', '-', 'b']]

print(solve('x', [['a', '-', 'x'], '=', 'c']))   #  ['x', '=', ['a', '-', 'c']]
print(solve('x', [['x', '-', 'b'], '=', 'c']))   #  ['x', '=', ['c', '+', 'b']]

print(solve('x', [['a', '*', 'x'], '=', 'c']))   #  ['x', '=', ['c', '/', 'a']]
print(solve('x', [['x', '*', 'b'], '=', 'c']))   #  ['x', '=', ['c', '/', 'b']]

print(solve('x', [['a', '/', 'x'], '=', 'c']))   #  ['x', '=', ['a', '/', 'c']]
print(solve('x', [['x', '/', 'b'], '=', 'c']))   #  ['x', '=', ['c', '*', 'b']]

print(solve('x', ['y', '=', [['m', '*', 'x'], '+', 'b']])) 
# ['x', '=', [['y', '-', 'b'], '/', 'm']
