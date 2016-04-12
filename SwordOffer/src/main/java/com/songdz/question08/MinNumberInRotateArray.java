package com.songdz.question08;

import org.junit.Test;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *
 * 思路：对于旋转数组，使用二分法来查找最小元素。取中间mid元素，
 * 如果array[mid]>array[end]，说明最小元素应该在mid的右边，因为我们实际是要找没有旋转之前的第一个元素，观察数组规律可以知道，在mid的右边
 * 如果array[mid]<array[start]，说明已经取到了被旋转的那一节数组了，因此此时的最小元素，应该在mid的左边
 * 另外有一个特殊情况，就是分不清楚在哪段数组中，也就是恰好有重复元素，那就只能遍历查找了，所以最坏的时间复杂度是O(n)，最好是O(logn)
 *
 * 最差效率:O(n) 最佳效率：O(log n)
 *
 * Created by SongDz on 2016/4/5.
 *
 * @author SongDz
 */
public class MinNumberInRotateArray {

    private int[] rotateArray;

    public MinNumberInRotateArray() {
    }

    public MinNumberInRotateArray setRotateArray(int[] rotateArray) {
        this.rotateArray = rotateArray;
        return this;
    }

    public int minNumberInRotateArray() {

        if (rotateArray.length == 0) {
            throw new RuntimeException("Invalid Array");
        }

        int start = 0;
        int end = rotateArray.length - 1;
        int mid = start;
        while (rotateArray[start] >= rotateArray[end]) {
            if (end - start == 1) {
                start = end;
                break;
            }
            mid = (start + end) / 2;
            if (rotateArray[mid] == rotateArray[start] && rotateArray[mid] == rotateArray[end]) {
                int result = rotateArray[start];
                while (start < end) {
                    if (result > rotateArray[++start]) {
                        result = rotateArray[start];
                    }
                }
                return result;
            }
            if (rotateArray[mid] <= rotateArray[end]) {
                end = mid;
            } else if (rotateArray[mid] >= rotateArray[start]) {
                start = mid;
            }

        }

        return rotateArray[start];

    }

    @Test
    public void testMinNumberInRotateArray() {

        int[] array1 = {3, 4, 5, 1, 2, 3};
        int[] array2 = {1, 2, 3, 4, 5, 6};
        int[] array3 = {1, 1, 1, 0, 1, 1};
        int[] array4 = {1, 1, 0, 1, 1};

        System.out.println(new MinNumberInRotateArray().setRotateArray(array1).minNumberInRotateArray());
        System.out.println(new MinNumberInRotateArray().setRotateArray(array2).minNumberInRotateArray());
        System.out.println(new MinNumberInRotateArray().setRotateArray(array3).minNumberInRotateArray());
        System.out.println(new MinNumberInRotateArray().setRotateArray(array4).minNumberInRotateArray());

    }

}
