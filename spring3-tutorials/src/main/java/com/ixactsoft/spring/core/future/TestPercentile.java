package com.ixactsoft.spring.core.future;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;

/**
 * @author Ovidiu Lupas
 */
public class TestPercentile {

    static double[] vals = {43, 54, 56, 61, 62, 66, 68, 69, 69, 70, 71, 72, 77, 78, 79, 85, 87, 88, 89, 93, 95, 96, 98, 99, 99};

    public static void main(String[] args) {
        Percentile p = new Percentile();
        p.setData(vals);

        System.out.println(p.evaluate(90));
        System.out.println(p.evaluate(20));
        System.out.println(p.evaluate(99));
    }

}
