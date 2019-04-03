package algorithm.searching;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.EnumSet;

/**
 * @ Author     ：thin.
 * @ Date       ：Created in 3:15 PM 2018/12/5
 * @ Description：${description}
 * @ Modified By：
 * @Version: $version$
 */
public class TwoThreeTree {
    private int val1;

    private int val2;

    private int childCnt = 0;

    private boolean isTwo = false;

    private TwoThreeTree left;

    private TwoThreeTree mid;

    private TwoThreeTree right;

    public TwoThreeTree(int val) {
        this.val1 = val;
    }

    public TwoThreeTree(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public TwoThreeTree add(TwoThreeTree node) {

        //find the right node


        //insert


        //fix

        if (isTwo) {
            if (node.val1 < val1) {
                int tmp = val1;
                val1 = node.val1;
                val2 = tmp;
            } else {
                val2 = node.val1;
            }

            //Two tree
            if (node.val1 < val1) {
                if (null == this.left) {
                    this.left = node;
                } else {
                    add(this.left);
                }
            } else { //node.val1 > val2
                if (null == this.right) {
                    this.right = node;
                } else {
                    add(this.right);
                }
            }
        } else {
            //Three tree
            if (node.val1 < val1) {
                add(this.left);
            } else if (node.val1 > val1 && node.val1 < val2) {
                add(this.mid);
            } else { //node.val1 > val2
                add(this.right);
            }
        }

        return null;
    }

    public TwoThreeTree find(TwoThreeTree node) {

        return null;

    }


}


