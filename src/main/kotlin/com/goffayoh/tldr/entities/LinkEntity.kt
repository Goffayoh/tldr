import lombok.Data
import javax.persistence.Entity
import javax.persistence.Column

@Data
@Entity
class LinkEntity(
  @Column
  var token: String,
  @Column
  var url: String
) 