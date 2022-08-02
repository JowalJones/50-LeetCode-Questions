# *LeetCode 153
"""Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time."""


def findMin(nums):
    if len(nums) == 1:
        return 1
    left, right = 0, len(nums)-1
    while (left < right):
        mid = (left + right)//2
        if nums[mid] < nums[mid-1]:
            return nums[mid]
        if nums[mid] > nums[mid+1]:
            return nums[mid+1]
        if nums[mid] > nums[0]:
            left = mid+1
        if nums[mid] < nums[0]:
            right = mid-1

    return nums[0]


nums = [4, 5, 6, 7, 9, 20, 24, 2, 3]
mini = findMin(nums)

print(f"Minimum in sorted but rotated array {nums} is {mini}")
