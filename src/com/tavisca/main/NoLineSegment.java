package com.tavisca.main;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class NoLineSegment {
    public int x1, y1, x2, y2, x3, y3, x4, y4;

    public NoLineSegment(int[] X, int[] Y) {
        x1 = X[0];
        y1 = X[1];
        x2 = X[2];
        y2 = X[3];
        x3 = Y[0];
        y3 = Y[1];
        x4 = Y[2];
        y4 = Y[3];
    }

    public String isParallel() {
        if (((y1 == y2) && (y3 == y4)) || ((x1 == x2) && (x3 == x4)))
            return "Yes";
        else
            return "No";
    }

    public String isPerpendicular() {
        if (((y1 == y2) && (x3 == x4)) || ((x1 == x2) && (y3 == y4)))
            return "Yes";
        else
            return "No";
    }

    public String isIntersecting() {
        if(isPerpendicular().equals("Yes")){
            if ((y1 == y2) && (x3 >= min(x1, x2) && x3 <= max(x1, x2)) && (y1 >= min(y3, y4) && y1 <= max(y3, y4))) {
                return "Yes";
            } else if ((x1 == x2) && (y3 >= min(y1, y2) && y3 <= max(y1, y2)) && (x1 >= min(x3, x4) && x1 <= max(x3, x4))) {
                return "Yes";
            }
        }
        else//if (isParallel().equals("Yes")) {
        {
            if (y1 == y3) {
                if ((((min(x3, x4) == max(x1, x2)) && (max(x3, x4) > max(x1, x2)))) || ((min(x1, x2) == max(x3, x4)) && (max(x1, x2) > max(x3, x4))))
                    return "Yes";
                else if (((x1 == x2) && (y1 == y2)) || ((x3 == x4) && (y3 == y4)))
                    return "Yes";
            }
            if (x1 == x3) {
                if (((min(y3, y4) == max(y1, y2)) && (max(y3, y4) > max(y1, y2))) || ((min(y1, y2) == max(y3, y4)) && (max(y1, y2) > max(y3, y4))))
                    return "Yes";
                else if (((x1 == x2) && (y1 == y2)) || ((x3 == x4) && (y3 == y4)))
                    return "Yes";
            }
            return "No";
        }
        return "No";
    }

    public String isOverlapping() {
        if (isParallel().equals("Yes")) {
            if (y1 == y3) {
                if ((min(x3, x4) >= min(x1, x2)) && (min(x3, x4) < max(x1, x2)) || (min(x1, x2) >= min(x3, x4)) && (min(x1, x2) < max(x3, x4)))
                    return "Yes";
            } else if (x1 == x3) {
                if ((min(y3, y4) >= min(y1, y2)) && (min(y3, y4) < max(y1, y2)) || (min(y1, y2) >= min(y3, y4)) && (min(y1, y2) < max(y3, y4)))
                    return "Yes";
            }
        }
        return "No";
    }
}
