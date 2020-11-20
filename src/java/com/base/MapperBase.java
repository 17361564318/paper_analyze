package com.base;

import tk.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SqlServerProvider;

public interface MapperBase<T> extends Mapper<T> {

	/**
	 * 插入数据库，`null`值也会插入，不会使用列的默认值
	 *
	 * @param record
	 * @return
	 * @Insertprovider是通过SQL工厂类及对应的方法生产SQL语句,这种方法的好处在于，我们可以根据不同的需求生产出不同的SQL，适用性更好。
	 */
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@InsertProvider(type = SqlServerProvider.class, method = "dynamicSQL")
	@Override
	int insert(T record);

}
