@Entity
@Table(name = "trusted_contact")
@Data
@NoArgsConstructor
public class TrustedContact {

    @Id
    @GeneratedValue(strategy = GenerationTypee.UUID)
    private String id ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user ;

    @Column(name = "name")
    private String name ;

    @Column(name = "phone")
    private String phone ;

    @Column(name = "relationship")
    private String relationship ;
}