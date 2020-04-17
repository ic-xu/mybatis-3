/**
 *    Copyright 2009-2016 the original author or authors.
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
package org.apache.ibatis.executor.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.ResultHandler;

/**
 * @author Clinton Begin
 *
 * StatementHandler 接口中的功能很多,
 *
 *  例如创建 Statement 对象,为 SQL 语句绑定实参,执
 * 行 select、 insert 、 update 、 delete 等多种类型的 SQL 语句,批量执行 SQL 语句,将结果集映射
 * 成结果对象。
 *
 */
public interface StatementHandler {

  //从连接中获取一个statement
  Statement prepare(Connection connection, Integer transactionTimeout)
      throws SQLException;

  //绑定statement执行时需要的实参
  void parameterize(Statement statement)
      throws SQLException;

  //批量执行SQL
  void batch(Statement statement)
      throws SQLException;

  //执行update/insert/delete SQL 语句
  int update(Statement statement)
      throws SQLException;

  //执行查询SQL语句
  <E> List<E> query(Statement statement, ResultHandler resultHandler)
      throws SQLException;

  <E> Cursor<E> queryCursor(Statement statement)
      throws SQLException;

  BoundSql getBoundSql();

  //获取其中封装的ParameterHandle
  ParameterHandler getParameterHandler();

}
