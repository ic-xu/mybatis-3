/**
 *    Copyright 2009-2015 the original author or authors.
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
 *
 *    Contains the statement executors.
 *
 *
 * mybatis 执行原理：　
 * sqlSession -executor -> stetaManetHandle(mappedHandle) -> paramerHandle  -> query()操作数据库  -> resultHandle返回数据
 * 这几个对象中每次创建都调用拦截器的plugin() 方法，插件就是基于这个方法实现的。
 *
 *
 */
package org.apache.ibatis.executor;
