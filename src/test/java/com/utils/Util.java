package com.utils;

import com.environment.ManageEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Util {
    public static boolean isNumeric(String strNum){
        if (strNum == null){
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public static boolean matchCI (String pattern, String text){
        return Pattern.compile(
                pattern,
                Pattern.CASE_INSENSITIVE
        ).matcher(text).find();
    }
    public static String matchGroup(String pattern, String text) {
        Pattern p =  Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        if(m.find()) return m.group();
        return null;
    }
    public static String matchAmount(String text) {
        String amount = matchGroup("((?>[\\d]*,)*[\\d]+\\.?[\\d]*)",text);
        if(amount != null) return amount;
        return "0";
    }
    public static String getEnvironmentProperty(String property){
        String res = "";
        try{
            res = EnvironmentSpecificConfiguration.from(ManageEnvironment.getEnvironment()).getProperty(property);
        } catch (Exception ignored) {
        }
        return res;
    }
    public static int random(int _min, int _max){
        int max = _max + 1 - _min;
        Random rand = new Random();
        return ( rand.nextInt(max) + _min );
    }
    public static int random(int _max){
        return random(0, _max);
    }
}
