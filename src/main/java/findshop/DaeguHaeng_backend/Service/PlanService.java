package findshop.DaeguHaeng_backend.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) // DB에 트랜잭션하겟다 이말이지 그치~
// atomic한 수정작업 할거임 ㅇㅋ?
@RequiredArgsConstructor
public class PlanService {




}
