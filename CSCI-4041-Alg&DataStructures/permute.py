#  PERMUTE. Print the N! permutations of N distinct elements.

def permute(N):
  A = []
  K = 1
  while K <= N:
    A = A + [K]
    K = K + 1
  permuting(A, 0)

#  PERMUTING. Do all the work for PERMUTE.

def permuting(A, I):
  if I < len(A):
    J = I
    while J < len(A):
      swap(A, I, J)
      permuting(A, I + 1)
      swap(A, I, J)
      J = J + 1
  else:
    print(A)

#  SWAP. Exchange the positions of elements at indexes I, J in A.

def swap(A, I, J):
  T = A[I]
  A[I] = A[J]
  A[J] = T
