package com.example.hexagonalpoc.common.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "에러 정보, ok 값이 false인 경우 ErrorResponse 값 존재(data 값은 null)")
public class ErrorResponse {

    @Schema(description = "에러 코드", defaultValue = "HttpStatus")
    private String errorCode;

    @Schema(description = "에러 설명")
    private String errorDescription;

    @Builder
    public ErrorResponse(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }
}
