package com.mangocity.spring.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.google.common.collect.Maps;
import com.mangocity.spring.common.exception.UtilException;
import com.mangocity.spring.domain.Book;

public class NameParameterUtils {

	/**
	 * 根据具体的对象和对应的属性生成java命名参数字符串 例如: bookName = :bookName and author = :author
	 * 
	 * @param clazz
	 * @param t
	 * @return
	 * @throws UtilException
	 */
	public static <T> String generateNameParameter(T t) throws UtilException {
		BeanInfo beanInfo;
		StringBuilder sb = new StringBuilder();
		boolean neededAdd = false;
		try {
			beanInfo = Introspector.getBeanInfo(t.getClass(), Object.class);
			PropertyDescriptor[] proDescrtptors = beanInfo
					.getPropertyDescriptors();
			if (proDescrtptors != null && proDescrtptors.length > 0) {
				for (PropertyDescriptor propDesc : proDescrtptors) {
					// 获取属性值,如果属性值不为空,则拼接出字符串
					Method getProps = propDesc.getReadMethod();
					Object objectValue = getProps.invoke(t);
					if (null != objectValue) {
						neededAdd = true;// 需要拼接add.
						sb.append(propDesc.getName()).append(" = :")
								.append(propDesc.getName()).append(" and ");
					}
				}
			}
			// 去除最后的" and "
			int lastIndex = sb.toString().lastIndexOf(" and ");
			sb.delete(lastIndex, sb.toString().length());
			if (neededAdd) {// 是否需要在最前面添加 and
				sb.insert(0, " and ");
			}
		} catch (IntrospectionException e) {
			throw new UtilException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new UtilException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new UtilException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new UtilException(e.getMessage());
		}
		return sb.toString();
	}

	public static <T> Map<String, Object> bean2Map(T t) throws UtilException {
		BeanInfo beanInfo;
		Map<String, Object> resultMap = Maps.newHashMap();
		try {
			beanInfo = Introspector.getBeanInfo(t.getClass(), Object.class);
			PropertyDescriptor[] proDescrtptors = beanInfo
					.getPropertyDescriptors();
			if (proDescrtptors != null && proDescrtptors.length > 0) {
				for (PropertyDescriptor propDesc : proDescrtptors) {
					// 获取属性值,如果属性值不为空,则拼接出字符串
					Method getProps = propDesc.getReadMethod();
					Object objectValue = getProps.invoke(t);
					if (null != objectValue) {
						resultMap.put(propDesc.getName(), objectValue);
					}
				}
			}
		} catch (IntrospectionException e) {
			throw new UtilException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new UtilException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new UtilException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new UtilException(e.getMessage());
		}
		return resultMap;
	}

	public static void main(String[] args) throws UtilException {
		Book book = new Book();
		book.setAuthor("海明威");
		book.setBookName("老人与海");
		System.out.println(generateNameParameter(book));
		
		System.out.println(bean2Map(book));
	}
}
