package com.mangocity.spring.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.common.base.CharMatcher;
import com.mangocity.spring.common.exception.UtilException;
import com.mangocity.spring.domain.Book;

public class NameParameterUtils {

	public static <T> String generateNameParameter(Class<T> clazz, T t)
			throws UtilException {
		BeanInfo beanInfo;
		StringBuilder sb = new StringBuilder();
		try {
			beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			PropertyDescriptor[] proDescrtptors = beanInfo
					.getPropertyDescriptors();
			if (proDescrtptors != null && proDescrtptors.length > 0) {
				for (PropertyDescriptor propDesc : proDescrtptors) {
					// 获取属性值,如果属性值不为空,则拼接出字符串
					Method getProps = propDesc.getReadMethod();
					Object objectValue = getProps.invoke(t);
					if (null != objectValue) {
						sb.append(propDesc.getName()).append(" = :")
								.append(propDesc.getName()).append(" and ");
					}
				}
			}
			int index = sb.toString().lastIndexOf(" and ");
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void main(String[] args) throws UtilException {
		Book book = new Book();
		book.setAuthor("海明威");
		System.out.println(generateNameParameter(Book.class,book));
	}
}
