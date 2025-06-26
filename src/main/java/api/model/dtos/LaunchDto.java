package api.model.dtos;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaunchDto {
    private String owner;
    private String description;
    private int id;
    private String uuid;
    private String name;
    private int number;
    private String startTime;
    private String endTime;
    private String lastModified;
    private String status;
    private Statistics statistics;
    private List<Attribute> attributes;
    private String mode;
    private List<Object> analysing;
    private double approximateDuration;
    private boolean hasRetries;
    private boolean rerun;
    private String retentionPolicy;
    private Map<String, String> metadata;
}
