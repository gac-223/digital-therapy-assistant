
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<UserSession> userSessions = new ArrayList<>() ;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DiaryEntry> diaryEntries = new ArrayList<>() ;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @Column(name = "email", unique = true, nullable = false)
    private String email ;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash ;

    @Column(name = "name")
    private String name ;

    @Column(name = "onboarding_complete")
    private Boolean onboardingComplete ;

    // create the enums and map to them ========
    @Enumerated(EnumType.STRING)
    @Column(name = "onboarding_path")
    private OnboardingPath onboardingPath ;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity_level")
    private SeverityLevel severityLevel ;
    // ========

    @Column(name = "streak_days")
    private Integer streakDays ;

    @Column(name = "created_at")
    private LocalDateTime createdAt ;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

}