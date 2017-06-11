def stringReplacement(baseString, ref1, ref2):
	if (baseString == None) | (baseString == ""):
		return ""

	if (len(baseString) < len(ref1)):
		return baseString

	if (baseString[:len(ref1)] == ref1):
		return ref2 + stringReplacement(baseString[len(ref1):], ref1, ref2)
	else:
		return baseString[0] + stringReplacement(baseString[1:], ref1, ref2)