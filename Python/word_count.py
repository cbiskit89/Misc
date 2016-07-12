#!/usr/bin/python2.7
import operator
import re
import sys

filename = sys.argv[1]
f = open(filename)

words = {}

for line in f:
  for word in line.split():
    regex_return = re.search('[a-z\-\']+', word.lower())
    if regex_return:
      regex_word = regex_return.group(0)
      if not regex_word in words:
        words[regex_word] = 0
      words[regex_word] += 1

# This is how you'd sort a dictionary by converting to a list of tuples then
# sorting a copy of the list. (Better for sorting a dict)
print sorted(words.items(), key=operator.itemgetter(1), reverse=True)[:10]

# This is how you'd sort a dictionary by converting to list of tuples then
# sorting the list in place. (Better for sorting a list)
test = words.items()
test.sort(key=operator.itemgetter(1), reverse=True)
print test[:10]
