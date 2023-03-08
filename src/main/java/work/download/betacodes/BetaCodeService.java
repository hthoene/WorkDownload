package work.download.betacodes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import work.download.utils.RandomString;

import java.util.Locale;

@Service
@AllArgsConstructor
public class BetaCodeService {

    private final BetaCodeRepository codeRepository;

    public BetaCode generateCode() {
        BetaCode betaCode = new BetaCode();
        betaCode.setKey(RandomString.randomString(6).toUpperCase(Locale.ROOT));
        return codeRepository.save(betaCode);
    }

    public boolean checkBetaCode(String code) {
        BetaCode byKey = codeRepository.findByKey(code);
        if(byKey == null) return false;
        return true;
    }

    public boolean deleteCode(String code) {
        BetaCode betaCode = codeRepository.findByKey(code);
        if(betaCode == null) return false;
        codeRepository.delete(betaCode);
        return true;
    }

}
