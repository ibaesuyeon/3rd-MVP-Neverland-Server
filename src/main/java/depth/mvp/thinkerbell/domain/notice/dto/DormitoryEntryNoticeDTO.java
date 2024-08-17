package depth.mvp.thinkerbell.domain.notice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import depth.mvp.thinkerbell.domain.notice.entity.DormitoryEntryNotice;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  // null인 필드는 JSON에 포함되지 않음
public class DormitoryEntryNoticeDTO {
    private Long id;
    private LocalDate pubDate;
    private String title;
    private String url;
    private boolean important;
    private String campus;

    // 엔티티를 DTO로 변환하는 정적 메서드
    public static DormitoryEntryNoticeDTO fromEntity(DormitoryEntryNotice notice) {
        return new DormitoryEntryNoticeDTO(
                notice.getId(),
                notice.getPubDate(),
                notice.getTitle(),
                notice.getUrl(),
                notice.isImportant(),
                notice.getCampus()
        );
    }
}