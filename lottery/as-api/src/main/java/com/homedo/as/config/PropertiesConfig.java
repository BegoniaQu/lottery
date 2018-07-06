package com.homedo.as.config;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by quyang on 2018/4/19.
 */
public class PropertiesConfig {

    private static final int threhold = 5;


    public static final String JZ_PIC = "jz_pic";




    /**
     *
     波色表
     红：01 02 07 08 12 13 18 19 23 24 29 30 34 35 40 45 46
     蓝：03 04 09 10 14 15 20 25 26 31 36 37 41 42 47 48
     绿：05 06 11 16 17 21 22 27 28 32 33 38 39 43 44 49

     五行表
     金:04 05 18 19 26 27 34 35 48 49
     木:01 08 09 16 17 30 31 38 39 46 47
     水:06 07 14 15 22 23 36 37 44 45
     火:02 03 10 11 24 25 32 33 40 41
     土:12 13 20 21 28 29 42 43

     家禽：牛 马 羊 鸡 狗 猪
     野兽：鼠 虎 兔 龙 蛇 猴

     段数：
     1段-- 01,02,03,04,05,06,07,
     2段-- 08,09,10,11,12,13,14,
     3段-- 15,16,17,18,19,20,21,
     4段-- 22,23,24,25,26,27,28,
     5段-- 29,30,31,32,33,34,35,
     6段-- 36,37,38,39,40,41,42,
     7段-- 43,44,45,46,47,48,49,
     */

    private static final Map<String, List<String>> bsMap = new HashMap<>();
    private static final Map<String, List<String>> wxMap = new HashMap<>();
    private static final Map<String, List<String>> jqysMap = new HashMap<>();
    private static final Map<String, List<String>> duanshuMap = new HashMap<>();

    static {
        //bs
        String red = "01 02 07 08 12 13 18 19 23 24 29 30 34 35 40 45 46";
        String blue = "03 04 09 10 14 15 20 25 26 31 36 37 41 42 47 48";
        String green = "05 06 11 16 17 21 22 27 28 32 33 38 39 43 44 49";
        List<String> redList  = Arrays.asList(red.split(" "));
        bsMap.put("红", redList);
        List<String> blueList  = Arrays.asList(blue.split(" "));
        bsMap.put("蓝", blueList);
        List<String> greenList  = Arrays.asList(green.split(" "));
        bsMap.put("绿", greenList);
        //wx
        String gold = "04 05 18 19 26 27 34 35 48 49";
        String wood = "01 08 09 16 17 30 31 38 39 46 47";
        String water = "06 07 14 15 22 23 36 37 44 45";
        String fire = "02 03 10 11 24 25 32 33 40 41";
        String earth = "12 13 20 21 28 29 42 43";
        wxMap.put("金", Arrays.asList(gold.split(" ")));
        wxMap.put("木", Arrays.asList(wood.split(" ")));
        wxMap.put("水", Arrays.asList(water.split(" ")));
        wxMap.put("火", Arrays.asList(fire.split(" ")));
        wxMap.put("土", Arrays.asList(earth.split(" ")));
        //jqys
        String jq  = "牛 馬 羊 雞 狗 豬";
        String ys = "鼠 虎 兔 龍 蛇 猴";
        jqysMap.put("家", Arrays.asList(jq.split(" ")));
        jqysMap.put("野", Arrays.asList(ys.split(" ")));
        //段数
        duanshuMap.put("1段", Arrays.asList("01,02,03,04,05,06,07".split(",")));
        duanshuMap.put("2段", Arrays.asList("08,09,10,11,12,13,14".split(",")));
        duanshuMap.put("3段", Arrays.asList("15,16,17,18,19,20,21".split(",")));
        duanshuMap.put("4段", Arrays.asList("22,23,24,25,26,27,28".split(",")));
        duanshuMap.put("5段", Arrays.asList("29,30,31,32,33,34,35".split(",")));
        duanshuMap.put("6段", Arrays.asList("36,37,38,39,40,41,42".split(",")));
        duanshuMap.put("7段", Arrays.asList("43,44,45,46,47,48,49".split(",")));
    }


    /**
     * 波色
     * @param nums
     * @return
     */
    public static String getBs(String nums){
        String [] arr = nums.split(",");
        List<String> bsList = new ArrayList<>();
        for(String num : arr){
            for(String k : bsMap.keySet()){
                if(bsMap.get(k).contains(num)){
                    bsList.add(k);
                    break;
                }
            }
        }
       return StringUtils.collectionToDelimitedString(bsList, ",");
    }

    /**
     * 五行
     * @param nums
     * @return
     */
    public static String getWx(String nums){
        String [] arr = nums.split(",");
        List<String> wxList = new ArrayList<>();
        for(String num : arr){
            for(String k : wxMap.keySet()){
                if(wxMap.get(k).contains(num)){
                    wxList.add(k);
                    break;
                }
            }
        }
        return StringUtils.collectionToDelimitedString(wxList, ",");
    }

    /**
     * 家野
     * @param sxs
     * @return
     */
    public static String getJy(String sxs){
        String [] arr = sxs.split(",");
        List<String> jyList = new ArrayList<>();
        for(String sx : arr){
            for(String k : jqysMap.keySet()){
                if(jqysMap.get(k).contains(sx)){
                    jyList.add(k);
                    break;
                }
            }
        }
        return StringUtils.collectionToDelimitedString(jyList, ",");
    }

    /**
     * 尾数
     * @return
     */
    public static String getWs(String nums){
        String [] arr = nums.split(",");
        List<String> wsList = new ArrayList<>();
        for(String num : arr){
            int one = Integer.parseInt(num.substring(1));
            if(one < threhold){
                wsList.add("小");
            }else{
                wsList.add("大");
            }
        }
        return StringUtils.collectionToDelimitedString(wsList, ",");
    }

    public static int sum(String nums){
        String [] arr = nums.split(",");
        int total = 0;
        for(String num : arr){
            int one = Integer.parseInt(num);
            total += one;
        }
        return total;
    }

    /**
     * 总和单双
     * @param num
     * @return
     */
    public static int singleOrDouble(int num){
        if(num % 2 == 0){
            return 2;
        }else{
            return 1;
        }
    }


    /**
     * 段数
     * @param num
     * @return
     */
    public static String getDs(String num){
        for(String key : duanshuMap.keySet()){
            if(duanshuMap.get(key).contains(num)){
                return key;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        String str = "13";
        System.out.println(str.substring(1));
    }
}
