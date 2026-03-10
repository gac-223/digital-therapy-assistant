public enum Status {
    IN_PROGRESS("IN PROGRESS"),
    COMPLETED("COMPLETED"),
    EARLY_EXIT("EARLY EXIT") ;

    private String displayName ;

    private Status(string displayName) {
        this.displayName = displayName ;
    }

    public String getDisplayName() {
        return this.displayName ;
    }

    @Override
    public String toString() {
        return this.displayName
    }
}