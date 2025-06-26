package api.model.dtos;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Executions {
    private int total;
    private int failed;
    private int passed;
    private int skipped;
}
