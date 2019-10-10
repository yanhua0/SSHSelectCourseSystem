package org.select;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class maintest {
    //可以传数组,obj单个字符串,或者不传值
    public static  void print(String s,String... obj){
System.out.println(obj.length);

            System.out.println(obj[0]);

    }
    public static void main(String[] args){
        List<String> s=new ArrayList<String>();
        String[] ss={"1"};
    maintest.print("1234");
    }
}
