package warehouse.inneroperationscore.logging.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class LogEntity {

    private Long id;

    private String type;

    private LocalDateTime dateTime;

    private String nameMethod;

    private String fullNameClass;

    public LogEntity(String type, LocalDateTime dateTime, String nameMethod, String fullNameClass) {
        this.type = type;
        this.dateTime = dateTime;
        this.nameMethod = nameMethod;
        this.fullNameClass = fullNameClass;
    }
}
