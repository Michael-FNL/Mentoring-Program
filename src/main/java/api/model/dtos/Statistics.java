package api.model.dtos;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    private Executions executions;
    private Defects defects;
}
