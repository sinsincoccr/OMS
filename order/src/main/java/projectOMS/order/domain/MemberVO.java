package projectOMS.order.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MemberVO {

    private String cpn_cd;         // 업체코드
    private String cpn_biz_no;     // 사업자번호
    private String cpn_id;         // 업체 ID
    private String cpn_pw;         // 업체 비밀번호
    private String cpn_nm;         // 상호명
    private String ceo_nm;         // 대표자명
    private String cpn_addr;       // 업체주소
    private String cpn_image_url;  // 업체 이미지 URL
    private String cpn_desc;       // 업체 설명
    private String opn_dt;         // 오픈 일자
    private String cpn_tel;        // 전화번호
    private String cpn_email;      // 이메일
    private String cpn_state;      // 업체 상태
    private LocalDateTime state_mdf_date;   // 상태 변경 일시
    private LocalDateTime reg_date;         // 등록 일시


}
