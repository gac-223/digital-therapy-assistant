import org.springframework.ai.chat.client.ChatClient;

import java.util.Set;

public class CrisisDetector {
    private static final Set<String> CRISIS_KEYWORDS = Set.of(
            "suicide", "kill myself", "end it all", "no reason to live",
            "better off dead", "can't go on", "want to die", "hurt myself"
    ) ;

    private final ChatClient chatClient ;

    public CrisisDetectionResultDto analyze(String text) {
        // layer 1: keyword based detection
        // layer 2: AI based semantic analysis
        // combine signals - err on the side of caution
    }
}