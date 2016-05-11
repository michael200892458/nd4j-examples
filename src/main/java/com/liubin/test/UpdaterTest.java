package com.liubin.test;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.AdaGrad;

import java.lang.reflect.Method;

/**
 * Created by liubin on 2016/5/11.
 */
public class UpdaterTest {

    public void AdaGradTest() {
        System.out.println("--------------adaGradTest---------------");
        int cols = 10;
        int rows = 1;
        AdaGrad adaGrad = new AdaGrad(rows, cols, 0.1);
        Nd4j.getRandom().setSeed(123);
        INDArray W = Nd4j.rand(rows, cols);
        System.out.println(W);
        System.out.println(adaGrad.getGradient(W, 0));
        System.out.println("---------------end----------------------");
    }

    public static void main(String[] args) {
        Method[] methods = UpdaterTest.class.getDeclaredMethods();
        UpdaterTest updaterTest = new UpdaterTest();
        for (Method method : methods) {
            if (method.getName().equals("main")) {
                continue;
            }
            try {
                method.invoke(updaterTest);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
