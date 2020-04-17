/**
 * Copyright 2009-2020 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Base package for caching stuff.
 * <p>
 *
 一级缓存：本地缓存，当mybatis在同一次回话中，同一个sql多次查询的结果会把第一次查询的结果放入缓存中，下次直接从缓存中拿。
 sqlSession级别缓存，原理就是里面的一个map属性，这个是不能关闭的，（没有使用到一级缓存的情况：
 1、session失效，两次用的不是同一个session
 2、SqlSession相同，但是查询条件不一样，也会导致不会走缓存
 3、SQLSession相同，但是在两次之间使用了增删改查操作，缓存也会失效
 4、SQLSession相同，但是我们手动把缓存清掉了）

 二级缓存：全局缓存，基于nameSpace缓存，一个nameSpace对应一个二级缓存。（原理，当开启二级缓存之后，一级缓存中的结果在会话关
 闭的时候会被保存到二级缓存中，下次再次查找的时候就会去二级缓存中查找。）
 不同的nameSpace中的缓存数据不一样,查出的数据都是首先放在一级缓存中，只有当session关闭的时候才会放到二级缓存中去。
 开启步骤：一，开启全局配置，mapper中添加<cache></cache> 标签

 使用顺序：先使用二级缓存 -> 再使用一级缓存
 *
 */
package org.apache.ibatis.cache;
