package com.nexthoughts.issuetracker.dataTrack

import com.User
import com.nexthoughts.issuetracker.datatracker.EventVO
import com.nexthoughts.issuetracker.datatracker.MixPanel
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.web.json.JSONObject

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class WebTrackController {

    def springSecurityService

    def list = {
        String webPage = MixPanel.basicRestCall("https://mixpanel.com/api/2.0/engage")
        JSONObject obj = new JSONObject(webPage)
        println "=========================================================" + obj.getString("results")
        String eventType = "click nav a link"
        def userList = new JsonSlurper().parseText(obj.getString("results"))
        userList.each { println "USER=======================" + it }
        User user = springSecurityService.currentUser
        println("=========Current User========${user}")
        webPage = MixPanel.basicRestCall('https://data.mixpanel.com/api/2.0/export/?from_date=2016-09-24&to_date=2016-9-24')

        String[] webPageArray = webPage.split("}}")
        List<String> eventStringList = []
        String str = null
        webPageArray.each {
            it = it.replaceAll("\n", "")
            if (it != null && it.size() > 0) {
                str = it + "}}"
                eventStringList.add(str)
            }
        }
        JSONObject eventObj = new JSONObject(webPage);
        List eventList = []
        eventStringList.each {
            EventVO eventVO = new EventVO()
            eventObj = new JSONObject(it)
            eventVO.eventType = eventObj.event
            eventVO.eventId = eventObj.properties.id
            eventVO.firstName = eventObj.properties.first_name
            eventVO.lastName = eventObj.properties.last_name
            eventVO.userId = eventObj.properties.userId
            eventVO.userEmailId = eventObj.properties.email
            eventVO.url = eventObj.properties.url
            eventList.add(eventVO)
        }
        render(view: 'list', model: [totalUser: obj.getString("total"), userList: userList, user: user, eventList: eventList, eventType: "All Event", eventSize: eventList.size()])

    }
}
