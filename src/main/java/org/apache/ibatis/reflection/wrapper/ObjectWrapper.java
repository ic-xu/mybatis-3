/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.wrapper;

import java.util.List;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

/**
 * 对对象的包装，抽象了对象的属性信息，定义了一些列查询对象属性的方法
 * 以及更新属性的方法
 * @author Clinton Begin
 */
public interface ObjectWrapper {
  /**
   * 如果是不同的bean，则调用对象属相的get方法，
   * 如果是集合，则获取相应key的value
   */
  Object get(PropertyTokenizer prop);

  void set(PropertyTokenizer prop, Object value);
//查找表达式的属性，第二个参数表示是否忽略属性中的下划线
  String findProperty(String name, boolean useCamelCaseMapping);
//查找可读属性
  String[] getGetterNames();

  String[] getSetterNames();

  Class<?> getSetterType(String name);

  Class<?> getGetterType(String name);

  boolean hasSetter(String name);

  boolean hasGetter(String name);

  MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory);

  boolean isCollection();

  void add(Object element);

  <E> void addAll(List<E> element);

}
