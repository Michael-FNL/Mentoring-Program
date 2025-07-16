package api.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
