package api.model.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaunchResponse {
    private PageInfo page;
    private List<LaunchDto> content;
}
