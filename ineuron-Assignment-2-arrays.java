Q1.     Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

Example 1:
Input: nums = [1,4,3,2]
Output: 4

Explanation:All possible pairings (ignoring the ordering of elements) are:

1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4

Solution:- 
    
Java Code

class Solution {
    
    /*
    
        Problem: the problem is asking us to group the integers in the given array into pairs such that the sum of minimum of each pair is maximized.
        
        we need to find a way to arrange pairs to maximize the sum of the minimum of each pair
        
        Brute force: Generate all possible pairs and calculate the sum of the minimum of each pair. Then we choose the combination that has a maximum sum.
        This approach has a time complexity of O(n!) and it is not efficient for large values of n.
            time complexity of O(n!) - this is generally associated with algorithms that involve generating all possible permutations of a set of n elements. This time complexity means that algorithm's running time grows factorially with the input size, which can quickly become feasible for large values of n.
            For example: if n = 10, then n!= 3,628,800
            inefficient and whenever possible try to find more efficient algorithms than n!
            
        Optimized solution: sort the array in non decreasing order and group each consecutive pair. The sum of the minimum each pair would be the sum of the od-indexed elements in sorted array. Since we are only interested in the sum of the minimum of each pair, we do not need to consider the second largest element in each pair. 
        Time complexity O(n log n) due to the sorting step.
        Space complexity O(1)
        
    */
    
    public int arrayPairSum(int[] nums) {
        
        // sort the array in ascending order
        Arrays.sort(nums);
        int sum = 0;
        
        // iterate over the array in step of 2, and add the minimum element of each pair to the sum
        for (int i = 0; i < nums.length; i += 2)
            sum+= nums[i];
        
        return sum;
    }
}

Complexity
Time complexity: O(n log n)
Space complexity: O(1)

Q2.       
Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor. 

The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice. 

Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

Example 1:
Input: candyType = [1,1,2,2,3,3]
Output: 3

Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.

Solution:-  Approach 1: Brute Force
Intuition and Algorithm

One way to find the number of unique candies is to traverse over each element in candyType, checking whether or not we've already seen a candy of this same type. We can do this check by iterating over all elements before the current element. If any of those are of the same type, then this is not a unique candy. We should keep track of the number of unique candies we find.
    
 class Solution {
    public int distributeCandies(int[] candyType) {
        // Initiate a variable to count how many unique candies are in the array.
        int uniqueCandies = 0;
        // For each candy, we're going to check whether or not we've already
        // seen a candy identical to it.
        for (int i = 0; i < candyType.length; i++) {
            // Start by assuming that the candy IS unique.
            boolean isUnique = true;
            // Check each candy BEFORE this candy.
            for (int j = 0; j < i; j++) {
                // If this candy is the same as a previous one, it isn't unique.
                if (candyType[i] == candyType[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCandies++;
            }
        }
        // The answer is the minimum out of the number of unique candies, and 
        // half the length of the candyType array.
        return Math.min(uniqueCandies, candyType.length / 2);
    }
}

Complexity Analysis

Let N be the the length of candytype

Time complexity :O(N^2) We traverse over each of the NNN elements of candyTypecandyTypecandyType, and for each, we check all of the elements before it. Checking each item for each item is the classic O(N^2)time complexity pattern.
    
Space complexity : O(1). We don't allocate any additional data structures, instead only using constant space variables. 


Q3.  We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.
Example 1:
Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

Solution:-  
Algorithm
    In this approach, we make use of a hashmap  
    which stores the number of times an element occurs in the array along with the element's value in the form (num, count_num), 
    where num refers to an element in the array and count_num refers to the number of times this num occurs in the numsnums array. 
    We traverse over the nums array and fill this map once.
    After this, we traverse over the keys of the map created. 
    For every key of the map considered, say key, we find out if the map contains the key+1. 
    Such an element is found, since only such elements can be counted for the harmonic subsequence 
    if key is considered as one of the element of the harmonic subsequence. 
    We need not care about key−1, because if key is present in the harmonic subsequence, 
    at one time either key+1 or key−1 only could be included in the harmonic subsequence. 
    The case of key−1 being in the harmonic subsequence will automatically be considered, when key−1 is encountered as the current key.
    Now, whenver we find that key+1 exists in the keys of mapmap, 
    we determine the count of the current harmonic subsequence as count_{key} + count_{key+1}, 
    where count_i refers to the value corresponding to the key_i in mapmap, which reprents the number of times i occurs in the array nums.
Complexity Analysis
    
    Time  complexity : O(n). One loop is required to fill map and one for traversing the map.
    Space complexity : O(n). In worst case map size grows upto size n.
        
/*
We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.
*/

class Solution {
    public int findLHS(int[] nums) {
        int rst = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // put the number and its occurence in the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Traverse the map to get the longest harmonious subsequence
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                rst = Math.max(rst, map.get(key) + map.get(key + 1));
            }
        }
        return rst;
    }
}

Question 4
You have a long flowerbed in which some of the plots are planted, and some are not.However, flowers cannot be planted in adjacent plots.Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Solution:-  Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.

Time complexity=O(n) 
Space complexity=O(1) 
   
Code

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || n > flowerbed.length / 2 + 1) return false;
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 0) {
                int prev = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count == n;
    }
}


Analysis

