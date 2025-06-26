package api.model.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LaunchAnalyzeRequestDto {
    private int launchId;
    private String analyzerMode;
    private String analyzerTypeName;
    private List<String> analyzeItemsMode;
}
