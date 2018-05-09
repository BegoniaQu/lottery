package com.pub;


import com.pub.exception.SCCustomRuntimeException;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by quyang on 2018/4/3.
 */
public class Request2PojoConverter {

    public static <T> T request2Pojo(HttpServletRequest request,   //返回值为随意的类型   传入参数为request 和该随意类型
                                     Class<T> beanClass) {
        try {
            T bean = beanClass.newInstance();   //实例化随意类型
            Enumeration<String> en = request.getParameterNames();   //获得参数的一个列举
            while (en.hasMoreElements()) {         //遍历列举来获取所有的参数
                String name = en.nextElement();
                String value = request.getParameter(name).trim();
                BeanUtils.setProperty(bean, name, value);   //注意这里导入的是  import org.apache.commons.beanutils.BeanUtils;
            }
            return bean;
        } catch (Exception e) {
            throw new SCCustomRuntimeException("parse param error");  //如果错误 则向上抛运行时异常
        }
    }
}
