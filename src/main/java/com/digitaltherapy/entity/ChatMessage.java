@Entity
@Table(name = "chat_message")
@Data
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_session_id", nullable = false)
    @JsonIgnore
    private UserSession user ;

    @Enumerated(EnumerationType.STRING)
    @Column(name = "role")
    private Role role = Role.USER;

    @Column(name = "content")
    private String content ;

    @Enumerated(EnumerationType.STRING)
    @Column(name = "modality")
    private Modality modality = Modality.TEXT ;

    @Column(name = "timestampe")
    private LocalDateTime timestamp ;

}