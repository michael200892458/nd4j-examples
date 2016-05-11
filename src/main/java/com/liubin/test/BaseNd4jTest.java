package com.liubin.test;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.rng.DefaultRandom;
import org.nd4j.linalg.api.rng.Random;
import org.nd4j.linalg.factory.Nd4j;

import java.lang.reflect.Method;

/**
 * Created by liubin on 2016/5/10.
 */
public class BaseNd4jTest {

    /**
     * 生成随机多维数组
     */
    public void testRandShapeAndRNG() {
        INDArray ret = Nd4j.rand(new int[]{4, 2}, new DefaultRandom(123));
        INDArray ret2 = Nd4j.rand(new int[]{4, 2}, new DefaultRandom(123));
        System.out.println("--------testRandShapeAndRNG---------");
        System.out.println(ret);
        System.out.println(ret2);
        System.out.println("---------end-------------------------");
    }

    /**
     * 生成限制最大和最小值的多维数组
     */
    public void testRandShapeAndMinMax() {
        INDArray ret = Nd4j.rand(new int[]{4, 2}, 0.2, 1.0, new DefaultRandom(123));
        INDArray ret2 = Nd4j.rand(new int[]{4, 2}, 0.2, 1.0, new DefaultRandom(123));
        System.out.println("-------testRandShapeAndMinMax---------");
        System.out.println(ret);
        System.out.println(ret2);
        System.out.println("--------end---------------------------");
    }

    /**
     * 生成一个的多维数组
     */
    public void testCreateShape() {
        INDArray ret = Nd4j.create(new int[]{4, 2});
        System.out.println("-------testCreateShape---------------");
        System.out.println(ret);
        System.out.println("--------end---------------------------");
    }

    /**
     * 校验默认随机数
     */
    public void testGetRandom() {
        Random r1 = Nd4j.getRandom();
        Random r2 = Nd4j.getRandom();
        System.out.println("-------testGetRandom------------------");
        System.out.println(r1 == r2);
        System.out.println("--------end---------------------------");
    }

    /**
     * 校验设置了随机数种子的随机数
     */
    public void testGetRandomSetSeed() {
        Random r1 = Nd4j.getRandom();
        Random r2 = Nd4j.getRandom();
        System.out.println("-------testGetRandomSetSeed------------");
        System.out.println(r1 == r2);
        r1.setSeed(123);
        System.out.println(r1 == r2);
        System.out.println("--------end---------------------------");
    }

    /**
     * 测试多维数组的均值
     * 计算方式:
     *     例如，一个三维数组, 它的第0维均值的计算
     *     data[i][j] = 1/n * sigma(data[x][i][j]);   其中n是第0维的大小, x <- (0, n)
     *     第0,1维的均值
     *     data[j] = 1/(n*m) * sigma(data[x][i][j]); 其中n是第0维的大小, m是第1维的大小, x <- (0, n), i <- (0, m)
     */
    public void testMean() {
        INDArray data = Nd4j.create(new double[] {
                4.,4.,4.,4.,8.,8.,8.,8.,4.,4.,4.,4.,8.,8.,8.,8.,4.,4.
                ,4.,4.,8.,8.,8.,8.,4.,4.,4.,4.,8.,8.,8.,8,
                2.,2.,2.,2.,4.,4.,4.,4.,2.,2.,2.,2.,4.,4.,4.,4.,
                2.,2.,2.,2.,4.,4.,4.,4.,2.,2.,2.,2.,4.,4.,4.,4.
        },new int[]{2, 2, 4, 4});
        System.out.println("--------testMean----------------------");
        System.out.println(data.mean(0));
        System.out.println("--------------------------------------");
        System.out.println(data.mean(0, 1));
        System.out.println("--------end---------------------------");
    }

    /**
     * 计算方差
     */
    public void testVar() {
        INDArray data = Nd4j.create(new double[] {
                4.,4.,4.,4.,8.,8.,8.,8.,4.,4.,4.,4.,8.,8.,8.,8.,4.,4.
                ,4.,4.,8.,8.,8.,8.,4.,4.,4.,4.,8.,8.,8.,8,
                2.,2.,2.,2.,4.,4.,4.,4.,2.,2.,2.,2.,4.,4.,4.,4.,
                2.,2.,2.,2.,4.,4.,4.,4.,2.,2.,2.,2.,4.,4.,4.,4.
        },new int[]{2, 2, 4, 4});
        System.out.println("--------testVar----------------------");
        System.out.println(data.var(0));
        System.out.println("--------------------------------------");
        System.out.println(data.var(0, 1 ,2));
        System.out.println("--------end---------------------------");
    }

    public static void main(String[] args) {
        Method[] methods = BaseNd4jTest.class.getDeclaredMethods();
        BaseNd4jTest baseNd4jTest = new BaseNd4jTest();
        for (Method method : methods) {
            if (method.getName().equals("main")) {
                continue;
            }
            try {
                method.invoke(baseNd4jTest);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
