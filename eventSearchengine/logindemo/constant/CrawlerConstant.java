package com.example.logindemo.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrawlerConstant {
    public static String SOURCE_BAIDU = "https://www.baidu.com/s?wd=";
    public static String SOURCE_BAIDU_TEST = "https://www.baidu.com/s?wd=唐山打人&pn=";
    public static String TEST_COOKIE = "BIDUPSID=0AA27D1672232568A9CAF433DB6BC2B1; PSTM=1655550648; BD_UPN=12314753; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BAIDUID=0AA27D1672232568A9CAF433DB6BC2B1:SL=0:NR=10:FG=1; delPer=0; BD_CK_SAM=1; PSINO=5; BAIDUID_BFESS=0AA27D1672232568A9CAF433DB6BC2B1:SL=0:NR=10:FG=1; ZD_ENTRY=empty; BA_HECTOR=252g05208020218h2k1hbre6n15; ZFY=i:BC8AE8aaMnZysyBpcSvOoxSGF7Y0Oe2lZrs8foQE40:C; BD_HOME=1; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; H_PS_PSSID=36542_36462_36727_36455_31254_36666_34812_36691_36165_36693_36697_36744_26350_36469_36715; COOKIE_SESSION=68_0_9_9_9_6_1_0_9_6_0_0_831_0_0_0_1656599926_0_1656600860%7C9%23117_36_1656233674%7C7; sug=3; sugstore=0; ORIGIN=0; bdime=0; H_PS_645EC=c665RttCn1M30ny7gx%2FwFSpSlKt%2FYHNLQWS36BfjwKEI%2Ft3edQMgb6yOAea0XKYATTCA";
    public static int SEARCH_LENGTH_TEST = 5;
    public static List<String> FILTER_PATTERNS = new ArrayList(Arrays.asList(".*baijiahao.*", ".*163.com/dy/.*", ".*weixin.*"));
    public static String BAIDU_RESULT_TIME_CLASS_NAME = "span.c-color-gray2";
    public static String BAIDU_RESULT_URL_ATTR_NAME = "mu";
    public static String BAIDU_RESULT_DIV_CSS_QUERY = ".result";
    public static String BAIDU_RESULT_CONTENT_CSS_QUERY = "span.content-right_8Zs40";
    public static String BAIDU_RESULT_TITLE_CSS_QUERY = "h3.c-title";
    public static String REGEX_INT_PATTERN = "[^0-9]";
    public static String REGEX_CHINESE_HOUR = ".*小时.*";
    public static String REGEX_CHINESE_DAY = ".*天.*";
    public static String REGEX_CHINESE_MINUTE = ".*分钟.*";
    public static String BAIDU_DATE_FORMAT = "yyyy年MM月dd日";

    public CrawlerConstant() {
    }
}
