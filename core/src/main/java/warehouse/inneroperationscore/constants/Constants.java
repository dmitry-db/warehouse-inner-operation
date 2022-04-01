package warehouse.inneroperationscore.constants;

import org.springframework.stereotype.Component;

@Component
public class Constants {

    private static Double PROFIT_ON_DAY = 0.0; //будем надеятся, что у нас небольшой магазин и Double хватит, если он большой можно будет в будещем подумать о другом типе :)

    public static void addSum(Double sum) {
        PROFIT_ON_DAY += sum;
    }

    public static void setProfitOnDayNull(){
        PROFIT_ON_DAY = 0.0;
    }

    public static Double getProfitOnDay() {
        return PROFIT_ON_DAY;
    }
}
