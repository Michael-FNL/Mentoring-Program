package api.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Defects {
    @JsonProperty("system_issue")
    private Map<String, Integer> systemIssue;

    @JsonProperty("to_investigate")
    private Map<String, Integer> toInvestigate;

    @JsonProperty("automation_bug")
    private Map<String, Integer> automationBug;

    @JsonProperty("product_bug")
    private Map<String, Integer> productBug;
}
