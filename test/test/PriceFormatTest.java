/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DecimalFormat;

/**
 *
 * @author TiVA
 */
public class PriceFormatTest {

    /**
     * Given value will transform to given pattern.
     * 
     * @param pattern  ###,###,###.###
     * @param value    
     * @return 
     */
    static public String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        //System.out.println(value + "  " + pattern + "  " + output);
        return output;
    }

    static public void main(String[] args) {
        //customFormat("###,###.###", 123456.789);
        //customFormat("###.##", 123456.789);
        //customFormat("000000.000", 123.78);
        String customFormat = customFormat(" ###,###,###.###", 12345.67);
        System.out.println("format "+customFormat);
        double parseDouble = Double.parseDouble(customFormat);
        System.out.println("double ; "+parseDouble);
    }
}
