import numpy as np
from matplotlib import pyplot as plt

path = '../media/append.csv'

# title = 'Nanoseconds taken by appending on an Array and Linked list.'
# xlabel = r'$i^{th}$ append'
title = 'Nanoseconds taken by binary search on an Array and Linked list.'
xlabel = r'List Size $2^i$'

ylabel = 'Nanoseconds'
data = np.loadtxt(path, delimiter=',')
plt.title(title)
plt.xlabel(xlabel)
plt.ylabel(ylabel)
# data[1][data[1].argmax()] = data[1][0]
# plt.plot(data[0], label='ArrayList')
plt.plot(data[1], label='LinkedList')
plt.legend()
plt.show()
