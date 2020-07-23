from typing import List


class Solution:
    def quick_sort(self, nums: List[int]):
        self._quick_sort(0, len(nums) - 1, nums)

    def _quick_sort(self, l, r, nums: List[int]):
        if l < r:
            m = self.partition(l, r, nums)
            self._quick_sort(l, m - 1, nums)
            self._quick_sort(m + 1, r, nums)

    def partition(self, l, r, nums: List[int]) -> int:
        pivot = nums[l]
        # nums[i,j]<key, nums[j+1,k-1]>key
        i, j = l + 1, l
        for k in range(l + 1, r + 1, 1):
            if nums[k] < pivot:
                self.swap(j + 1, k, nums)
                j += 1
        self.swap(l, j, nums)
        j -= 1
        return j + 1

    def swap(self, i, j, nums: List[int]):
        backup = nums[i]
        nums[i] = nums[j]
        nums[j] = backup

    def bubble_sort(self, nums: List[int]):
        n = len(nums)
        if n <= 1:
            return
        sorted = False
        for b in range(n - 1, 0, -1):
            if sorted:
                return
            sorted = True
            for i in range(0, b, 1):
                if nums[i] > nums[i + 1]:
                    sorted = False
                    self.swap(i, i + 1, nums)
