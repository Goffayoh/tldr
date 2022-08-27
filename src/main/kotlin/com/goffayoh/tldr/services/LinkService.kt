import org.springframework.stereotype.Service
import java.math.BigInteger

@Service
class LinkService(val linkRepository: LinkRepository) {

  fun createLink(url: String): LinkDto {


    url.hashCode()
    val link = linkRepository.save(Link())
  }

  companion object {
  }

}