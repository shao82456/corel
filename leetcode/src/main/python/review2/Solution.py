from typing import List


class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        total = len(nums1) + len(nums2)
        if total == 0:
            return 0
        p1, p2 = -1, -1
        last = -1
        for i in range(0, int(total / 2) + 1):
            if p1 + 1 == len(nums1):
                p2 = p2 + 1
                last = 2
            elif p2 + 1 == len(nums2):
                p1 = p1 + 1
                last = 1
            elif nums1[p1 + 1] <= nums2[p2 + 1]:
                p1 = p1 + 1
                last = 1
            else:
                p2 = p2 + 1
                last = 2

        if total % 2 != 0:
            # 总数奇数时，选最后一个遍历的数
            return nums1[p1] if last == 1 else nums2[p2]
        else:
            # 偶数时,last停留在右半部分，此时需要从左半部分再选一个
            if last == 1:
                if p2 == -1:
                    left = nums1[p1 - 1]
                else:
                    left = max(nums1[p1 - 1], nums2[p2]) if p1 - 1 >= 0 else nums2[p2]
                return (nums1[p1] + left) / 2
            else:
                if p1 == -1:
                    left = nums2[p2 - 1]
                else:
                    left = max(nums2[p2 - 1], nums1[p1]) if p2 - 1 >= 0 else nums1[p1]
                return (nums2[p2] + left) / 2


if __name__ == '__main__':
    # res = findMedianSortedArrays([1, 3, 5], [2, 4, 7, 8])
    res = 1
    print(res)

    sol = Solution()
    res = sol.findMedianSortedArrays([1, 2], [3, 4])
    print(res)
