import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LinkRepository: CrudRepository<LinkEntity, String> {

}