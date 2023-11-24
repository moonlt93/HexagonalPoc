package com.example.hexagonalpoc.common.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(description = "API Response DTO")
public class Response<T> {

    @Schema(description = "성공 여부", example = "true")
    private boolean ok;

    @Schema(description = "응답 데이터")
    private T data;

    @Schema(description = "실패시")
    private ErrorResponse error;

    @Builder
    public Response(boolean ok, T data, ErrorResponse error) {
        this.ok = ok;
        this.data = data;
        this.error = error;
    }
}
