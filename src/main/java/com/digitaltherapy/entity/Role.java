
public enum Role {
    USER("User"),
    ASSISTANT("Assistant") ;

    private String displayName ;

    private Role(String displayName) {
        this.displayName = displayName
    }

    public String getDisplayName {
        return this.displayName ;
    }

    @Override
    public String toString() {
        return this.displayName ;
    }

}