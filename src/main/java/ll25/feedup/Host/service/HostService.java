package ll25.feedup.Host.service;

import ll25.feedup.Host.domain.Host;
import ll25.feedup.Host.dto.HostSignupRequest;
import ll25.feedup.Host.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostService {

    private final HostRepository hostRepository;

    public void signup(HostSignupRequest signUp) {
        if(hostRepository.existsByLoginId(signUp.getLoginId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        Host host = HostSignupRequest.toEntity(signUp);
        hostRepository.save(host);
    }
}