This solution literally checks each position in flowerbed and increase count if there is available place
Therefore, we just need to return count == 0 at the end
To check if position i is available, we should see its previous i-1 and next i+1 in given flowerbed
If available, we first set flowerbed[i] = 1 then increment our count
To terminate the loop earlier, we add count < n inside for loop heading
Let’s consider a very simple case where we have a bunch of 0s ending with 1.
Example:
01
001
0001
00001
We can plant only in the l = arr.size() – 2 zeros. A total number of plants that can be planted in such a section = Math.ceil(l/2D) Now we can imagine the whole array composed of such partitions.
Example
[1,0,0,0,1]
[1,0] [0,0,1]
0001
00001
We can plant only in the l = arr.size() – 2 zeros. A total number of plants that can be planted in such a section = Math.ceil(l/2D) Now we can imagine the whole array composed of such partitions.
Example
[1,0,0,0,1]
[1,0] [0,0,1]
Complexity Analysis for Can Place Flowers Solution
Time Complexity: O(n) as we are just iterating the array once.
Space Complexity: O(1) as we are not using any extra space.


Q5
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
Example 1:
Input: nums = [1,2,3]
Output: 6

Solution:-  
    
Approach :

Scan the array and compute Maximum, second maximum and third maximum element present in the array.
Scan the array and compute Minimum and second minimum element present in the array.
Return the maximum of product of Maximum, second maximum and third maximum and product of Minimum, second minimum and Maximum element.

Complexity :

Time complexity : O(n)
Space complexity : O(1)

Note:
Step 1 and Step 2 can be done in a single traversal 
of the array.

Code (Explained in Comments)

class Solution 
{
    public int maximumProduct(int[] nums) 
    {
        // Initialize Maximum, second maximum
        // and third maximum element
        int maxA=Integer.MIN_VALUE;
        int maxB=Integer.MIN_VALUE;
        int maxC=Integer.MIN_VALUE;

        // Initialize Minimum and
        // second minimum element
        int minA=Integer.MAX_VALUE;
        int minB=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            // Update Maximum, second maximum
            // and third maximum element
            if(nums[i]>maxA)
            {
                maxC=maxB;
                maxB=maxA;
                maxA=nums[i];
            }

            // Update second maximum and
            // third maximum element
            else if(nums[i]>maxB)
            {
                maxC=maxB;
                maxB=nums[i];
            }

            // Update third maximum element
            else if(nums[i]>maxC)
            {
                maxC=nums[i];
            }

            // Update Minimum and second
            // minimum element
            if(nums[i]<minA)
            {
                minB=minA;
                minA=nums[i];
            }

            // Update second minimum element
            else if(nums[i]<minB)
            {
                minB=nums[i];
            }
        }
        return Math.max(maxA*maxB*maxC,minA*minB*maxA);
    }
}

Q 6
Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise,
return -1.You must write an algorithm with O(log n) runtime complexity.
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Solution:- 

Complexity
Time complexity:O(Log N)
Auxiliary Space complexity:O(logN).
Code
class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        return binarySearch(nums,start,end,target);
    }

    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
 
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
 
        // We reach here when element is not present
        // in array
        return -1;
    }
}

Question 7
An array is monotonic if it is either monotone increasing or monotone decreasing.An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].Given an integer array nums, return true if the given array is monotonic, or false otherwise.
Example 1:
Input: nums = [1,2,2,3]
Output: true

Solution:-  

Approach
This code is for a method called isMonotonic that checks whether an array of integers nums is monotonic. A monotonic array is one that is either entirely non-increasing or non-decreasing. Let's break down the code step by step:

Initialize two boolean variables increasing and decreasing to false. These variables will be used to track whether the array is increasing or decreasing.

Start a loop that iterates over the elements of the array nums, starting from the second element (i = 1) and comparing it with the previous element.

Inside the loop, check if the current element nums[i] is greater than the previous element nums[i-1]. If it is, it means the array is increasing at this point.

If the current element is not greater than the previous element, check if it is less than the previous element. If it is, it means the array is decreasing at this point.

After examining all the elements in the array, the boolean variables increasing and decreasing will indicate whether the array is increasing, decreasing, or neither.

Calculate the final result by checking if both increasing and decreasing are true. If they are, it means the array has both increasing and decreasing elements, which makes it not monotonic. In this case, assign false to the result variable. Otherwise, assign true to result.

Return the result variable, which indicates whether the array nums is monotonic or not.

In summary, the code checks each pair of adjacent elements in the array to determine whether the array is increasing or decreasing at any point. If there are elements that cause the array to both increase and decrease, the array is not monotonic. Otherwise, the array is monotonic.

Complexity

Time complexity: O(n)
Space complexity: O(1)

Code
class Solution {
    public boolean isMonotonic(int[] nums) {
        
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for(int i=0;i<nums.length-1;i++) {
            if(nums[i] > nums[i+1]) {
                isIncreasing = false;
            }

            if(nums[i] < nums[i+1]) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}

Q 8
You are given an integer array nums and an integer k.In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.The score of nums is the difference between the maximum and minimum elements in nums.Return the minimum score of nums after applying the mentioned operation at most once for each index in it.
Example 1:
Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.

Solution:-    O(n) | using Max and Min element in array

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        
        // Find the maximum and minimum element of array
        for(int i = 1; i < nums.length; ++i) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        
        // The answer can be either the distance between maximum element and minimum element after decreasing and increasing their value respectively by k or 0 if the can be made same by some X where -k <= X <= k
        int ans = max - min - 2 * k;
        
        return ans > 0 ? ans : 0;
    }
}

Logic
if min(nums) + k < max(nums) - k, then return max - min -(2*k);
if min(nums) + k >= max(nums) - k, then return 0

Complexity
Time complexity: O(n)
Space complexity: O(1)

