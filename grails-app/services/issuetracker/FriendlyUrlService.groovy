package issuetracker

import grails.transaction.Transactional
import java.util.regex.Pattern


@Transactional
class FriendlyUrlService {
    static transactional = false

    def sanitizeWithDashes(text) {
        if (!text) return ""
        text = text.replaceAll('%([a-fA-F0-9][a-fA-F0-9])', '---$1---')
        text = text.replaceAll('%', '')
        text = text.replaceAll('---([a-fA-F0-9][a-fA-F0-9])---', '%$1')
        text = removeAccents(text)
        text = text.toLowerCase()
        text = text.replaceAll('&.+?;', '')
        text = text.replaceAll('\\.', '')
        text = text.replaceAll('[^%a-zA-Z0-9 _-]', '')
        text = text.trim()
        text = text.replaceAll('\\s+', '-')
        text = text.replaceAll('-+', '-')
        if (!text[-1].charAt(0).isLetterOrDigit()) text = text[0..-2]
        return text
    }

    private def removeAccents(text) {
        java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
    }
}
