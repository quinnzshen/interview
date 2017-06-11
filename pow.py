# LinkedIn Smokescreen

# Implement the python pow function, pow(base, exp) returns base to the power exp.

## EXAMPLES ##
# pow(2,3) -> 2^3 -> 2 * 2 * 2 = 8

def pow(base, exp):
	# Your code here.
	pass

## POTENTIAL EDGE CASES ##
# pow(0,0) -> 0^0 = 1 (according to python)
# pow(4,0) -> 4^0 = 1
# pow(2,-3) -> 2^(-3) -> 1/(2^3) -> 1/(2 * 2 * 2) = 1/8 = 0.125

## MY SOLUTION ##
# def pow(base, exp):
# 	if exp == 0:
# 		return 1
# 	elif exp < 0:
# 		return 1.0/pow(base, -exp) 
# 	result = 1
# 	for _ in xrange(exp):
# 		result *= base
# 	return result