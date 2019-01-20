package com.csult.zzw.spider;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
// ×¢½â¡¢×°ÊÎÆ÷
@Mapper
public interface FilmMapper {

	@Insert("insert into film() values()")
	void save(Film film);
	
	@Select("select * from film where id = #{id}")
	Film load(int id);
	
	
}
