from unittest import TestCase

import sort.solution


class TestSolution(TestCase):
    sol = sort.solution.Solution()

    def test_partition(self):
        arr = [3, 1]
        self.sol.quick_sort(arr)
        print(arr)

    def test_bubble_sort(self):
        arr = [3, 1,2,0,4]
        self.sol.bubble_sort(arr)
        print(arr)

