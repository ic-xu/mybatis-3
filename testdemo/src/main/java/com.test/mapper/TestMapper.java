package com.test.mapper;

import org.apache.ibatis.annotations.Select;

public interface TestMapper {

  @Select("select * from ff")
  Object findAll ();

}
