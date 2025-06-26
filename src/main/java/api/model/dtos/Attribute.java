package api.model.dtos;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attribute {
    private String key;
    private String value;
}
