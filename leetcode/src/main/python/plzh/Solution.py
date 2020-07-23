from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        """
        排列组合，回溯法
        :param candidates:
        :param target:
        :return:
        """

        res: List[List[int]] = []
        cur: List[int] = []
        candidates.sort()
        self._combinationSum2(0, target, candidates, cur, res)
        return res

    def _combinationSum2(self, i: int, left: int, candidates: List[int], cur: List[int], res: List[List[int]]):
        if left == 0:
            res.append(cur.copy())
            return
        for j in range(i, len(candidates)):
            if (j == i or candidates[j] != candidates[j - 1]) and candidates[j] <= left:
                cur.append(candidates[j])
                self._combinationSum2(j + 1, left - candidates[j], candidates, cur, res)
                cur.pop()
            elif candidates[j] > left:
                # prune
                break

    def sortByOneSwap(self, arr):
        idx1 = len(arr) - 1
        while arr[idx1] >= arr[idx1 - 1]:
            idx1 -= 1
        idx2 = idx1 - 1
        while arr[idx2] >= arr[idx2 - 1]:
            idx2 -= 1
        # assert idx2 > 0
        arr[idx1], arr[idx2 - 1] = arr[idx2 - 1], arr[idx1]
        return arr
