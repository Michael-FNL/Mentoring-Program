package api.model.dtos;

import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo {
    private int number;
    private int size;
    private int totalElements;
    private int totalPages;
}
