package com.songdz.question03;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：
 *  1、从右上角(或左下角)开始查找
 *  2、如果值大于num，列数减1；小于num，则行数加1。
 *
 * 时间效率：最差需要 rowNum + columnNum步， O(n)
 *
 * Created by SongDz on 2016/3/17.
 *
 * @author SongDz
 */
public class FindInPartiallySortedMatrix {

    private int[][] matrix;

    private int rowNum;

    private int columnNum;

    /*public Question03(int[][] matrix) {
        this.matrix = matrix;
        this.validMatrix();
    }*/

    public FindInPartiallySortedMatrix() {

    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
        validMatrix();
        System.out.println(rowNum + " " + columnNum);
    }

    public void validMatrix() {

        boolean isValid = true;

        if (matrix == null) {
            throw new RuntimeException("矩阵为空！！！");
        }

        rowNum = matrix.length;
        if (rowNum > 0) {

            columnNum = matrix[0].length;
            if (columnNum > 0) {

                for (int i = 0; i < rowNum; i++) {
                    for (int j = 0; j < columnNum - 1; j++) {
                        if (matrix[i][j] > matrix[i][j+1]) {
                            isValid = false;
                            break;
                        }
                    }
                }
                for (int j = 0; j < columnNum; j++) {
                    for (int i = 0; i < rowNum - 1; i++) {
                        if (matrix[i][j] > matrix[i+1][j]) {
                            isValid = false;
                            break;
                        }
                    }
                }


            } else {
                isValid = false;
            }

        } else {
            isValid = false;
        }

        if (isValid) {
            System.out.println("矩阵有序！！！");
        } else {
            throw new RuntimeException("矩阵非有序！！！");
        }

    }

    public boolean findTarget(int target) {

        int i = 0;
        int j = columnNum - 1;

        while (i < rowNum && j >= 0) {

            if (target == matrix[i][j]) {
                System.out.printf("Find it in (%d , %d) %n", i, j);
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }


    @Test
    public void testQuestion03() {

        //int[][] matrix = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int[][] matrix = {{1,1,1,1}, {1,1,1,1}};

        this.setMatrix(matrix);

        Assert.assertTrue(this.findTarget(1));

    }


}
