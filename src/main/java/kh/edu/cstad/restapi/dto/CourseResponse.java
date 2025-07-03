package kh.edu.cstad.restapi.dto;

import lombok.Builder;

@Builder
public record CourseResponse(
        String id,
        String code,
        String title,
        Double price,
        Boolean status
) {

}
