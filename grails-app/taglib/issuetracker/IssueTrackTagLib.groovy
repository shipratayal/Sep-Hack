package issuetracker

class IssueTrackTagLib {
//    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def friendlyUrlService
    static namespace = "istrack"

    def convert = { attr, body ->
        out << body() << friendlyUrlService.sanitizeWithDashes(attr.value)
    }
}
