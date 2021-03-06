package org.xpm.rules.test.queen;

import org.xpm.rules.AbstractRule;
import org.xpm.rules.RuleEngine;

import java.util.HashSet;

/**
 * Created by xupingmao on 2017/12/8.
 */
public class QueenRule extends AbstractRule<QueenParam> {

    private int counter = 0;

    @Override
    public boolean match(QueenParam globalContext) {
        return true;
    }

    @Override
    public void execute(QueenParam globalContext) {
        counter++;
        Integer x1 = globalContext.getX1();
        Integer y1 = globalContext.getY1();
        Integer x2 = globalContext.getX2();
        Integer y2 = globalContext.getY2();
        Integer x3 = globalContext.getX3();
        Integer y3 = globalContext.getY3();
        Integer x4 = globalContext.getX4();
        Integer y4 = globalContext.getY4();

        // 坐标不能相同
        if (notDistinct(x1,x2,x3, x4)) {
            return;
        }
        if (notDistinct(y1, y2, y3, y4)) {
            return;
        }
        // 不能在斜对角
        // p1,p2斜对角
        if (isInCorner(x1,y1,x2,y2)) {
            return;
        }
        // p1,p3斜对角
        if (isInCorner(x1,y1,x3,y3)) {
            return;
        }
        // p1,p4斜对角
        if (isInCorner(x1,y1,x4,y4)) {
            return;
        }
        // 2,3
        if (isInCorner(x2,y2,x3,y3)) {
            return;
        }
        // 2,4
        if (isInCorner(x2,y2,x4,y4)) {
            return;
        }
        // 3,4
        if (isInCorner(x3,y3,x4,y4)) {
            return;
        }

        System.out.printf("%03d (%d,%d) (%d,%d) (%d,%d) (%d,%d)\n",
                counter, x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private boolean notDistinct(Integer x1, Integer x2, Integer x3, Integer x4) {
        HashSet<Integer> integers = new HashSet<Integer>();
        integers.add(x1);
        integers.add(x2);
        integers.add(x3);
        integers.add(x4);
        return integers.size() != 4;
    }

    private boolean isInCorner(int x1, int y1, int x2,int y2) {
        return Math.abs(x1-x2) == Math.abs(y1-y2);
    }
}
