package com.liubin.test;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.inverse.InvertMatrix;

import java.lang.reflect.Method;

/**
 * Created by liubin on 2016/5/11.
 */
public class InverseMatricesTest {

    public void testInverse() {
        System.out.println("--------------testInverse-------------");
        RealMatrix realMatrix = new Array2DRowRealMatrix(new double[][]{{1, 2}, {3, 4}});
        RealMatrix inverseMatrix = MatrixUtils.inverse(realMatrix);
        System.out.println(inverseMatrix);
        INDArray arr =  InvertMatrix.invert(Nd4j.linspace(1, 4, 4).reshape(2, 2), false);
        System.out.println(arr);
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        Method[] methods = InverseMatricesTest.class.getDeclaredMethods();
        InverseMatricesTest inverseMatricesTest = new InverseMatricesTest();
        for (Method method : methods) {
            if (method.getName().equals("main")) {
                continue;
            }
            try {
                method.invoke(inverseMatricesTest);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
