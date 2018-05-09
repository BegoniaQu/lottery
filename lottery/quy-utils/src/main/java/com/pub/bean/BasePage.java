package com.pub.bean;

/**
 * Created by quyang on 2018/4/3.
 */
public class BasePage {

    protected Integer ps = 10;

    protected Integer pn = 1;

    public static final int maxSize = 2000;

//    protected List<String> getFieldName(Class<?> tClass){
//        List<String> list = new ArrayList<>();
//        Field[] fields = tClass.getDeclaredFields();
//        for(Field field : fields){
//            list.add(field.getName());
//        }
//        fields = tClass.getSuperclass().getDeclaredFields();
//        for(Field field : fields){
//            System.out.println(field.getName());
//            list.add(field.getName());
//        }
//        return list;
//    }


    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        if (ps >= maxSize) {
            ps = maxSize;
        }
        this.ps = ps;
    }

    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }
}
