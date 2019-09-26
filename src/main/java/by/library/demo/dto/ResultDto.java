package by.library.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultDto {

    private String bookName;
    private Integer creationYear;
    private String authorName;
    private String genreName;
}
