/**
 *    Copyright 2009-2020 the original author or authors.
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
package org.apache.ibatis.executor.parameter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A parameter handler sets the parameters of the {@code PreparedStatement}.
 *
 * 在 BoundSql 中记录的 SQL 语句中可能包含“?”占 位
 * 符,而每个 “?”占位符都对 应了 BoundSql .parameterMappings 集合中的 一 个元素,在该
 * ParameterMapping 对 象 中记录了对应 的 参数名称以及该参数的相关属性。
 *
 * MyBatis 只为 ParameterHandler 接口提供了唯一一个实现类 ,也就是 DefaultParameterHandler 。
 *
 * @author Clinton Begin
 */
public interface ParameterHandler {

  Object getParameterObject();

  // SQL 语句绑定实参。
  void setParameters(PreparedStatement ps) throws SQLException;

}
