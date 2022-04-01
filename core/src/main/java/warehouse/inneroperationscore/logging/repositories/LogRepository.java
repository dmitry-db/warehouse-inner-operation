package warehouse.inneroperationscore.logging.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import warehouse.inneroperationscore.logging.model.LogEntity;

@Mapper
public interface LogRepository {

    @Insert("insert into log (type, date_time, name_method, full_name_class) " +
            "values(#{type}, #{dateTime}, #{nameMethod}, #{fullNameClass})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(LogEntity logEntity);
}
