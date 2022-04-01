package warehouse.inneroperationscore.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import warehouse.inneroperationscore.model.ProfitEntity;

@Mapper
public interface ProfitRepository {

    @Insert("insert into profit_on_day (day, profit) " +
            "values(#{day}, #{profit})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(ProfitEntity profitEntity);
}
