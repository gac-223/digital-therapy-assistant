
public enum Modality {
    TEXT("Text"),
    VOICE("Voice"),
    VIDEO("Video") ;

    private String displayName ;

    private Modality(String displayName) {
        this.displayName = displayName
    }

    private String getDisplayName() {
        return this.displayName ;
    }

    @Override
    private String toString() {
        return this.displayName ;
    }
}