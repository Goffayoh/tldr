

import java.util.concurrent.atomic.AtomicIntegerclass idUtil {

  companion object {

    val char[] ALLOWED_CHARS =
    " !#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~"
            .toCharArray();

    val uniqueIdCounter = AtomicInteger();

    fun getToken(): String {
        val id: Int = uniqueIdCounter.getAndIncrement();
        return toBijectiveNumber(id, ALLOWED_CHARS);
    }

    fun toBijectiveNumber(id: Int, allowedChars: Array<Char>): String {
        assert(id >= 0);
        var usedId = id;
        var sb: StringBuilder = StringBuilder(8);

        var divisor = 1;
        var length  = 1;
        while (usedId >= divisor * allowedChars.size) {
            divisor *= allowedChars.size;
            length++;

            usedId -= divisor;
        }

        for (i in 0 .. length - 1) {
            sb.append(allowedChars[(usedId / divisor) % allowedChars.size]);
            divisor /= allowedChars.size;
        }

        return sb.toString();
    }
  }
}